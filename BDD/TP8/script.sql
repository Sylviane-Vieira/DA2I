-- 3 colonnes de type int,text,date
create table tb3cols (c1 int primary key, c2 text, c3 date);
insert into tb3cols values(1,'paul','2018-01-01');

-- 5 colonnes de type int,text,date,text,text
create table tb5cols (c1 int primary key, c2 text ,c3 date ,c4 text,c5 text);
insert into tb5cols values(1,'paul','2018-01-01','xxx','yyy');
