#!/usr/bin/perl

use strict;
use warnings;
use Socket;

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));
setsockopt (SERVEUR, SOL_SOCKET, SO_REUSEADDR, 1);

my $adresse = sockaddr_in ("7777", INADDR_ANY);

bind (SERVEUR, $adresse) || die("bind");

listen (SERVEUR, SOMAXCONN) || die ("listen");

while (1){
  accept (CLIENT, SERVEUR) || die ("accept");
  select (CLIENT);
  $| = 1;
  while(<CLIENT>){
    print;
  }
close (CLIENT);
}
close (SERVEUR);