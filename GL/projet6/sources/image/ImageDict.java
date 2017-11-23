package image ;

import dictionnaire.correction.* ;

public class ImageDict extends ImageDictSuper {
    private Dictionnaire points ;

    public ImageDict(int w, int h) {
	     super(w,h);
	     this.initialiserPoints() ;
    }

    private void initialiserPoints() {
      points = new TabDict() ;
    }
    public NiveauGris pointEn(int x, int y) {
      if (points.contientClef(new Point(x, y)))
          return (NiveauGris) points.valeurPour(new Point(x, y)) ;
      return new NiveauGris(NiveauGris.BLANC) ;
    }

    public void definirPoint(int x, int y, NiveauGris gris) {
      if (this.correct(x,y)) {
          if (gris.equals(new NiveauGris(NiveauGris.BLANC)))
        points.enleverPour(new Point(x, y)) ;
          else
        points.ajouter(new Point(x, y), gris) ;
  }


    public ImageGrise dupliquer() {
      ImageGrise result = new ImageDict(largeur, hauteur) ;
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
