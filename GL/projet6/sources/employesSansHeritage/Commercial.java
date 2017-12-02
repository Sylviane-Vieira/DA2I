package employesSansHeritage ;

/*classe dont dérive la classe Directeur*/
public class Commercial extends EmployeQuelconque {
  protected static double fixe, chiffreDAffaires ;
  protected static int nbCommerciaux, caTotal;

  public Commercial (String nom, double fixe) {
    super(nom);
  	this.fixe = fixe;
    //Incremente automatiquement le nombre de commerciaux
    nbCommerciaux++;
    caTotal+= this.chiffreDAffaires;
  }

  public void setTravail(double ca) { this.chiffreDAffaires = ca ; }

  public double salaireHebdo() {
  	return fixe + (this.chiffreDAffaires/100) ;
  }
  public static int getNbCommerciaux() {
    return nbCommerciaux;
  }
  //Permet au directeur de récupérer
  //le CA global
  public static double getCaTotal () {
    return caTotal;
  }

}
