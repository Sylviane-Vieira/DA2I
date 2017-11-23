package image ;
public class ImageTab implements ImageGrise {
    private int largeur;
    private int hauteur;
    private int NiveauGris[][] niveauGris;

    public ImageTab (int largeur, int hauteur){
	this.largeur = largeur;
	this.hauteur = hauteur;
	this.niveauGris = new NiveauGris[largeur][hauteur];
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		niveauGris[i][j]=NiveauGris.BLANC;
	    }
	}
    }
    /** Retourne la largeur de l'image */
    public int largeur() {
	return this.largeur;
    }
    /** Retourne la hauteur de l'image */
    public int hauteur() {
	return this.hauteur;
    }
    /** Retourne le niveau de gris du point de coordonnées (x,y) */
    public NiveauGris pointEn(int x, int y){
	return niveauGris[x][y];
    }
    /** Fixe le niveau de gris du point de coordonnées (x,y) à la valeur spécifiée */
    public void definirPoint(int x, int y, NiveauGris gris) {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		niveauGris[x][y]=gris;
	    }
	}
    }
    /** Met en noir le point de coordonnées (x,y) */
    public void allumer(int x, int y) {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		niveauGris[x][y]=NiveauGris.BLACK;
	    }
	}
    }
    /** Met en blanc le point de coordonnées (x,y) */
    public void eteindre(int x, int y) {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		niveauGris[x][y]=NiveauGris.BLANC;
	    }
	}
    }
    /** Donne une valeur aléatoire (noir ou blanc) à chaque point de l'image */
    public void randomize() {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		NiveauGris.randomizeNB();
	    }
	}
    }
    /** Compte le nombre de points de l'image dont le niveau de gris est égal au niveau spécifié */
    public int compterPoints(NiveauGris gris) {
	int cpt=0;
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		if (niveauGris[i][j]=gris){
		    cpt+=1;
		}
	    }
	}
	return cpt;
    }
    /** Retourne une image qui est le négatif de l'image courante */
    public ImageGrise inverser() {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		return NiveauGris.inverser(niveauGris[i][j]);
	    }
	}
    }
    /** Retourne une image dont tous les points (sauf blancs) sont un niveau
     * plus clair que dans l'image courante */
    public ImageGrise eclaircir() {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		if (!niveauGris[i][j].estBlanc()){
		    NiveauGris.eclaircir();
		}
	    }
	}
	return new ImageGrise[i][j];
    }
    /** Retourne une image dont tous les points (sauf noirs) sont un niveau
     * plus foncé que dans l'image courante */
    public ImageGrise assombrir() {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		if (!niveauGris[i][j].estNoir()){
		    NiveauGris.assombrir();
		}
	    }
	}	
	return new ImageGrise[i][j];
    }
    /** Retourne une <B>copie</B> de l'image courante */
    public ImageGrise dupliquer() ;
    /** Retourne une image en additionnant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) */
    public ImageGrise ajouter(ImageGrise img) {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		NiveauGris.ajouter(img[i][j]);
	    }
	}
	return new ImageGrise[i][j];
    }
    /** Retourne une image en retranchant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) */
    ImageGrise soustraire(ImageGrise img) {
	for (int i=0; i<largeur; i++){
	    for (int j=0; j<hauteur; j++){
		NiveauGris.soustraire(img[i][j]);
	    }
	}
	return new ImageGrise[i][j];
    }
    /** Retourne une image en faisant un OU Exclusif (XOR) point par
     * point les niveaux de gris de l'image courante et de l'image en
     * paramètre (les deux images doivent être de même taille) */
    ImageGrise XOR(ImageGrise img) {
	if(niveauGris.largeur()==img.largeur() &&
	   niveauGris.hauteur()==img.hauteur()){
	    for (int i=0; i<largeur; i++){
		for (int j=0; j<hauteur; j++){
		    NiveauGris.XOR(img[i][j])
			}
	    }
	    return new ImageGrise[i][j];
	}
    }
    /** Retourne une image qui représente "l'intersection" de l'image courante et de l'image 
     * en paramètre : seuls les points qui ont le même niveau de gris dans les deux images sont
     * conservés (les deux images doivent être de même taille) */
    ImageGrise intersection(ImageGrise img) ;
    /** Retourne le niveau de gris moyen de l'image. Pour le calculer, il faut faire la 
     * moyenne des niveaux de chaque point de l'image (ce qui revient à compter combien il y
     * a de points de chaque niveau de gris possible) */
    NiveauGris niveauMoyen() ;
    /** Retourne une image obtenue en augmentant le contraste de l'image courante. Pour 
     * augmenter le contraste, il faut rendre les points sombres plus sombres qu'ils ne sont, 
     * et les points clairs plus clairs. Un bon moyen de procéder consiste à calculer le 
     * niveau de gris moyen de l'image, et assombrir (respectivement eclaircir) les points 
     * plus sombres (resp. plus clairs) que ce niveau moyen */
    ImageGrise augmenterContraste() ;
}
