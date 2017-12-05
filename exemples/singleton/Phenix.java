public class Phenix {
    private static Phenix le_seul_phenix;

    public static Phenix uniqueInstance() {
        if (le_seul_phenix == null)
            le_seul_phenix = new Phenix();
        return le_seul_phenix;
    }

    private Phenix() {}

    public String toString() {
        return "Je suis le SEUL phenix.";
    }
}
