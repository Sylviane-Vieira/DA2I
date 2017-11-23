#! /bin/bash
    
tag=$1
for fichier in $@; do

    fichier=$2
    if [ ! -d $HOME/tags/$tag ]
    then
	mkdir $HOME/tags/$tag
    fi
    if [ ! -e $HOME/tags/$tag/$fichier ]
    then
	ln $fichier $HOME/tags/$tag/
    fi
    shift
done
    
