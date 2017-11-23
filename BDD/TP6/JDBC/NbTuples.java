import java.sql.*;

public class NbTuples {
    
    public static void main (String [] args) {

	Connection con = null;
	Statement stmt;
	String query = "select count(*) from Clients";
	int nbLignes;
	
	try{
	    //enregistrement du driver
	    Class.forName("org.postgresql.Driver");

	    //connexion a la base de donnees
	    String url = "jdbc:postgresql://psqlserv/da2i";
	    String nom = "vieiras";
	    String mdp = "moi";
	    con = DriverManager.getConnection(url, nom, mdp);
	}
	
	catch (Exception e){
	    System.out.print("pb connexion !" + e.getMessage());
	}

	
	//compter le nombres de tuples
	try {
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    nbLignes = 0;
	    if (rs.next()) nbLignes = rs.getInt(1);
	    System.out.println("La table contient " + nbLignes + " colonne(s)");
		}
	catch (Exception e) {
	    System.out.print("l'operation n'a pas pu etre effectuee" + e.getMessage());
	}

	//Quoi qu'il advienne, fermeture de la connexion
	finally {
	 
	    try {
		con.close();
		System.out.println("Connexion effectuee");
	    }//fin du try
	    catch (Exception connect){
		System.out.print("pb fermeture connexion !" + connect.getMessage());
	    }//fin du catch
	}//fin du finally

    }//fin du main
}//fin de la classe
