#!/bin/bash

inode=$1
fichiers=`ls -i $HOME/tags/*` 
fichier=`ls -i | grep "$1" | awk '{print $2}'`
set -x
for fichier in fichiers
do
    if [ -e $fichier ]
    then
	readlink -f $fichier
    fi
done
