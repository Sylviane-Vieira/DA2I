public class Air extends ShipmentVolume{
    private String type;
    
    public Air(int d, int l, String t){
	super(d,l);
	this.type = t;
    }
    public String getType(){
	return "aérienne";
    }
    public int cost(int distance){
	return 10*distance+4*quantite;
    }
}
