
--tous les pilotes qui habitent la meme ville que Dupont
select *
from pilote
where adresse = (
      select adresse
      from pilote
      where nom = 'Dupont');

select p2.nom, p2.prenom
from pilote p1, pilote p2
where p1.nom = 'Dupont' and p2.adresse = p1.adresse;


--lister les avions qui ont plus de places que le plus gros porteur de chez Air France
select * from avion
where places > (
select max(places) from avion
where compagnie = 'Air France');

--Afficher le nb d'avions qui posèdent le maximum de places dans notre base 
select count(*)
from avion
where places in(
select max(places)
from avion);
