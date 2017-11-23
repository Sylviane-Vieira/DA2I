# transforme tous les caracteres en leur equivalent
# MAJUSCULE non accentues
transformeChar = function (char) {
  switch(char,
    à = 'A',
    ç = 'C',
    é = 'E',
    è = 'E',
    ê = 'E',
    ë = 'E',
    ï = 'I',
    î = 'I',
    ô = 'O',
    ö = 'O',
    û = 'U',
    ü = 'U',
    toupper(char)
    )
}

# definition de l'alphabet analyse 
# (par defaut l'alphabet des 26 lettres latines)
alphabet = c(strsplit(intToUtf8(c(65:90)),"")[[1]])


# fonction compteLettres donne le nombre de chacune
# des lettres de l'alphabet parmi les "longueur" caractères
# lus dans le fichier "nomFichier"
compteLettres = function(nomFichier, longueur) {
  z = file(nomFichier,"rb")
  charLus = readChar(z,n=longueur)
  close(z)
  charLus = strsplit(charLus,"")
  charLus = sapply(charLus[[1]],transformeChar,USE.NAMES=FALSE)
  table(factor(charLus,levels=alphabet))
}
