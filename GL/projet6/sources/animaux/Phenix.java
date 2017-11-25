package animaux ;

public class Phenix extends Animal {
    private static Phenix le_seul_phenix;

    public static Phenix uniqueInstance()
    throws UniciteDuPhenixException {
      if (le_seul_phenix != null)
        throw new UniciteDuPhenixException("Ce n'est pas le même phenix");
      return le_seul_phenix = new Phenix();
    }

    public Phenix(String nom) {
        super(nom);
    }

    public Phenix() {
        super("Le Phenix");
    }

    public String toString() {
        return super.toString() + " Je suis le SEUL phenix.";
    }
}
