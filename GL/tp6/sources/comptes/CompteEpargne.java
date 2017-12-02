package comptes;

public abstract class CompteEpargne extends CompteGenerique {
    protected double taux;

    public CompteEpargne(int numero, int anciennete, double montant, double taux) {
    	super(numero, anciennete, montant);
    	this.taux=taux;
    }
    //ajoute les versments sur le compte
    public abstract void ajouter(double somme) ;

    //retirer de l'argent
    public void retirer(double somme) {
    	if (this.montant>=somme){
    	    montant-=somme;
    	}
    }
    //effectue les opérations de maintenance du compte
    public abstract void operationsMensuelles()
      throws DepassementDecouvertExc, VersementsInsuffisantsExc ;

}
