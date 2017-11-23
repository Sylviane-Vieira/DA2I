package image ;

import dictionnaire.correction.* ;

public class ImageDoubleDict extends ImageDictSuper {
    private Dictionnaire points ;

    public ImageDoubleDict(int w, int h) {
    	super(w,h);
    	this.initialiserPoints() ;
    }

    public NiveauGris pointEn(int x, int y) {
    	if (points.contientClef(x)){
    	    Dictionnaire d = (Dictionnaire) points.valeurPour(x) ;
    	    if (d.contientClef(y))
    		return (NiveauGris) d.valeurPour(y) ;
    	    }
    	return new NiveauGris(NiveauGris.BLANC) ;
    }

    public void definirPoint(int x, int y, NiveauGris gris) {
    	if (this.correct(x,y)) {
    	    if (gris.equals(new NiveauGris(NiveauGris.BLANC))) {
    		Dictionnaire d ;
    		if (points.contientClef(x)) {
    		    d = (Dictionnaire) points.valeurPour(x) ;
    		    d.enleverPour(y) ;
    		    if (d.estVide())
    			points.enleverPour(x) ;
    		}
    	    } else {
    		Dictionnaire d ;
    		if (points.contientClef(x))
    		    d = (Dictionnaire) points.valeurPour(x) ;
    		else {
    		    d = new TabDict() ;
    		    points.ajouter(x, d) ;
    		}
    		d.ajouter(y, gris) ;
    	    }
	}
    }
    public ImageGrise dupliquer() {
      ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
      for (int y=0; y<hauteur; y++)
          for (int x=0; x<largeur; x++)
        result.definirPoint(x, y, new NiveauGris(this.pointEn(x,y).code())) ;
      return result ;
    }

    public String toString() {
    	String s = largeur + "x" + hauteur ;
    	for (int y=0; y<hauteur; y++) {
    	    s += "\n" ;
    	    for (int x=0; x<largeur; x++)
    		s += this.pointEn(x, y) ;
    	}
    	return s ;
    }
}
