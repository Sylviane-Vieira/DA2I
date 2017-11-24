#!/usr/bin/perl

use strict;
use warnings;
use Socket;

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));

my $adresse = inet_aton ("localhost") || die ("inet_aton");

my $adresse_complete = sockaddr_in("3000",$adresse) || die ("sockaddr_in");

connect (SERVEUR, $adresse_complete) || die ("connect");

while (<SERVEUR>) {
  print $_;
}

close (SERVEUR);
