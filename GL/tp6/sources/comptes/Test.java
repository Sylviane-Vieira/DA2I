package comptes;

public class Test {
  public static void main(String[] args) {
    Pel pel = new Pel(5,3,1500.10, 0.05);
    try{
      pel.ajouter(20);
      pel.retirer(200);
      pel.retirer(400);
      pel.retirer(2000);
      pel.operationsMensuelles();
    } catch (VersementsInsuffisantsExc e) {
      System.out.println(e.getMessage());
    }finally{
      pel.ajouter(50);
      try{
        pel.operationsMensuelles();
      } catch (VersementsInsuffisantsExc e) {
          System.out.println(e.getMessage());
        }
      System.out.println(pel);
    }
  }
}
