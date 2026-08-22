# Vital Signs Synthetic Data Generator (multi-sequence)

This Python script generates synthetic vital-sign CSVs compatible with IVIR’s linear validation inputs. It simulates realistic variations in vitals over a configurable time window and frequency, and (optionally) overwrites one integer vital column with a strictly increasing sequence to serve as a per-patient primary key.

---

## 📦 Setup (Python virtual env recommended)

```bash
python3 -m venv venv
source venv/bin/activate
pip install pandas numpy
```

---

## 🔧 Usage

```bash
python3 generate_vital_signs_multi_seq.py [options]
```

### Most common flags

```bash
# 60 seconds at 10 Hz, one file, default sequence in heartRate starting at 1
python3 generate_vital_signs_multi_seq.py --duration 60 --frequency 10
```

### Full argument list

| Flag | Description | Type | Default |
|---|---|---:|---:|
| `--duration` | Total duration of the test (seconds) | int | `30` |
| `--frequency` | Samples per second (Hz) | int | `10` |
| `--count`, `-n` | Number of CSV files to generate | int | `1` |
| `--id-len` | Length of the random `patientId` (hex) | int | `8` |
| `--out-dir` | Output directory | path | your home dir |
| `--seq-into` | Integer column to overwrite with a monotonic sequence; one of `heartrate`, `diastolicbloodpressure`, `systolicbloodpressure` | choice | `heartrate` |
| `--seq-start` | Starting value for the sequence written into the `--seq-into` column | int | `1` |

> ⚠️ `--duration`, `--frequency`, and counts must be positive integers. The generator uses fixed-interval timestamps based on `1000 / frequency` milliseconds.

---

## 📁 Output

Each run writes one or more CSV files to `--out-dir`. Filenames include duration, frequency, and a short patient ID:

```
a_VitalSigns_linear_<duration>_sec_<frequency>_hz_<patientId>.csv
```

**Examples**

```bash
# Single file, defaults (30s @ 10 Hz) → home directory
python3 generate_vital_signs_multi_seq.py

# Three files to ./out, patient IDs of length 10
python3 generate_vital_signs_multi_seq.py -n 3 --out-dir ./out --id-len 10

# Write the sequence into systolic BP, starting at 5001
python3 generate_vital_signs_multi_seq.py --seq-into systolicbloodpressure --seq-start 5001
```

---

## ✅ CSV Schema

Each row is one physiological sample. Timestamps are integer milliseconds from 0. The first row includes the time unit; subsequent rows leave `timeUnit (unitTimeEnum)` blank.

| Column header | Notes |
|---|---|
| `patientId (HLAASCIIstring)` | Random hex ID per file (length = `--id-len`) |
| `heartRate (Integer32BE)` | Simulated wave; **may be overwritten** by the sequence if `--seq-into heartrate` |
| `diastolicBloodPressure (Integer32BE)` | Simulated wave; **may be overwritten** if selected |
| `systolicBloodPressure (Integer32BE)` | Simulated wave; **may be overwritten** if selected |
| `peripheralOxygenSaturation (FloatType32BE)` | Values ~0.98 with small variation |
| `temperatureFahrenheit (FloatType32BE)` | Values around 98.6 with small variation |
| `respirationEndTidalCarbonDioxide (FloatType32BE)` | Small oscillation |
| `respirationRate (FloatType32BE)` | Values around ~16 with variation |
| `simTime (HLAinteger64Time)` | `0, Δt, 2Δt, …` in **milliseconds**, where `Δt = int(1000 / frequency)` |
| `timeUnit (unitTimeEnum)` | `"MILLISECONDS"` on the first row only |

> The monotonic sequence is written **only** into the integer column chosen via `--seq-into`; this can be used as a per-patient primary key. All other vitals are generated deterministically from sines/cosines for reproducibility given the same duration/frequency.

---

## 🔍 Implementation Notes

- Signals are deterministic sinusoidal/cosinusoidal waves with small amplitudes around typical physiological set points.
- Multiple outputs reuse no patient IDs within a single run.
- The `timeUnit` convention follows IVIR linear test format: unit specified once in row 1.

---

## 🧪 Quick sanity check

After generating a file, you should see a success message with the full path. For multiple files, all paths are listed.

```
✅ CSV files written:
 - /.../a_VitalSigns_linear_60_sec_10_hz_ab12cd34.csv
 - /.../a_VitalSigns_linear_60_sec_10_hz_ef56a789.csv
 ...
```

---

### Changelog (relative to earlier single-file script)

- Supports **multi-file** generation via `--count/-n`.
- Adds **per-patient short IDs** with configurable length (`--id-len`).
- Lets you choose which **integer vital** receives the strictly **increasing sequence** (`--seq-into`) and where to **start** it (`--seq-start`).
- Output filename now includes the **patient ID** suffix.
