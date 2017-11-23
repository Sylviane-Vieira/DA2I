#!/usr/bin/perl
use strict;
use warnings;

my $i = $ARGV[0];
my $factorielle = 1;
for (1..$i) { $factorielle *= $_; }
print $factorielle, "\n";
