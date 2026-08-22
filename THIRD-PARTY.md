# Third-Party Notices

> **Draft** — verify each license, version, and URL against the actual jar's
> `META-INF` / project site before publishing. Portico's license in particular
> must be confirmed (see note below).

MMS TestTool redistributes the following third-party components, located in
`TestTool/lib/`. Each remains under its own license; the terms below apply to
those components only, not to MMS TestTool itself.

| Component | Version | License | Project |
| --- | --- | --- | --- |
| Apache Commons BeanUtils | 1.9.4 | Apache-2.0 | https://commons.apache.org/proper/commons-beanutils/ |
| Apache Commons Collections | 4.4 | Apache-2.0 | https://commons.apache.org/proper/commons-collections/ |
| Apache Commons Lang | 3.13.0 | Apache-2.0 | https://commons.apache.org/proper/commons-lang/ |
| Apache Commons Logging | 1.2 | Apache-2.0 | https://commons.apache.org/proper/commons-logging/ |
| Apache Commons Text | 1.11.0 | Apache-2.0 | https://commons.apache.org/proper/commons-text/ |
| Apache Log4j (1.2 API bridge) | 2.11.2 | Apache-2.0 | https://logging.apache.org/log4j/2.x/ |
| Apache Log4j API | 2.11.2 | Apache-2.0 | https://logging.apache.org/log4j/2.x/ |
| Apache Log4j Core | 2.11.2 | Apache-2.0 | https://logging.apache.org/log4j/2.x/ |
| OpenCSV | 5.9 | Apache-2.0 | https://opencsv.sourceforge.net/ |
| SLF4J API | 1.7.36 | MIT | https://www.slf4j.org/ |
| SLF4J reload4j binding | 1.7.36 | MIT | https://www.slf4j.org/ |
| Portico RTI | 2.1.4 | CDDL-1.0 (**verify**) | https://github.com/openlvc/portico |

## Notes

- **`mms-rti-client-4.2.0.jar`** — This is an IVIR component, **not** third-party
  open source, and is intentionally omitted from this table. Its licensing and
  redistribution status must be resolved separately before release.
- **Log4j 2.11.2** is affected by CVE-2021-44228 (Log4Shell) and related
  advisories. Upgrade to a patched 2.17.x+ release before publishing.
- **Portico** is distributed under the CDDL; confirm the exact version/terms in
  the jar or the Portico repository, and note that the CDDL has source-availability
  obligations for the Portico jar itself.
- `slf4j-reload4j` binds SLF4J to reload4j (an Apache-2.0 licensed successor to
  log4j 1.2). The SLF4J binding code is MIT; reload4j itself is Apache-2.0.

## Full license texts

Include the complete license texts referenced above before publishing:

- `licenses/Apache-2.0.txt`
- `licenses/MIT.txt`
- `licenses/CDDL-1.0.txt`
