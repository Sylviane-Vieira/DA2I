#!/bin/bash

find $HOME/tags/ -inum $1 -print | head -n1
