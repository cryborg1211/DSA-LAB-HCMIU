@echo off
setlocal

set ROOT_DIR=%~dp0
if "%ROOT_DIR:~-1%"=="\" set ROOT_DIR=%ROOT_DIR:~0,-1%

call "%ROOT_DIR%\compile.bat"
if errorlevel 1 exit /b 1

java -cp "%ROOT_DIR%\lib\micromouse-framework.jar;%ROOT_DIR%\out" mazechallenge.Main student.StudentSolverImpl
