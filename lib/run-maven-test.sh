#!/bin/bash
echo "params=\"$1\" \"$2\" \"$3\" \"$4\" \"$5\""
mvn surefire:test -Dreport.dir="$1" -Dtest.dir="$2" -Dbrowser="$3" -Dopenonce=$4 -Dsurefire.reportNameSuffix="$5"