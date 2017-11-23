public class Road extends ShipmentWeight{
    private String type;
    
    public Road(int d, int l, String t){
	super(d,l) ;
	this.type = t;
    }
    public String getType(){
	return "routière";
    }

    public int cost(int distance){
	return 4*distance*quantite;
    }
}
