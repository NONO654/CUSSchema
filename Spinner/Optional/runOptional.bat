set PATH=%PATH%;../Subversion/bin
:A

svn up


mql -c "set context user creator;exec prog emxSpinner.tcl;"

pause
goto A
