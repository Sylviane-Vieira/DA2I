package image ;

import dictionnaire.correction.* ;

public abstract class ImageDictSuper extends ImageQuelconque {
    protected Dictionnaire points ;

    public ImageDictSuper(int w, int h) {
	     super(w,h);
	      this.initialiserPoints() ;
    }

    public void initialiserPoints() {
	     points = new TabDict() ;
    }


    public abstract void definirPoint(int x, int y, NiveauGris gris);

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
