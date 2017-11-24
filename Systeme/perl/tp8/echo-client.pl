#!/usr/bin/perl

use strict;
use warnings;
use Socket;

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));

my $adresse = inet_aton ("localhost") || die ("inet_aton");

my $adresse_complete = sockaddr_in("7",$adresse) || die ("sockaddr_in");

connect (SERVEUR, $adresse_complete) || die ("connect");

select (SERVEUR);
$| = 1; #envoie des données instantanées
select (STDOUT);

while (<STDIN>){
  print SERVEUR $_;
  my $reponse = <SERVEUR>;
  print $reponse;
}

close (SERVEUR);
