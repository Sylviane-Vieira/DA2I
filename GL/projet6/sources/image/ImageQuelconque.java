package image;

public abstract class ImageQuelconque implements ImageGrise {
    protected int largeur, hauteur ;

    public ImageQuelconque(int w, int h) {
    	largeur = w ;
    	hauteur = h ;
    	this.initialiserPoints() ;
    }

    public boolean correct(int x, int y) {
	     return ((x >= 0) && (x < largeur) && (y >= 0) && (y < hauteur)) ;
    }

    public abstract void initialiserPoints();

    private boolean incompatible(ImageGrise img) {
	     return (largeur != img.largeur()) || (hauteur != img.hauteur()) ;
    }

    public int largeur() { return largeur ; }

    public int hauteur() { return hauteur ; }

    public abstract NiveauGris pointEn(int x, int y);

    public abstract void definirPoint(int x, int y, NiveauGris gris);

    public void randomize() {
    	for (int y=0; y<hauteur(); y++)
    	    for (int x=0; x<largeur() ; x++)
    		    this.definirPoint(x, y, this.pointEn(x,y).randomizeNB()) ;
        }

    public void allumer(int x, int y) {
    	if (this.correct(x,y))
    	    this.definirPoint(x, y, new NiveauGris(NiveauGris.NOIR)) ;
        }

    public void eteindre(int x, int y) {
    	if (this.correct(x,y))
    	    this.definirPoint(x, y, new NiveauGris(NiveauGris.BLANC)) ;
        }

    public int compterPoints(NiveauGris gris) {
    	int nombre = 0 ;
    	for (int y=0; y<hauteur; y++)
    	    for (int x=0; x<largeur; x++)
    		if (this.pointEn(x,y).equals(gris))
    		    nombre++ ;
    	return nombre ;
    }

    public ImageGrise inverser() {
    	ImageGrise result =  dupliquer()  ;
    	for (int y=0; y<hauteur; y++)
    	    for (int x=0; x<largeur; x++)
    		result.definirPoint(x, y, this.pointEn(x,y).inverser()) ;
    	return result ;
    }

    public ImageGrise eclaircir() {
    	ImageGrise result =  dupliquer()  ;
    	for (int y=0; y<hauteur; y++)
    	    for (int x=0; x<largeur; x++)
    		    result.definirPoint(x, y, this.pointEn(x,y).eclaircir()) ;
    	return result ;
    }

    public ImageGrise assombrir() {
    	ImageGrise result = dupliquer() ;
    	for (int y=0; y<hauteur; y++)
    	    for (int x=0; x<largeur; x++)
    		    result.definirPoint(x, y, this.pointEn(x,y).assombrir()) ;
    	return result ;
    }

    public abstract ImageGrise dupliquer();

    public ImageGrise ajouter(ImageGrise img)
      throws ImagesIncompatiblesException {
        try{
        	ImageGrise result =  dupliquer() ;
        	if (this.incompatible(img))
        	    return result ;
        	for (int y=0; y<hauteur; y++)
        	    for (int x=0; x<largeur; x++)
        		    result.definirPoint(x, y,
        				    this.pointEn(x,y).ajouter(img.pointEn(x,y))) ;
        	return result ;
        }
        catch (ImagesIncompatiblesException e){
          System.out.println ("Images incompatibles" + e.getMessage());
        }
    }

    public ImageGrise soustraire(ImageGrise img) {
      try{
      	ImageGrise result =  dupliquer() ;
      	if (this.incompatible(img))
      	    return result ;
      	for (int y=0; y<hauteur; y++)
      	    for (int x=0; x<largeur; x++)
      		result.definirPoint(x, y,
      				    this.pointEn(x,y).soustraire(img.pointEn(x,y))) ;
      	return result ;
      } catch (ImagesIncompatiblesException e){
        System.out.println ("Images incompatibles" + e.getMessage());
      }
    }

    public ImageGrise XOR(ImageGrise img) {
      try{
    	ImageGrise result = dupliquer();
    	if (this.incompatible(img))
    	    return result ;
    	for (int y=0; y<hauteur; y++)
    	    for (int x=0; x<largeur; x++)
    		result.definirPoint(x, y,
    				    this.pointEn(x,y).XOR(img.pointEn(x,y))) ;
    	return result ;
      }  catch (ImagesIncompatiblesException e){
      System.out.println ("Images incompatibles" + e.getMessage());
    }
    }

    public ImageGrise intersection(ImageGrise img) {
	ImageGrise result =  dupliquer();
	if (this.incompatible(img))
	    return result ;
	for (int y=0; y<hauteur; y++)
	    for (int x=0; x<largeur; x++)
		if (this.pointEn(x,y).equals(img.pointEn(x,y)))
		    result.definirPoint(x, y, this.pointEn(x,y)) ;
	return result ;
    }

	public abstract String toString();

    public NiveauGris niveauMoyen() {
	int s = 0 ;
	for (int n=NiveauGris.BLANC; n<=NiveauGris.NOIR; n++)
	    s += n * this.compterPoints(new NiveauGris(n)) ;
	return new NiveauGris((int)(((double) s) / (largeur * hauteur))) ;
    }

    public ImageGrise augmenterContraste() {
	NiveauGris courant, moyen ;
	ImageGrise result =  dupliquer();
	moyen = this.niveauMoyen() ;
	for (int y=0; y<hauteur; y++)
	    for (int x=0; x<largeur; x++) {
		courant = this.pointEn(x, y) ;
		if (courant.compareTo(moyen) > 0)
		    result.definirPoint(x, y, courant.assombrir()) ;
		else
		    result.definirPoint(x, y, courant.eclaircir()) ;
	    }
	return result ;
    }
}
