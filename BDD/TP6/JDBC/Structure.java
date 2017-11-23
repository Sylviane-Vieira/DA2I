import java.sql.*;

public class Structure {
    
    public static void main (String [] args) {

	Connection con = null;
	Statement stmt;
	String query = "select * from Clients";
	
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
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int nbCol = rsmd.getColumnCount();
	    System.out.println("La table contient " + nbCol + " colonnes");

	    for (int i = 1; i <= nbCol; i++)
		{
		    System.out.println("Colonne "+ i);
		    System.out.println("Nom  : " + rsmd.getColumnName(i));
		    System.out.println("Type : " +  rsmd.getColumnTypeName(i));
		    System.out.println("");
		}
	}
	catch (Exception e) {
	    System.out.print("la table n'a pas pu etre supprimee" + e.getMessage());
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
