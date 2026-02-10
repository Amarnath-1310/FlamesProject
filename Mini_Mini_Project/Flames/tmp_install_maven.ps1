$dest = Join-Path $env:USERPROFILE '.maven'
if(-not (Test-Path $dest)) { New-Item -ItemType Directory -Path $dest | Out-Null }
$zip = Join-Path $env:TEMP 'apache-maven-3.9.12-bin.zip'
Invoke-WebRequest -Uri 'https://dlcdn.apache.org/maven/maven-3/3.9.12/binaries/apache-maven-3.9.12-bin.zip' -OutFile $zip -UseBasicParsing
Expand-Archive -Path $zip -DestinationPath $dest -Force
Remove-Item $zip
$possible1 = Join-Path $dest 'apache-maven-3.9.12\apache-maven-3.9.12\bin'
$possible2 = Join-Path $dest 'apache-maven-3.9.12\bin'
if (Test-Path $possible1) { $mvndir = $possible1 } elseif (Test-Path $possible2) { $mvndir = $possible2 } else { Write-Error 'Maven bin not found'; exit 1 }
$env:Path = $mvndir + ';' + $env:Path
& (Join-Path $mvndir 'mvn.cmd') -v
Write-Output $mvndir | Out-File -FilePath (Join-Path $env:TEMP 'maven_bin_path.txt') -Encoding utf8
