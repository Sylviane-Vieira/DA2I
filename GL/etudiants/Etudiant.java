import java.util.*;

public class Etudiant{
    private String nom, prenom;
    private double [] notes, moyenne;

    public Etudiant() {
	Scanner lectureClavier = new Scannner(System.in);
	System.out.print("Entrez le nom de l'etudiant :");
	nom = lectureClavier.next();
	Scanner lectureClavier = new Scannner(System.in);
	System.out.print("Entrez le prenom de l'etudiant :");
	prenom = lectureClavier.next();
	Scanner lectureClavier = new Scannner(System.in);
	System.out.print("Combien de notes pour l'etudiant");
	System.out.print(prenom + " "+nom+" : ");
	int nombre = lectureClavier.nextInt();
	notes = new double [nombre];
	for (int i = 0; i < notes.length; i++){
	    System.out.print("Entrez la note n°"+ (i + 1) + " : ");
	    notes[i] = lectureClavier.nextDouble();
	}
	moyenne = calculMoyenne();
    }
    private double CalculMoyenne(){
	double somme = 0.0;
	for (double valeurNote : notes) somme = somme +
}
