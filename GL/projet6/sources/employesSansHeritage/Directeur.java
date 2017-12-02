package employesSansHeritage ;

/*le directeur est unique. Il reçoit chaque semaine une somme fixe,
plus une prime représentant 0.4% du chiffre d’affaires global des commerciaux*/
public class Directeur extends Commercial {
  private static Directeur le_seul_directeur;

  public Directeur (String nom, double fixe) {
    super(nom, fixe);
    this.chiffreDAffaires = getCaTotal();
  }

  public Directeur getDirecteur()
  throws UniciteDuDirecteurException {
    if (le_seul_directeur != null)
      throw new UniciteDuDirecteurException ("Impossible de créer un deuxième directeur");
    return le_seul_directeur = new Directeur(nom, fixe);
  }

  public double salaireHebdo() {
  	return fixe + (chiffreDAffaires*0.04) ;
  }

}
