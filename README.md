# MMS TestTool


TestTool is a Java Swing application that acts as an HLA (High Level Architecture)
federate for the Joint Emergency Trauma Simulation (JETS) federation. It is used to
manually inject, simulate, and monitor federation data — patients, injuries, lab
results, body fluids, events, and other objects/interactions — for testing other
federates without needing a full live simulation. It is not intended for use in real training exercises.

It connects to a federation using the [Portico](https://github.com/openlvc/portico)
RTI and the HLA 1516-2010 (Evolved) FOM modules included in this repository.

You can also view and download the [MMS FOM](https://github.com/ivir-inc/jets_mms_fom) separately.

For more information, please contact jets@ivirinc.com

For additional detail on JETS, see https://jets-systems.com/

## Features

- Join/resign an HLA federation and drive federation lifecycle state
- Create, updated, and receive simulated patients, injuries, labs, and body-fluids objects
- Send and monitor HLA interactions
- Advance/change simulation time
- Generate vital-signs data from CSV input
- Console-driven and GUI-driven command handling

## Requirements

- **Java** — JDK 17
- **Apache NetBeans** — the project is a NetBeans/Ant project (see `TestTool/build.xml`)
- **Portico RTI** `2.1.4` — install separately and set `RTI_HOME`
  (download from https://github.com/openlvc/portico)
- **`mms-rti-client` jar** — This is provided by IVIR inc.

Third-party libraries used by the tool are vendored in `TestTool/lib/`
(Apache Commons, log4j, slf4j, opencsv). See [`THIRD-PARTY.md`](THIRD-PARTY.md) for their licenses.

## Building

The project builds with Apache NetBeans (Ant). See [`TestTool/docs/build.md`](TestTool/docs/build.md)
for step-by-step instructions. In brief:

1. Open the `mms_testtool` project (the `TestTool` folder) in NetBeans.
2. Run **Clean and Build Project** to produce `TestTool/dist/TestTool.jar`.
3. In the **Files** tab, open `build.xml`, find the `packageTool` target, and
   run it to assemble the distributable in `dist/`.

## Running

Set `RTI_HOME` to your Portico installation, then use the provided launch scripts
from the directory containing `TestTool.jar`:

| Script | Platform | Notes |
| --- | --- | --- |
| `run.bat` / `run.sh` | Windows / Unix | Standard launch |
| `run_with_gateway.bat` / `run_with_gateway.sh` | Windows / Unix | Launch using `gatewayRTI.rid` |

Example (Unix):

```bash
export RTI_HOME=/home/myuser/portico-2.1.4
./run.sh
```

### Configuration

- **`FederateConfig.txt`** — federate/federation names, FOM module URLs, and
  optional CRC host/port overrides.
- **`gatewayRTI.rid`** — Portico RTI initialization data (logging, network,
  WAN/gateway settings). Adjust network settings for your environment before use. This is only needed for distributed federations. Local federations use the default **`rti.rid`** provided by the Portico installation.

## Repository layout

```
TestTool/
  src/com/ivir/mms/testtool/   Java source
  lib/                         Vendored third-party jars + log4j2.xml
  nbproject/                   NetBeans/Ant project files
  docs/                        Build and usage docs
  *.xml                        HLA FOM modules (Base, Patient, Communications, ...)
  FederateConfig.txt           Federate configuration
  gatewayRTI.rid               Portico RTI init data
  run*.bat / run*.sh           Launch scripts
```

## License

Licensed under the Apache License, Version 2.0 — see [`LICENSE`](LICENSE).

Bundled third-party components remain under their own licenses; see
[`THIRD-PARTY.md`](THIRD-PARTY.md).

