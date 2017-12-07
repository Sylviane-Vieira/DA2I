#!/usr/bin/perl

use strict;
use warnings;
use Socket;
use POSIX ":sys_wait_h";

my $n = $ARGV[0];
my $pere = $$;

for (my $i=0; $i<$n; $i++){
  my $fils = fork();
  #if ($fils != 0) {
    print "\ncréation du processus fils de pid $fils de père $$\n";
    #`chmod +x ./rien.pl`;
    #print `./rien.pl`;
    my $recup = (waitpid($fils, &WNOHANG));
    if ($recup == $fils)
      { print "\nRecuperation du fils $fils\n";}
  #}
}
