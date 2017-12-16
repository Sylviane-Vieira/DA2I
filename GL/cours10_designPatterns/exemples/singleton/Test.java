public class Test {
    public static void main(String args[]){
	Phenix p1 = Phenix.uniqueInstance();
	Phenix p2 = Phenix.uniqueInstance();
	System.out.println("p1 == p2 : " + (p1==p2));
	// Phenix p3 = new Phenix();
    }
}
