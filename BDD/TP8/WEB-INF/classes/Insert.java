import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/servlet/Insert")
public class Insert extends HttpServlet
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
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String url = "jdbc:postgresql://localhost/template1";
		String nom = "mathieu";
		String mdp = "moi";
		String query = "";
		try
		{
			con = DriverManager.getConnection(url, nom, mdp);
			stmt = con.createStatement();
			String nomQuerry = req.getParameter("nom");
			String prenomQuerry = req.getParameter("prenom");
			int age = Integer.valueOf(req.getParameter("age"));
			query = "Insert into CLIENTS values('" + nomQuerry + "','" + prenomQuerry + "','" + age + "')";
			out.println("Query: " + query);
			int rs = stmt.executeUpdate(query);
			out.println("rs: " + rs);
		} catch (Exception e)
		{
			out.println("ERREUR Exception:" + e.getMessage());
		} finally
		{
			res.sendRedirect("./Select#btn");
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
