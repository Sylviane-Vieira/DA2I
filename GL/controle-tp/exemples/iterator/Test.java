public class Test {
	
   public static void main(String[] args) {
      AgregatConcret a = new AgregatConcret();

      for(Iterateur<String> iter = a.creerIterateur(); iter.aUnSuivant();){
         String name = iter.elementSuivant();
         System.out.println("Name : " + name);
      }
   }
}
