#!/usr/bin/perl

use strict;
use warnings;
use Socket;

my $host = $ARGV[0];
my $chemin = $ARGV[1];

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));
my $adresse = inet_aton ("$host") || die ("inet_aton");
my $adresse_complete = sockaddr_in("80",$adresse) || die ("sockaddr_in");
connect (SERVEUR, $adresse_complete) || die ("connect");

select (SERVEUR);
$| = 1; #envoie des données instantanées
select (STDOUT);

print SERVEUR "GET /$chemin HTTP/1.1\r\nHost: $host\r\n\r\n";

while(<SERVEUR>){
  print $_;
}
close (SERVEUR);
#telnet localhost 7777

#$SIG{"CHLD"} = "finfils";
#while (1){
#accept(CLIENT, SERVEUR) or next; #si accept fait une ereur je reviens dans while
#if (fork() == )  #traitement du client => quitter dès que le client est déconnecté
  #exit(0);
#}
#père
#close(CLIENT);
#tant que le père n'appelle pas waitpid, le fils est zombie
#
#sub finfils{
#terminer les zombies
#while (waitpid(-1, WHNOHANG)){
#...
#}

}
