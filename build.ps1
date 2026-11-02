$ErrorActionPreference = "Stop"
mvn clean verify
if ($LASTEXITCODE -ne 0) { throw "Build failed" }
