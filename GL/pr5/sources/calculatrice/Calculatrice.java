package calculatrice ;
import java.lang.Math;

public class Calculatrice {
    private Stack<Double> resultat;
    private HashMap<String,Operation> operations;

    Calculatrice() {
        resultat = new Stack<Double>();
	operations = new HasMap<String,Operation>();
	for (Operation o : Operation.values()){
	    operation.put(o.toString(),o);
	}
    }

    public double calculer(String s) {
	StringTokenizer st = new StringTokenizer(s);
	while (st.hasMoreTokens()){
	    if operation.containsKey(st.nextToken()){
			resultat=
		    }
	while (e.hasMoreTokens()) {
	    current = expression.nextToken();
	    switch(current) {
	    case "+" :
	    case "-" :
	    case "x" :
	    case "/" :
	    case "^" :
		val1 = resultat.get(i-2);
	    val2 = resultat.get(i-1);
	    resultat.remove(i-2);
	    resultat.remove(i-1);
	    i = i-2;
	    operation = new Operation(current);
	    resultat.add(operation.eval(Double(val1),Double(val2)));
		break;
	    default :
		resultat.add(current);
		break;
	    }
	    i=i+1;
	}
	return Double(resultat.get(0));
    }
}
