public class Urgent extends Air{
    private String type;
    
    public Urgent(int d, int l, String t){
	super(d,l,t) ;
    }
    public String getType(){
	return "aérienne urgent";
    }

    public int cost(int distance){
	return 4*Air.cost();
    }
}
