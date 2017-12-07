public class AgregatConcret implements Agregat<String> {
   public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

   public Iterateur<String> creerIterateur() {
      return new MonIterateur();
   }

   private class MonIterateur implements Iterateur<String> {
       int index;
       
       public boolean aUnSuivant() {	   
	   return (index < names.length)?true:false;
      }

      public String elementSuivant() {
         if (this.aUnSuivant()) return names[index++];
         return null; // Pas bien! devrait normalement lever une exception
      }		
   }
}
