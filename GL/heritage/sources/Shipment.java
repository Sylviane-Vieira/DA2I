import java.util.*;

public abstract class Shipment {
    protected int distance;
    protected int quantite;
    protected int limite;
    protected ArrayList<Goods> cargaison = new ArrayList<Goods>();

    public Shipment(int d, int l){
	this.distance = d;
	this.limite = l;
    }

    public Shipment(){}

    protected abstract int getQuantite(Goods g);

    public int total(){
	int total;
	for (Goods g:cargaison){
	    total+=getQuantite(g);
	}
    }
    
    public void add(Goods g)
	throws IllegalStateException {
	if (getQuantite(g) + total() > limite)
	    throw new IllegalStateException("pas assez de place");
	cargaison.add(g);
    }
    
    public abstract int cost();

}
