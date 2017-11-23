#! /usr/bin/perl
use strict;
use warnings;

my $users = `who | wc -l`;
print "Nombre d'utilisateurs connectés : $users ";
