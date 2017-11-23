#! /usr/bin/perl
use strict;
use warnings;


#my $fichiers = `cat @ARGV`;
#print $fichiers;

my $i;
for ($i=0; $i < @ARGV; $i++)
{
    open(HAND, $ARGV[$i]);
    while (<HAND>) {print;}
}
    
    

