package employesSansHeritage ;

public class EmployeNormal extends EmployeAvecHSup{

    public EmployeNormal(String nom) {
    	super (temps_travail, taux_horaire, nom);
      majoration = 1.25 ;
    }
}
