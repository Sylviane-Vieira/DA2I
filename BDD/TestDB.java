import java.sql.*;

public class TestDB {
    public static void main (String [] args){
	
	//enregistrement du driver
	Class.forName ("org.postgresql.Driver");

	//connexion à la base de données
	String url = "jdbc:postgresql://psqlserv/da2i";
	String nom = vieiras;
	String mdp = "moi";
	Connection con = DriverManager.getConnection(url, nom, mdp);
	System.out.print("Youpi !");

	con.close();
    }
}
