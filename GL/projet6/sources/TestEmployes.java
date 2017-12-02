import employesSansHeritage.*;
public class TestEmployes {
public static void main(String[] args) {
  EmployeNormal e1 = new EmployeNormal("Jules");
  e1.setTravail(40);
  System.out.println(e1.salaireHebdo());
  EmployeMieuxPaye e2 = new EmployeMieuxPaye("Paul");
  e2.setTravail(40);
  System.out.println(e1.salaireHebdo());
  Commercial c1 = new Commercial("Pat", 1500);
  c1.setTravail(40000.0);
  System.out.println(c1.salaireHebdo());
  Commercial c2 = new Commercial("Mat", 2000);
  c2.setTravail(80000.0);
  System.out.println(c2.salaireHebdo());
  Commercial c3 = new Commercial("Nat", 1500);
  c3.setTravail(100000.0);
  System.out.println(c3.salaireHebdo());
  System.out.println(Commercial.getNbCommerciaux());
  Directeur d = new Directeur ("Jean", 5000);
  System.out.println(d.salaireHebdo());
  System.out.println(Commercial.getCaTotal());
  }
}
