#!/usr/bin/perl

use strict;
use warnings;
use Socket;
use POSIX ":sys_wait_h";

my $n = $ARGV[0];
my $pere = $$;
my @pids = ();

foreach (1..$n){

  my $fils = fork();
  if ($fils == 0) {
    print "\ncréation du processus fils de pid $$ de père $pere\n";
    exec ("perl rien.pl");
  }
    push @pids, $fils;
}

foreach (@pids){
  my $recup = waitpid($_, 0);
    print "\nRecuperation du fils $_\n";
}
