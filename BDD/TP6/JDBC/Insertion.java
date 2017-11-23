import java.sql.*;

public class Insertion {
    
    public static void main (String [] args) {

	Connection con = null;
	Statement stmt;
	
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

	
	//erreur d'insertion
	try {
	    stmt = con.createStatement();
	    stmt.executeUpdate("insert into Clients " +
			       "values('Durand', 'Paul', 10)");
	}
	catch (Exception e) {
	    System.out.print("Erreur d'insertion" + e.getMessage());
	}

	//Quoi qu'il advienne, fermeture de la connexion
	finally {
	 
	    try {
		con.close();
		System.out.println("Connexion effectuee");
	    }
	    catch (Exception connect){
		System.out.print("pb fermeture connexion !" + connect.getMessage());
	    }
	}

    }
}
