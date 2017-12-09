#!/usr/bin/perl

use strict;
use warnings;

my $n = $ARGV[0];
my $pere = $$;
my @pids = ();

while (@pids<=$n){
  if (<>){
    my $fils = fork();
    if ($fils == 0) {
    print "création du processus fils de pid $$ de père $pere\n";
    exec ("perl rien.pl");
    }
    push @pids, $fils;
    print "@pids\n";
    if (kill(17, $pere) && @pids == $n){
      splice @pids, $_, 1 ;
    }
  }
}
