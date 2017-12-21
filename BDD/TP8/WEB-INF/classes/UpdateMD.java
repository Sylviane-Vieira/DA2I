import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/servlet/UpdateMD")
public class UpdateMD extends HttpServlet
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
			ResultSetMetaData md = stmt.executeQuery("SELECT * FROM " + table).getMetaData();
			
			out.println("<!doctype html><html><head><title>pgAdmin</title><META charset=utf-8>");
			out.println("<meta http-equiv=\"X-UA-Compactible\" content=\"IE=edge\">");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println(
			        "<link rel=stylesheet href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
			out.println("</head><body class=\"pagination-centered text-center\">");
			out.println("<h1>Table: " + table + "</h1>");
			out.println("<center>");
			out.println("<form id=\"form\" action=\"DoUpdateMD\" method=get></form>");
			out.println("<table class=\"table-centered table-hover table-condensed table-bordered\">");
			
			// on affiche les entetes de colonnes
			out.println("<tr>");
			for (int i = 1; i <= md.getColumnCount(); ++i)
			{
				out.print("<th>" + md.getColumnName(i) + "</th>");
			}
			out.println("</tr><tr>");
			
			// On fabrique les chmaps de saisie en les remplissant avec les valeurs de la
			// ligne
			for (int i = 1; i <= md.getColumnCount(); ++i)
			{
				out.println("<td><input form=\"form\" type=\"input\" name=" + md.getColumnName(i) + " value=\""
				        + req.getParameter(md.getColumnName(i)) + "\"></td>");
			}
			out.println("</tr></table>");
			
			// on complète le formulaire avec les anciennes valeurs de la ligne
			for (int i = 1; i <= md.getColumnCount(); ++i)
			{
				out.println("<input form=\"form\" type=hidden name=\"EX" + md.getColumnName(i) + "\" value=\""
				        + req.getParameter(md.getColumnName(i)) + "\" >");
			}
			out.println("<input form=\"form\" type=hidden name=table value=" + table + " >");
			out.println("<input form=\"form\" id=btn type=\"submit\">");
			out.println("</center></body></html>");
			
		} catch (Exception e)
		{
			out.println("ERREUR Exception:" + e.getMessage());
			
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
