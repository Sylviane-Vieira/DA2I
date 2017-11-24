public class Test {
    public static void main(String [] arg) {
	Pile<DisqueHanoi> p1 = new PileHanoi() ;
	System.out.println("Entrez 3 entiers :"); 
	for (int i=1; i<=3; i++)
	    p1.empile(new DisqueHanoi(Clavier.readInt())) ;
	System.out.println(p1) ;
    }
}
