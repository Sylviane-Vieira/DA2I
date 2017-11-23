/** ICI les commentaires sur le fonctionnement de la classe */
public class TabDict<K,V> // implements  Dictionnaire<K,V> //, Iterable<K>
{
    private static final int INIT_SIZE = 100 ;       // taille initiale du tableau
    private Couple<K,V> [] associations ;            // tableau contenant les associations
    private int nbAssoc ;	// nombre d'elements effectivement presents dans le dictionnaire

    /** Crée une instance de dictionnaire vide */
    public TabDict() {
        nbAssoc = 0 ;
        associations = (Couple<K,V>[]) new Couple[INIT_SIZE] ;
    }
    
    // redimensionnement automatique du tableau en une taille double
    private void resize() {
	int taille_tab = associations.length*2;
	Couple<K,V> [] new_tab = (Couple<K,V>[]) new Couple[taille_tab];
	for (int i=0; i < associations.length; i++) {
	    new_tab[i] = associations[i];
	}
	associations = new_tab;
    }

    // ajoute une association à la première position libre (après avoir 
    // redimensionné le tableau si nécessaire)
    private void add(Couple<K,V> assoc) {
        if ((associations.length - nbAssoc) == 0) {this.resize();}
	else {
	    int newPos = nbAssoc++;
	    associations[newPos] = assoc;
	}	    
    }

    // enlève l'association à l'indice spécifié
    void remove(int index) {
        associations[index] = null;
	nbAssoc--;
    }

    // indice de l'association assoc ; -1 si elle est absente 
    private int indexOf(Couple<K,V> assoc) {
	for (int i = 0; i < associations.length; i++){
	    if (associations[i] == assoc) {return i;}
	}
	return -1;
    }
    
    // indice de l'association de clef c ; -1 si elle est absente
    private int indexOfClef(K c) {
       	for (int i = 0; i < associations.length; i++){
	    if (associations[i].) {return i;}
	    else
		return -1;
	}
    }

    // méthode nécessaire pour l'itérateur :
    // retourne la clef située à l'indice i, null si i incorrect
	//  K clefPourIndex(int i) {
	//	for (int i = 0; i < associations.length; i++){
	    
	//	}
	// }
    
    // IMPLÉMENTATION DE L'INTERFACE Dictionnaire
    

    // IMPLÉMENTATION DE L'INTERFACE Iterable (2e partie du TP)
    // /** Itérateur permettant de parcourir les clefs (et d'en supprimer) */
    // public Iterator<K> iterator() {
    //     return new DictIterator<K>(this) ;
    // }    
}
