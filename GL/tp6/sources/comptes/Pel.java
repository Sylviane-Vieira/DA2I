package comptes;
public class Pel extends CompteEpargne {
    private double versementMensuel;
    
    public Pel(int numero, int anciennete, double montant, double taux, double versementMensuel) {
	super(numero, anciennete, montant, 0.5);
    }
    
    //ajoute la somme sur le compte
    public void ajouter(double somme) {
	if (versementMensuel>=50){
	    somme=versementMensuel;
	    montant*=taux;
	}
    }

    //retirer de l'argent
    public void retirer(double somme) {
	if (anciennete>4 && this.montant>=somme){
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
