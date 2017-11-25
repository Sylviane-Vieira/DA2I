package employesSansHeritage ;

public abstract class EmployeQuelconque {
    protected String nom ;

    public EmployeQuelconque (String nom) {
    	this.nom = nom ;
    }

    /*methodes abstraites dont peuvent hériter Commercial et EmployeAvecHSup*/
    /*peuvent re réécrites avec le code propre à la classe*/
    public abstract void setTravail(double x) ;

    public abstract double salaireHebdo();

    public String toString() { return nom ; }
}
