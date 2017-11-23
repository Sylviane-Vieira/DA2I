#!/bin/bash

compteur=0
for i in "$@"
do
    compteur=`expr "$compteur" + 1`
    echo "L'argument" $compteur "est" $i
done

