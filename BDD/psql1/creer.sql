DROP TABLE vol;
DROP TABLE ligne;
DROP TABLE pilote;
DROP TABLE avion;


CREATE TABLE avion (
ano SERIAL,
type TEXT,
places INTEGER check(places between 100 and 200),
compagnie TEXT,
constraint pk_avion PRIMARY KEY (ano)
);

CREATE TABLE pilote (
pno SERIAL,
nom TEXT,
prenom TEXT,
adresse TEXT DEFAULT 'Lille',
constraint pk_pilote PRIMARY KEY (pno)
);

CREATE TABLE ligne (
lno SERIAL,
depart TEXT,
arrivee TEXT,
constraint pk_ligne PRIMARY KEY (lno)
);

CREATE TABLE vol (
ano SERIAL,
pno SERIAL,
lno SERIAL,
hdep TIME,
harr TIME,
constraint pk_vol PRIMARY KEY (ano, pno, lno),
constraint fk_avion foreign key (ano) references avion (ano)
on delete restrict on update cascade,
constraint fk_pilote foreign key (pno) references pilote (pno)
on delete restrict on update cascade,
constraint fk_ligne foreign key (lno) references ligne (lno)
on delete restrict on update cascade
);

INSERT INTO avion (type, places, compagnie)
VALUES ('A310', 180, 'Air France'), ('A380', 150, 'RyanAir'), ('A210', 153, 'Air France'), ('A320', 180, 'Air France'), ('A12',200 , 'RyanAir'), ('A350', 132, 'Air France'), ('A360',200 , 'Air France'), ('A330', 200, 'Air France');
INSERT INTO pilote (nom, prenom, adresse)
VALUES ('Diabat', 'Melvin', 'Tourcoing'), ('Decot', 'Julien', 'Wazemmes'), ('Veny', 'Vezan', 'Lille'), ('Dupont', 'Jean', 'Tourcoing'), ('Bazar', 'Andre', 'Tourcoing'), ('Veny', 'Vezan', 'Lille');
INSERT INTO ligne (depart, arrivee)
VALUES ('Lille', 'Paris'), ('Bruxelles', 'Paris'), ('Bordeaux', 'Nantes');
INSERT INTO vol (pno, lno, hdep, harr)
VALUES (1, 1, '10:23', '11:02');
--UPDATE pilote set pno=2 where pno=1;
--DELETE FROM avion where ano=1;
--CREATE TEMP TABLE copievol
--AS SELECT * from vol;
--DELETE FROM vol;
