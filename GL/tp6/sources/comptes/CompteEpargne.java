package comptes;
public class CompteEpargne extends CompteGenerique {
    protected double taux;

    public CompteEpargne(int numero, int anciennete, double montant, double taux) {
	super(numero, anciennete, montant);
	this.taux=taux;
    }
    //ajoute les interets sur le compte
    public void ajouter(double somme) {
	montant+=somme;
	montant*=taux; 
    }

    //retirer de l'argent
    public void retirer(double somme) {
	if (this.montant>=somme){
	    montant-=somme;
	}
    }
    //effectue les opérations de maintenance du compte
    public void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc {
	//affiche le montant des intérets mensuels 
	double interet=montant*taux;
	System.out.println("les intérets mensuels s'élèvent à : " + interet);
	anciennete++;
    }
    
}
