import animaux.* ;
public class TestAnimaux {
    public static void main (String [] arg) {
	Animal a1 = new Animal() ;
	Animal a2 = new Animal("Titi") ;
	Mammifere m1 = new Mammifere() ;
	Animal a3 = new Mammifere("Bucephale") ;
	Mammifere m2 = new Chien() ;
	Chien c1 = new Chien("Medor") ;
	Animal a4 = new Homme() ;
	Mammifere m3 = new Homme("Louis XIV") ;
	Homme h1 = new HommeBavard() ;
	HommeBavard h2 = new HommeBavard("Socrate") ;
	System.out.println(a1) ;
	System.out.println(a2) ;
	System.out.println(m1) ;
	System.out.println(a3) ;
	System.out.println(m2) ;
	System.out.println(c1) ;
	System.out.println(a4) ;
	System.out.println(m3) ;
	System.out.println(h1) ;
	System.out.println(h2) ;
    }
}
