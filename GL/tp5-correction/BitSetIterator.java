import java.util.* ;

/**
 * Cette classe permet de parcourir les éléments (entiers marqués à
 * vrai) d'un BitSet de façon séquentielle.
 */
public class BitSetIterator implements Iterator<Integer>
{
    // le bitset qu'on veut parcourir
    private BitSet bs ;
    // indices nécessaires pour le parcours
    private int current, last ;

    /** Crée un itérateur sur le BitSet spécifié */
    public BitSetIterator(BitSet b)
    {
	bs = b ;
	// on repère le premier indice marqué à vrai (-1 si aucun)
	current = bs.nextSetBit(0) ;	
	last = -1 ;
    }
    
    /** Indique s'il reste des indices à true dans le bitset */
    public boolean hasNext() 
    {
	// il y en a sauf si l'appel à nextSetBit a renvoyé -1
	return current >= 0 ;
    }

    /** Retourne le premier indice restant du BitSet pour lequel on a true */
    public Integer next() 
    {
	// il faut vérifier évidemment qu'il reste des indices
	if (this.hasNext())
	    {
		// current contient déjà cet indicxe
		Integer i = current ;
		// on met à jour last pour se souvenir de celui qu'on va retourner
		last = current ;
		// on met à jour current en cherchant le suivant
		current = bs.nextSetBit(current+1) ;
		return i ;
	    }
	return null ;
    }

    /** Met à false dans le BitSet le dernier indice retourné par next() */
    public void remove()
    {
	// Ça ne peut se faire que s'il y avait bien un indice
	// précédent. De plus si on fait plusieurs appels successifs à
	// remove() sans faire de next() ça ne doit pas avoir de
	// conséquence.
	if (last >= 0)
	    {
		bs.clear(last) ;
	    }
    }
}