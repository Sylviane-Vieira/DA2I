package comptes;
public class LivretA extends CompteEpargne {
    public LivretA(int numero, int anciennete, double montant, double taux) {
	super(numero, anciennete, montant, 0.2);
    }
}
