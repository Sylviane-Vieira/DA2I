import java.util.* ;

/** Cette classe reconstruit un itérateur pour parcourir un ArrayList */
public class IteratorPourArrayList<E> implements Iterator<E>
{
    // la liste que l'on veut parcourir
    private ArrayList<E> liste ;
    // la position dans la liste
    private int position = 0 ;
    // un booléen pour se souvenir si on a appelé next() 
    // important pour le bon fonctionnement de remove()
    private boolean appelANext = false ;

    /** Crée une instance d'itérateur pour parcourir la liste spécifiée */
    public IteratorPourArrayList(ArrayList<E> l)
    {
	liste = l ;
    }
    
    /** Indique s'il reste des éléments à lire */
    public boolean hasNext() 
    {
	// il reste des choses si l'on n'est pas à la fin
	return position < liste.size() ;
    }

    /** Retourne le prochain élément à lire */
    public E next() 
    {
	// d'abord s'assurer qu'il en reste
	if (this.hasNext())
	    {
		// signaler qu'on a fait un appel à next() (pour remove)
		appelANext = true ;
		// on lit directement l'élément au bon indice
		E o = liste.get(position) ;
		// on incrémente l'indice
		position++ ;
		// et on retourne l'élément qu'on vient de lire
		return o ;
	    }
	return null ;
    }

    /** Supprime dans la liste le dernier élément lu par next() */
    public void remove()
    {
	// il faut 1) avoir fait appel à next 2) que l'indice position soit correct
	if (appelANext && (position > 0) && (position-1<liste.size()))
	    {
		// on désactive le booléen pour ne pas faire un remove
		// sur une autre position (il faudra d'abord à nouveau
		// appeler next)
		appelANext = false ;
		// on efface dans la liste à la position précédente
		liste.remove(position-1) ;
		// puis on met à jour position
		position-- ;
	    }
    }
}