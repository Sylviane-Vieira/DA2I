#!/bin/bash

read var

while expr $var != 'oui'>&/dev/null && expr $var != 'non'>&/dev/null
do
    read var
    echo $var
done

   
