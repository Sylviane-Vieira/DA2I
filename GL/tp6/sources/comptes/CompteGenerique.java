package comptes ;

public abstract class CompteGenerique implements Compte {
    protected int numero;
    protected int anciennete;
    protected double montant;

    public CompteGenerique(int numero, int anciennete, double montant) {
    	this.numero=numero;
    	this.anciennete=anciennete;
    	this.montant=montant;
    }
    public CompteGenerique(int numero, int anciennete) {
    	this.numero=numero;
    	this.anciennete=anciennete;
    }

      /** Retourne le numéro identifiant le compte */
    public int getNumero() {
      return this.numero;
    }

    /** Retourne le nombre de mois écoulés depuis l’ouverture */
    public int getAnciennete() {
	    return this.anciennete;
	}

    /** Retourne le numéro du compte et le montant */
    public String toString() {
	     return "compte numéro : " + numero + " \nsolde : " + montant;
    }

    /** Effectue un ajout de la somme spécifiée sur le compte */
    public abstract void ajouter(double somme);

    /** Tente d’effectuer un retrait de la somme spécifiée sur le compte */
    public abstract void retirer(double somme) ;

    /** Effectue les opérations mensuelles de maintenance du compte. Cette méthode est
     * susceptible de déclencher des exceptions si des anomalies sont détectées. */
    public abstract void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc ;

}
