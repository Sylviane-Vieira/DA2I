package comptes;

public class Pel extends CompteEpargne {
    private double versementMensuel;

    public Pel(int numero, int anciennete, double montant,
      double taux) {
    	super(numero, anciennete, montant, 0.05);
    }
    public void ajouter(double somme) {
      this.montant+=somme;
      versementMensuel+=somme;
    }

    //effectue les opérations de maintenance du compte
    public void operationsMensuelles()
      throws VersementsInsuffisantsExc {
      if (versementMensuel<50){
        throw new VersementsInsuffisantsExc (numero);
      }
    	//affiche le montant des intérets mensuels
    	double interet=montant*taux;
    	System.out.println("les intérets mensuels s'élèvent à : " + interet);
      this.montant+=interet;
      System.out.println("le montant du compte intérêts compris s'élève à : " + montant);
    	this.anciennete+=1;
      System.out.println("le compte a "+ this.getAnciennete() + " mois");
    }

}
