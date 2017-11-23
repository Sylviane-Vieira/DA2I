public class ObjetNumerote{
    //attribut de la classe 
    private int numero;
    private int compteur = 0;
    
    //constructeur
    public ObjetNumerote () {
	this.numero = compteur++;
    }
    
    //affichage
    public String toString(){return "objet numero :" + numero;}
    //main
    public static void main (String [] arg){
	//imprime les objets de 1 a 4
	for (int i=1;i<5;i++){
	    System.out.println(new ObjetNumerote());
	}
    }
}
