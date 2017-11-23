import java.sql.*;

public class ListeClients {
    
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

	
	//affichage de la liste des clients
	try {
	    stmt = con.createStatement();
	    String query = "select NOM, PRENOM, AGE from Clients";
	    ResultSet rs = stmt.executeQuery(query);

	    System.out.println("Liste des clients :");
	    while (rs.next()) {
		String n = rs.getString("nom"); //col 1
		String p = rs.getString("prenom"); //col 2
	        int a = rs.getInt("age"); //col 3	
		System.out.println(n + " " + p + " " + a + " ans");
	    }
	}
	catch (Exception e) {
	    System.out.print("la table n'a pas pu etre supprimee" + e.getMessage());
	}

	//Quoi qu'il advienne, fermeture de la connexion
	finally {
	 
	    try {
		con.close();
		System.out.println("Connexion effectuée");
	    }
	    catch (Exception connect){
		System.out.print("pb fermeture connexion !" + connect.getMessage());
	    }
	}

    }
}
