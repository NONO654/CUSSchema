
set BOOTFILE=matrix-r
echo off

:A





echo *********************SPINNER-START*************************


mql -c "set context user creator;import prog * overwrite from file ./TGISpinnerProgram.exp;"

echo SPINNER PROGRAM UPDATED, STARTING SPINNER...

mql -c "set context user creator;exec prog emxSpinner.tcl;"

echo ------------------SPINNER-ERROR-START-----------------------
type .\logs\*Error.log
echo -------------------SPINNER-ERROR-END------------------------

pause
goto A
