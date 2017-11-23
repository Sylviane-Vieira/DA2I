public abstract class ShipmentWeight extends Shipment{
    public ShipmentWeight(int d, int l){
	super(d,l);
    }

    public int getQuantite(Goods g){
	return g.getWeight();
    }
}
