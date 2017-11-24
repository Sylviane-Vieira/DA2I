import calculatrice.* ;

public class Test {
    public static void main(String [] args) {
        if (args.length < 2) 
            System.err.println("Au moins deux nombres sur la ligne de commande !") ;
        else {
            // deux nombres passés sur la ligne de commande
            double x = new Double(args[0]) ;
	    String op = new String(args[1]) ;
            double y = new Double(args[2]) ;
            // la liste des opérations disponibles
		for (Operation o : Operation.values()){
			if (op.equals(o.toString()))
			    System.out.println(x + " " + op + " " + y + "=" + o.eval(x,y)) ;
		}
        }
    }
}
