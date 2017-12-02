package employesSansHeritage ;

public abstract class EmployeAvecHSup extends EmployeQuelconque {
    // variable de classe
    protected static double temps_travail, taux_horaire, majoration;
    public double heures;
    protected String nom ;

    public EmployeAvecHSup (String nom) {
      super(nom);
    	temps_travail = 35 ;
      taux_horaire = 7.5 ;
    }
    public void setTravail(double heures) { this.heures = heures ; }

    public double salaireHebdo() {
    	if (heures > temps_travail)
    	    return (temps_travail * taux_horaire)
    	    + (heures - temps_travail) * taux_horaire * majoration ;
    	return heures * taux_horaire ;
    }
}
