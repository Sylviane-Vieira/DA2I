/** Une implémentation de l'interface Pile utilisant un tableau. À
 * noter : cette classe reste générique. */
public class PileHanoi<E> implements Pile<E> {

    private E [] elements ;
    private int nbElem = 0 ;
    private String nom = "la pile" ;

    /** Constructeur qui crée une pile vide */
    public PileHanoi() {
	elements = (E[]) new Object[MAX_ELEMENTS] ;
    }

    /** Constructeur qui crée une pile vide et lui donne un nom */
    public PileHanoi(String nom) {
	elements = (E[]) new Object[MAX_ELEMENTS] ;
	this.nom = nom ;
    }


    
    ////////////////////////////////////////////
    //                                        //
    //   IMPLEMENTATION DE L'INTERFACE PILE   //
    //                                        //
    ////////////////////////////////////////////
    
    /** teste si la pile est vide */
    public boolean vide() {
	return (nbElem == 0) ;
    }
    
    /** teste si la pile est pleine */
    public boolean pleine () {
	return (nbElem == MAX_ELEMENTS) ;
    }
    
    /** teste si la pile peut empiler x */
    public boolean peutEmpiler (E x) {
	return (!pleine()) ;
    }
    
    /** renvoie la valeur de l'objet sur le sommet de la pile */
    public E sommet() {
	if (vide())
	    return null ;
	else return elements[nbElem-1] ;
    }
    
    /** renvoie la valeur de l'objet sur le sommet de la pile
     * et l'enlève */
    public E depile() {
	if (vide())
	    return null ;
	nbElem-- ;
	return elements[nbElem] ;
    }
    
    /** ajoute un objet sur le sommet de la pile */
    public void empile(E o) {
	if (peutEmpiler(o)) {
	    elements[nbElem] = o ;
	    nbElem++ ;
	}
    }
    
    /** vide la pile */
    public void vider() {
	nbElem = 0 ;
    }
    
    /** compte le nombre d'éléments présents dans la pile */
    public int nbElements() {
	return nbElem ;
    }

    public void deplacerUnElementVers(Pile<E> p) {
	if (!vide() && p.peutEmpiler(sommet())) {
	    p.empile(this.depile()) ;
	    if (p instanceof PileHanoi) 
		System.out.println("Déplacement de " + nom + " vers "
				   + ((PileHanoi) p).nom()) ;
	}
    }
    
    /** affichage */
    public String toString() {
	String s = nom + "\n" ;
	for (int i = nbElem-1; i>=0; i--)
	    s += elements[i] + "\n" ;
	return s ;
    }

    /** accès au nom de la pile */
    public String nom() { return nom ; }

    // TEST
    public static void main(String [] arg) {
	Pile<Integer> p1 = new PileHanoi<Integer>("La pile d'entiers") ;
	System.out.println("Entrez 3 entiers :"); 
	for (int i=1; i<=3; i++)
	    p1.empile(new Integer(Clavier.readInt())) ;
	System.out.println(p1);
	System.out.println("Entrez 9 entiers correspondant à des rationnels :"); 
	Pile<Disque> p3 = new PileTableau<Rationnel>("La pile de rationnels") ;
	for (int i=1; i<=3; i++)
	    p3.empile(new Rationnel(Clavier.readInt(), Clavier.readInt(), Clavier.readInt())) ;
	System.out.println(p3) ;
	Pile<Comparable> p4 = new PileHanoi<Comparable>("Une pile d'objets comparables") ;
	while (!p3.vide())
	    p4.empile(p3.depile()) ;
	while (!p2.vide())
	    p4.empile(p2.depile()) ;
	while (!p1.vide())
	    p4.empile(p1.depile()) ;
	System.out.println(p4) ;
    }
}
