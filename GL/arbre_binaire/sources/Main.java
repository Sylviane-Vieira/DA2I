public class Main{
    public static void main (String [] args){
	NoeudArbre arbre = new NoeudArbre("Est-ce un mamifere ?", new NoeudArbre("un crocodile"), new NoeudArbre("Est-ce qu'il aboie ?", new NoeudArbre("un cheval"), new NoeudArbre("un chien")));
        System.out.println(arbre);
	System.out.println("Pensez à un animal, je vais essayer de le deviner…");
	arbre.rechercherAnimal();
    }
}
