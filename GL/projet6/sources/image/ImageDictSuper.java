package image ;

import dictionnaire.correction.* ;
 
public abstract class ImageDictSuper extends ImageQuelconque {
    protected Dictionnaire points ;

    public ImageDictSuper(int w, int h) {
	super(w,h);
	this.initialiserPoints() ;
    }

    private boolean correct(int x, int y) {	
	return ((x >= 0) && (x < largeur) && (y >= 0) && (y < hauteur)) ;
    }

    public void initialiserPoints() {
	points = new TabDict() ;
    }

    public abstract NiveauGris pointEn(int x, int y);

    public abstract void definirPoint(int x, int y, NiveauGris gris);


    public abstract String toString();
}
