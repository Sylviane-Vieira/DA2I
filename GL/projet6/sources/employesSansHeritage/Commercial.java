package employesSansHeritage ;

/*classe dont dérive la classe Directeur*/
public abstract class Commercial extends EmployeQuelconque {
  protected double fixe, chiffre_affaires ;
  protected String nom ;

  public Commercial (String nom) {
  	this.fixe =null;
    this.chiffre_affaires =null;
    total=
  	super(nom);
  }

  public void setTravail(double c) { this.chiffre_affaires = c ; }

  public double salaireHebdo() {
  	return fixe + (this.chiffre_affaires/100) ;
  }

}
