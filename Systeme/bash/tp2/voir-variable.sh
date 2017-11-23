#!/bin/bash

echo 'Entrez le nom de la variable'
read var
while [ -z $var ] || expr $var != 'FINI' >&/dev/null
do
    echo 'Entrez le nom de la variable'
    read var
done
