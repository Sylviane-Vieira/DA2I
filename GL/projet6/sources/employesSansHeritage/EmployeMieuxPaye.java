package employesSansHeritage ;

public class EmployeMieuxPaye extends EmployeAvecHSup {

  public EmployeNormal(String nom) {
    super (temps_travail, taux_horaire, nom);
    majoration = 1.4 ;
  }
}
