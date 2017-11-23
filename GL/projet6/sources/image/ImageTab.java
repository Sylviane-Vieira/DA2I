package image ;

public class ImageTab extends ImageQuelconque {
    private NiveauGris [][] points ;

    public ImageTab(int w, int h) {
    	super(w,h);
    	this.initialiserPoints() ;
    }

    public void initialiserPoints() {
    	points = new NiveauGris[largeur][hauteur] ;
    	for (int y=0; y<hauteur; y++)
    	    for (int x=0; x<largeur; x++)
    		this.definirPoint(x, y, new NiveauGris(NiveauGris.BLANC)) ;
    }

    public NiveauGris pointEn(int x, int y) {
    	if (this.correct(x,y))
    	    return points[x][y] ;
    	return new NiveauGris(NiveauGris.BLANC) ;
    }

    public void definirPoint(int x, int y, NiveauGris gris) {
    	if (this.correct(x,y))
    	    points[x][y] = gris ;
    }

    public ImageGrise dupliquer() {
	ImageGrise result = new ImageTab(largeur, hauteur) ;
	for (int y=0; y<hauteur; y++)
	    for (int x=0; x<largeur; x++)
		result.definirPoint(x, y, new NiveauGris(this.pointEn(x,y).code())) ;
	return result ;
    }

    /** Ne pas oublier cette méthode si on veut pouvoir observer les images
     *  en mode texte ! */
    public String toString() {
    	String s = largeur + "x" + hauteur ;
    	for (int y=0; y<hauteur; y++)
    	    {
    		s += "\n" ;
    		for (int x=0; x<largeur; x++)
    		    s += this.pointEn(x, y) ;
    	    }
    	return s ;
    }
}
