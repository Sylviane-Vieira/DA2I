import java.sql.*;

public class TestDB {
    
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
		
	finally {
	    try {
		//fermeture connexion
		con.close();
		System.out.println("Connexion effectuée");
	    }
	    catch (Exception ex){
		System.out.print("pb fermeture connexion !" + ex.getMessage());
	    }

	}

    }
}
