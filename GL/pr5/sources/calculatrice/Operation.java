package calculatrice;
import java.lang.Math;

public enum Operation {
    PLUS("+"), MOINS("-"), FOIS("*"), DIV("/"), PUISS("^");
    private final String code_operation;
    Operation(){
	this.code_operation = " ";
    }
    Operation(String co){
	this.code_operation = co;
    }
    public String toString(){
	return "" + code_operation;
    }
    public double eval(double x, double y){
	switch (this)
	    {
	    case (this==PLUS): return x+y; break;
	    case (MOINS): return x-y; break;
	    case (FOIS): return x*y; break;
	    case (DIV): return x/y; break;
	    case (PUISS): return Math.pow(x,y); break;
	    }
    }
    
}
