import java.sql.*;

public class Table {
    
    public static void main (String [] args) {

	Connection con = null;
	
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

	
	//suppression table si existe
	try {
	    Statement stmt = con.createStatement();
	    stmt.executeUpdate("drop table Clients");
	}
	catch (Exception e) {
	    System.out.print("la table n'a pas pu etre supprimee" + e.getMessage());
	}

	
        //creation table
	try {
	    Statement stmt = con.createStatement();
	    stmt.executeUpdate("create table Clients" +
			       "(NOM varchar(10), PRENOM varchar(10), AGE int)");
	}
	catch (Exception e) {
	    System.out.print("la table n'a pas pu etre creee" + e.getMessage());
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
