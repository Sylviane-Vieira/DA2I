public abstract class ShipmentVolume extends Shipment{
 public ShipmentVolume(int d, int l){
	super(d,l);
    }

    public int getQuantite(Goods g){
	return g.getVolume();
    }
}
