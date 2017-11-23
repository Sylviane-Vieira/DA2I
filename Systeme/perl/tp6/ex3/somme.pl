#!/usr/bin/perl
use strict;
use warnings;

my $somme=0;
for (my $i=0;$i< @ARGV; $i++){$somme+=$ARGV[$i];}
print $somme."\n";

