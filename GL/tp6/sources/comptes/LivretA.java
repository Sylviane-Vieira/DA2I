package comptes;
public class LivretA extends CompteEpargne {

    public LivretA(int numero, int anciennete, double montant, double taux) {
	     super(numero, anciennete, montant, 0.02);
    }
    public void ajouter(double somme) {
      this.montant+=somme;
    }

    //effectue les opérations de maintenance du compte
    public void operationsMensuelles()
      throws DepassementDecouvertExc, VersementsInsuffisantsExc {
    	//affiche le montant des intérets mensuels
    	double interet=montant*taux;
    	System.out.println("les intérets mensuels s'élèvent à : " + interet);
      this.montant+=interet;
      System.out.println("le montant du compte intérêts compris s'élève à : " + montant);
    	this.anciennete+=1;
      System.out.println("le compte a "+ anciennete + " mois");
    }
}
