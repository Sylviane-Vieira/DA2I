import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/servlet/SelectMD")
public class SelectMD extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		Connection con = null;
		Statement stmt;
		try
		{
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/template1";
			String nom = "mathieu";
			String mdp = "moi";
			
			con = DriverManager.getConnection(url, nom, mdp);
			stmt = con.createStatement();
			String table = req.getParameter("table");
			if (table == null || table.equals(""))
			{
				throw new IllegalArgumentException("Le paramètre table ne peut être vide");
			}
			String query = "select * from " + table;
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int colomnNumber = rsmd.getColumnCount();
			out.println("<!doctype html><html><head><title>pgAdmin</title><META charset=utf-8>");
			out.println("<meta http-equiv=\"X-UA-Compactible\" content=\"IE=edge\">");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println(
			        "<link rel=stylesheet href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
			out.println("</head><body class=\"pagination-centered text-center\">");
			out.println("<h1>Table: " + table + "</h1>");
			out.println("<center>");
			// le formulaire est déclaré au départ pour respecter la norme
			out.println("<form id=\"form\" action=\"./InsertMD\" method=get></form>");
			
			out.println("<table class=\"table-centered table-hover table-condensed table-bordered\">");
			// affichage des entetes de colonnes
			out.println("<tr>");
			for (int i = 1; i <= colomnNumber; i++)
			{
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			out.println("</tr>");
			
			while (rs.next())
			{
				out.println("<tr>");
				
				// affiche toutes les valeurs
				for (int i = 1; i <= colomnNumber; i++)
				{
					out.println("<td>" + rs.getString(i) + "</td>");
				}
				// construction de l'hyperlien DEL
				out.print("<td><a href=DeleteMD?table=" + table);
				for (int i = 1; i <= colomnNumber; i++)
				{
					out.print("&" + rsmd.getColumnName(i) + "=" + rs.getString(i));
				}
				out.println(">DEL</a></td>");
				
				// construction de l'hyperlien MAJ
				out.print("<td><a href=UpdateMD?table=" + table);
				for (int i = 1; i <= colomnNumber; i++)
				{
					out.print("&" + rsmd.getColumnName(i) + "=" + rs.getString(i));
				}
				out.println(">MAJ</a></td>");
				out.println("</tr>");
			}
			
			// formulaire de saisie
			out.println("<tr>");
			for (int i = 1; i <= colomnNumber; i++)
			{
				out.println("<td><input form=\"form\" type=\"input\" name=\"" + rsmd.getColumnName(i) + "\"></td>");
			}
			out.println("</tr>");
			out.println("</table>");
			// on ajoute les champs cachés et le bouton de fin de formulaire
			out.println("<input form=\"form\" type=\"input\" name=table value=\"" + table + "\" hidden>");
			out.println("<input form=\"form\" id=btn type=\"submit\">");
			
			out.println("</center></body></html>");
			
		} catch (Exception e)
		{
			out.println(e.getMessage());
		} finally
		{
			try
			{
				con.close();
			} catch (Exception e)
			{
			}
			;
		}
	}
}
