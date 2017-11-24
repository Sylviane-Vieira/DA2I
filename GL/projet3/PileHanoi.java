/** Une implémentation de l'interface Pile utilisant pour la PileHanoi**/
public class PileHanoi implements Pile<DisqueHanoi> {

    private DisqueHanoi [] elements ;
    private int nbElem = 0 ;
    private String nom = "pile Hanoi" ;

    /** Constructeur qui crée une pile vide */
    public PileHanoi() {
	elements =  new DisqueHanoi[MAX_ELEMENTS] ;
    }

    /** Constructeur qui crée une pile vide et lui donne un nom */
    public PileHanoi(String nom) {
	elements =  new DisqueHanoi[MAX_ELEMENTS] ;
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
    public boolean peutEmpiler (DisqueHanoi x) {
	if (vide()) return true;
	else
	    return ( !pleine() && elements[nbElem-1].compareTo(x) >= 0 ) ;
    }
    public DisqueHanoi sommet(){
	if (vide())
	    return null ;
	else return elements[nbElem-1] ;
    }
    /** Renvoie la valeur de l'objet sur le sommet de la pile, et
     * l'enlève de la pile*/
    public DisqueHanoi depile(){
	if (vide())
	    return null ;
	nbElem-- ;
	return elements[nbElem] ;
    }
    /** Ajoute un objet sur le sommet de la pile */
    public void empile(DisqueHanoi x){
    	if (peutEmpiler(x)) {
	    elements[nbElem] = x ;
	    nbElem++ ;
	}
    }
    /** Vide la pile */
    public void vider(){
	nbElem = 0 ;
    }
    /** Compte le nombre d'éléments présents dans la pile */
    public int nbElements(){
	return nbElem ;
    } 
    /** Déplace un élément de la pile courante vers la pile spécifiée */
    public void deplacerUnElementVers(Pile<DisqueHanoi> p){
	if (!vide() && p.peutEmpiler(sommet())) {
	    p.empile(this.depile()) ;
	    if (p instanceof PileHanoi) 
		System.out.println("Déplacement de " + nom + " vers "
				   + ((PileHanoi) p).nom()) ;
	}
    }
    /** Chaîne contenant tous les éléments <b>depuis le sommet</b> */
    public String toString(){
	String s = nom + "\n" ;
	for (int i = nbElem-1; i>=0; i--)
	    s += elements[i] + "\n" ;
	return s ;
    }

     //
    // METHODES PROPRES A PileHanoi
    //

    /** accès au nom de la pile */
    public String nom() { return nom ; }


        public void deplacerDesDisques(int n, PileHanoi dest, PileHanoi interm) {
	    if (n > 1){
		deplacerDesDisques(n-1, interm, dest);
		deplacerDesDisques(1, dest, interm);
		interm.deplacerDesDisques(n-1, dest, this);	
	    }
	    else
		this.deplacerUnElementVers(dest);	    
	}//fin methode deplacerDesDisques
    
    
}//fin classe PileHanoi
