#!/usr/bin/perl

use strict;
use warnings;
use Socket;

my $n = $ARGV[0];
my $pere = $$;

for (my $i = 1; $i<$n; $i++){
  my $fils = fork();
  if ($fils != 0) {
    print "je suis le pere de pid : $pere, mon fils est : $fils\n";
  }
}
