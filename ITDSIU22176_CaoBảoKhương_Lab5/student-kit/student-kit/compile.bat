@echo off
setlocal

set ROOT_DIR=%~dp0
if "%ROOT_DIR:~-1%"=="\" set ROOT_DIR=%ROOT_DIR:~0,-1%

if not exist "%ROOT_DIR%\out" mkdir "%ROOT_DIR%\out"

javac --release 17 -cp "%ROOT_DIR%\lib\micromouse-framework.jar" ^
  -d "%ROOT_DIR%\out" ^
  "%ROOT_DIR%\src\student\StudentSolverImpl.java"

if errorlevel 1 exit /b 1

echo Compiled student solver to %ROOT_DIR%\out
