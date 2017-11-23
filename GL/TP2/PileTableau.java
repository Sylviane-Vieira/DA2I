import java.util.*;

public class PileTableau<E> implements Pile<E>{
private E [] elements ;  // les éléments contenus dans la pile
private int nbElem = 0 ; // le nombre d’éléments dans la pile
private String nom ;     // nom de la pile : information supplémentaire propre à PileTableau
    public PileTableau(String nom){
	this.elements = (E[]) new Object[MAX_ELEMENTS];
	this.nom = nom;
    }
    public boolean vide(){return this.nbElem==0;}
    public boolean pleine() {return this.nbElem<MAX_ELEMENTS;}
    public boolean peutEmpiler(E x) {return !this.pleine();}
    public E sommet() {return this.elements[-1];}
    public E depile() {this.elements(sommet());}
    public void empile(E x){
	if (!this.pleine()) {
	    this.sommet()=x;
	}
    }
    public void vider() {}
    public int nbElements() {return 0;}
    public void deplacerUnElementVers(Pile<E> p) {}
    public String toString() {return " ";}

}    

