public abstract class Bloc {
    protected double masse_volumique;

    public Bloc(double mv) {
	masse_volumique = mv;
    }
    
    public double masse() {
	return masse_volumique * volume();
    }
    
    public abstract double volume(); // signature seule
}
