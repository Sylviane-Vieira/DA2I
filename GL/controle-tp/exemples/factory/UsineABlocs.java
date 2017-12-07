public class UsineABlocs {    
    public static Bloc creerBloc(String type, double x, double y) {
	if (type.equals("Cube")) return new Cube(x,y);
	else if (type.equals("Boule")) return new Boule(x,y);
	return null; // devrait plutôt lever une exception!
    }
}
