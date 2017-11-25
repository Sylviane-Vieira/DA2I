import animaux.* ;

public class Test {
  public static void main(String[] args) {
    try{
      Animal p1 = Phenix.uniqueInstance();
      Animal p2 = Phenix.uniqueInstance();
      /*donne deux instances du même objet*/
      System.out.println(p1);
      System.out.println(p2);
      System.out.println("C’est bien le même phénix : " + (p1 == p2));
      Animal p3 = Phenix.uniqueInstance();
      Animal p4 = new Phenix("Albert");
      /*renvoie deux objets différents*/
      System.out.println(p3);
      System.out.println(p4);
      System.out.println("C’est bien le même phénix : " + (p3 == p4));
    }
    catch (UniciteDuPhenixException e){
      System.out.println("Message :" + e.getMessage());
    }
  }
}
