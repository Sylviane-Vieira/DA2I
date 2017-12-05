public class Cube extends Bloc {
    protected double cote;
    
    public Cube(double mv, double c) {
	super(mv);
	cote = c;
    }
    
    public double volume() {
	return cote * cote * cote;
    }

    public String toString() {
	return "Je suis un Cube";
    }
}

