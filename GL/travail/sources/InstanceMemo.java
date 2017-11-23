import java.util.*;

public class InstanceMemo {
    //une liste d'instances
    private static ArrayList instances = new ArrayList();
    
    //constructeur
    public InstanceMemo() {
	this.instances.add(instances.size()+1);
    }
    //methode compteur
    public static int nombreInstances(){
	return instances.size();
    }
    //methode affichage
    public static void afficherInstances(){
	for (int i=0; i<=10; i++){
	    System.out.println("Je suis l'instance numero :" +i);
	}
    }

    //tests
    public static void main (String [] args)
    {
        int i ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo") ;
        for (i=1; i<=4; i++) new InstanceMemo() ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo : ") ;
        InstanceMemo.afficherInstances() ;
        for (i=1; i<=10; i++) new InstanceMemo() ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo : ") ;
        InstanceMemo.afficherInstances() ;
    }
}
