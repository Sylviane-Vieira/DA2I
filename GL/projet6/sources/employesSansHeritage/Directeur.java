package employesSansHeritage ;

/*les commerciaux reçoivent chaque semaine une somme fixe,
plus une prime représentant 1% du chiffre d’affaires qu’ils
ont réalisé dans la semaine: Sh=Sfixe+C/100
(C: chiffre d’affaires de la semaine pour le commercial*/
public class Directeur extends Commercial {
  private static Phenix le_seul_directeur;
  private double fixe, chiffre_affaires ;
  private String nom ;

  public Directeur (String nom) {
    this.chiffre_affaires =null;
  	super(nom, fixe);
  }

  public getDirecteur()
  throws UniciteDuDirecteurException {
    if (le_seul_directeur != null)
      throw new UniciteDuDirecteurException ("Impossible de créer un deuxième directeur");
    return le_seul_directeur = new Phenix();
  }

  public void setTravail(double c) { this.chiffre_affaires = c ; }

  public double salaireHebdo() {
  	return fixe + (this.chiffre_affaires/100) ;
  }

}
