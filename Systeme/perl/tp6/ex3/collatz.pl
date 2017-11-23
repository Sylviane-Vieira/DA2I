#!/usr/bin/perl
use strict;
use warnings;

my $i= $ARGV[0];

if (@ARGV==1 && $i<=1){$i=1; print $i, "\n";}
while (@ARGV==1 && $i != 1){
    if ($i%2==0){$i=$i/2; print $i, "\n";}
    else
    {
	$i=(3*$i)+1; print $i, "\n";
    }
}
