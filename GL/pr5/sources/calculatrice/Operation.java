package calculatrice;
import java.lang.Math;

public enum Operation {
    PLUS("+"), MOINS("-"), FOIS("x"), DIV("/"), PUISS("^");
    private final String code_operation;
    private double res;
    Operation(){
	code_operation = " ";
    }
    
    Operation(String code){
	code_operation = code;
    }
    public String toString() {
	return "" + code_operation;
    }
    public double eval(double x, double y) {
	switch(this) {
	    case PLUS : return x+y;
		case MOINS : return x-y;
		case FOIS: return x*y;
		case DIV: return x/y;
		case PUISS: return Math.pow(x,y);
		default : return 0;
	}
    }
    
}
