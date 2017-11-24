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
	// si je suis un noeud interne
	//    afficher le contenu
	//    recuperer la réponse du joueur
	//    si reponse = oui => gauche.rechercherAnimal();
	//    sinon  => droite.rechercherAnimal();
	// sinon (je suis une feuille)
	//    afficher "est-ce"+contenu
	//    recuperer la réponse du joueur
	//    si oui => super!
	//    si non => zut... 

    public void rechercherAnimal(){;
        if (gauche != null || droit != null){
	    System.out.println(this.getContenu());
	    Scanner lectureClavier = new Scanner(System.in);
	    String reponse = lectureClavier.next(); 
	    if (reponse == "oui") {gauche.rechercherAnimal();}
	    else if (reponse == "non") {droit.rechercherAnimal();}
	}
	else{
	    System.out.println("Est-ce" + contenu + " ? ");
	    Scanner lecture = new Scanner(System.in);
	    String rep = lecture.next();
	    if (rep == "oui") System.out.println("Super !");
	    else if (rep == "non") System.out.println("Zut...");
	}
    }
    
}

