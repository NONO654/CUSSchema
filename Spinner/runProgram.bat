set path=%path%;C:\enoviaV6R2015x\server\win_b64\code\bin
:A
echo off


echo *********************SPINNER-START*************************

mql -c "set context user creator;insert prog D:/CUSSchema/LibrarySpinner/Business/SourceFiles/CSDDCProgramJPO_mxJPO.java;compile prog CSDDCProgramJPO force;exec prog CSDDCProgramJPO -method runProgram;"

echo ------------------SPINNER-ERROR-START-----------------------
type .\logs\enoviadev\SpinnerError.log
echo -------------------SPINNER-ERROR-END------------------------

pause
goto A
