
import pandas as pd
import numpy as np
import argparse
import uuid
from pathlib import Path

# Column headers per your FOM naming
INT_COLS = {
    "heartrate": "heartRate (Integer32BE)",
    "diastolicbloodpressure": "diastolicBloodPressure (Integer32BE)",
    "systolicbloodpressure": "systolicBloodPressure (Integer32BE)",
}

FLOAT_COLS = {
    "peripheraloxygensaturation": "peripheralOxygenSaturation (FloatType32BE)",
    "temperaturefahrenheit": "temperatureFahrenheit (FloatType32BE)",
    "respirationendtidalcarbondioxide": "respirationEndTidalCarbonDioxide (FloatType32BE)",
    "respirationrate": "respirationRate (FloatType32BE)",
}

TIME_COL = "simTime (HLAinteger64Time)"
TIMEUNIT_COL = "timeUnit (unitTimeEnum)"
PATIENT_COL = "patientId (HLAASCIIstring)"

def generate_vital_signs(duration_sec: int, frequency_hz: int, patient_id: str, seq_into_key: str = "heartrate", seq_start: int = 1) -> pd.DataFrame:
    interval_ms = int(1000 / frequency_hz)
    times = np.arange(0, duration_sec * 1000, interval_ms, dtype=np.int64)

    # Simulated signals (deterministic for a given duration/frequency)
    heart_rate_wave = 70 + 5 * np.sin(0.1 * times / 1000.0)
    systolic = 120 + 3 * np.sin(0.08 * times / 1000.0)
    diastolic = 80 + 2 * np.cos(0.09 * times / 1000.0)
    spo2 = 0.98 + 0.005 * np.sin(0.07 * times / 1000.0)
    temp = 98.6 + 0.05 * np.sin(0.05 * times / 1000.0)
    etco2 = 0.05 + 0.005 * np.cos(0.06 * times / 1000.0)
    resp_rate = 16 + 1.5 * np.sin(0.1 * times / 1000.0)

    # Build DataFrame
    data = {
        PATIENT_COL: [patient_id] * len(times),
        INT_COLS["heartrate"]: heart_rate_wave.astype(int),  # will be overwritten below by the sequence
        INT_COLS["diastolicbloodpressure"]: diastolic.astype(int),
        INT_COLS["systolicbloodpressure"]: systolic.astype(int),
        FLOAT_COLS["peripheraloxygensaturation"]: np.round(spo2, 4),
        FLOAT_COLS["temperaturefahrenheit"]: np.round(temp, 2),
        FLOAT_COLS["respirationendtidalcarbondioxide"]: np.round(etco2, 4),
        FLOAT_COLS["respirationrate"]: np.round(resp_rate, 2),
        TIME_COL: times,
        TIMEUNIT_COL: ["MILLISECONDS"] + [""] * (len(times) - 1),
    }
    df = pd.DataFrame(data)

    # Overwrite the selected integer column with a monotonic sequence (primary key)
    seq_col_header = INT_COLS.get(seq_into_key.lower())
    if seq_col_header is None:
        raise ValueError(f"--seq-into must be one of: {', '.join(sorted(INT_COLS))} (got: {seq_into_key})")
    df[seq_col_header] = np.arange(seq_start, seq_start + len(times), dtype=int)

    return df

def make_short_uuid(n: int = 8) -> str:
    return uuid.uuid4().hex[:n]

def main():
    parser = argparse.ArgumentParser(
        description="Generate one or more synthetic vital-signs CSVs. Overwrites an integer column (default: heartRate) with a strictly increasing sequence to act as a per-patient primary key."
    )
    parser.add_argument("--duration", type=int, default=30, help="Test duration in seconds")
    parser.add_argument("--frequency", type=int, default=10, help="Sampling frequency in Hz")
    parser.add_argument("--count", "-n", type=int, default=1, help="Number of output files to create (default: 1)")
    parser.add_argument("--id-len", type=int, default=8, help="Length of short random patientId (default: 8)")
    parser.add_argument("--out-dir", type=Path, default=Path.home(), help="Directory to write files into (default: your home directory)")

    # Sequence options
    parser.add_argument("--seq-into", choices=sorted(INT_COLS), default="heartrate",
                        help="Integer column to overwrite with the monotonic sequence (default: heartrate)")
    parser.add_argument("--seq-start", type=int, default=1, help="Starting integer for the sequence (default: 1)")
    args = parser.parse_args()

    args.out_dir.mkdir(parents=True, exist_ok=True)

    used_ids = set()
    written = []

    for _ in range(args.count):
        pid = make_short_uuid(args.id_len)
        while pid in used_ids:
            pid = make_short_uuid(args.id_len)
        used_ids.add(pid)

        df = generate_vital_signs(
            duration_sec=args.duration,
            frequency_hz=args.frequency,
            patient_id=pid,
            seq_into_key=args.seq_into,
            seq_start=args.seq_start
        )

        out_path = args.out_dir / f"a_VitalSigns_linear_{args.duration}_sec_{args.frequency}_hz_{pid}.csv"
        df.to_csv(out_path, index=False)
        written.append(str(out_path))

    if len(written) == 1:
        print(f"✅ CSV file written to: {written[0]}")
    else:
        print("✅ CSV files written:")
        for w in written:
            print(" -", w)

if __name__ == "__main__":
    main()
