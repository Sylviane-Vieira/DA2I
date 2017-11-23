Drop table commandes;
Drop table produits;
Drop table fournisseurs;

Create table fournisseurs(
fno serial,
nom text,
ville text,
constraint pk_fournissseurs primary key (fno)
);

Create table produits (
pno serial,
libelle text,
prix integer,
constraint pk_produits primary key (pno)
);

Create table commandes (
cno serail,
pno serial,
fno serial,
qte integer,
constraint pk_commandes primary key (cno, fno, pno),
constraint fk_fournisseurs foreign key (fno) references fournisseurs (fno)
on delete restrict on update cascade,
constraint fk_produits foreign key (pno) references produits (pno)
on delete restrict on update cascade
);
