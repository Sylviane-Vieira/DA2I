#!/bin/bash

function csvhtml () {

 local sep = $2
    
echo '<!DOCTYPE html>';
echo '<html lang="fr">';
echo '<head>';
echo '<meta charset="utf-8">';
echo '</head>';

echo '<body>';
echo '<table border=2 cellspacing=10 cellpadding=20>';
 sed -e '1s/^/<tr><th>/' -e '1s/'$sep'/<\/th>\<th>/g' -e '2,/Fin/s/^/<tr><td>/g' -e '2,/Fin/s/'$sep'/<\/td><td>/g' bieres.csv ;
 echo '</table>';
 echo '</body>';
 echo '<html>';

}

if [$1 = "-d"]
then
    $sep = $2
else
    $sep
fi
#le séparateur est le deuxième argument
csvhtml -d ';' >csv2.html
