import java.lang.Math;

public class Fluvial extends ShipmentWeight{
    private String type;
    
    public Fluvial(int d, int l, String t){
	super(d,l) ;
	this.type = t;
    }
    public String getType(){
	return "fluvial";
    }

    public int cost(int distance){
	return distance*Math.sqrt(getQuantite);
    }
}
