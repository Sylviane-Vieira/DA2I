#! /bin/bash

tag=$1
fichier=$2

for fichier in $@; do
    
    fichier=$2
    if  [ -e $HOME/tags/$tag/$fichier ]
    then
	rm -i $HOME/tags/$tag/$fichier
    fi
    shift
done
