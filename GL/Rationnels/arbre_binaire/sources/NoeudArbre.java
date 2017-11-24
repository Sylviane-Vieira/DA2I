import java.util.*;

//construction d'une classe arbre binaire
public class NoeudArbre {
    //attributs
    private String contenu;
    private NoeudArbre gauche, droit;

    //constructeur a un element
    public NoeudArbre (String r){
        this.contenu = r;
	this.gauche = null;
	this.droit = null;
    }

    //constructeur contenu et noeuds gauches et droits
    public NoeudArbre ( String r, NoeudArbre g, NoeudArbre d) {
	this.contenu = r;
	this.gauche = g;
	this.droit = d;
    }

    //getteur contenu
    public String getContenu(){
	return this.contenu;
    }
    //setteur contenu
    public String setContenu(String r){
	return this.contenu = r;
    }

    //getteur gauche
    public NoeudArbre getGauche() {
	return this.gauche;
    }
    //setteur gauche
    public NoeudArbre setGauche(NoeudArbre g) {
	return this.gauche = g;
    }
    //getteur droit
    public NoeudArbre getDroit(){
	return droit;
    }
    //setteur droit
    public NoeudArbre setDroit(NoeudArbre d) {
	return this.droit = d;
    }

    // methode toString
    public String toString() {
	//si gauche et droit sont a null, on n'affiche que la contenu
	if (gauche == null && droit == null)
	    return this.contenu;
	
	//si gauche ou droit a une valeur, on affiche la contenu et les 2 valeurs
	else if(gauche != null || droit != null)
	    return this.contenu + " " + this.gauche + " " +this.droit;
	//par defaut, on affiche le contenu
	return this.contenu;
     }

    //methode qui pose les questions jusqu'a ce que le programme ait gagne ou perdu
    public void rechercherAnimal(){;
	// si je suis un noeud interne
	if (gauche != null && droit != null){
	    //afficher le contenu
	    System.out.println(this.getContenu());

	    //recuperer la réponse du joueur
	    String reponse = Clavier.readString(); 
	    switch (reponse) {
	    //si reponse = oui => droit.rechercherAnimal();	
	    case "oui":
		this.getDroit().rechercherAnimal();
		break;
	    //sinon  => gauche.rechercherAnimal();
	    case "non":
		this.getGauche().rechercherAnimal();
		break;
	    default:    
		System.out.println("Voulez-vous rejouer ?");
	    }
	}
	else{ //si je suis un noeud
	    //afficher la question suivante
	    System.out.println("Est-ce " + contenu + " ? ");
	    //recuperer la réponse du joueur
	    String rep = Clavier.readString();
	    switch (rep) {
	    case "oui":
		System.out.println("Super !");
		break;
	    //si la réponse est non, le programme enregistre la réponse et la
	    //stoque dans la branche droite en utilisant la methode apprendre()
	    case "non":
		System.out.println("Zut...");
		//	this.apprendre();
		break;
	    default:
		break;
	    }
		
	}
    }

    //methode apprendre

}
