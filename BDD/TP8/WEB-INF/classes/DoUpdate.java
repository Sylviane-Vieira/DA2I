import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/servlet/DoUpdateMD")
public class DoUpdate extends HttpServlet
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
			String query = "";
			
			con = DriverManager.getConnection(url, nom, mdp);
			stmt = con.createStatement();
			String nomtable = req.getParameter("table");
			ResultSetMetaData md = stmt.executeQuery("SELECT * FROM " + nomtable).getMetaData();
			
			query = "UPDATE " + nomtable + " SET ";
			// SET avec les nouvelles valeurs
			query += "" + md.getColumnName(1) + "='" + req.getParameter(md.getColumnName(1)) + "'";
			for (int i = 2; i <= md.getColumnCount(); ++i)
			{
				query += "," + md.getColumnName(i) + "='" + req.getParameter(md.getColumnName(i)) + "'";
			}
			query += " WHERE ";
			// WHERE avec les anciennes valeurs
			query += md.getColumnName(1) + "='" + req.getParameter("EX" + md.getColumnName(1)) + "'";
			for (int i = 2; i <= md.getColumnCount(); ++i)
			{
				query += " AND " + md.getColumnName(i) + "='" + req.getParameter("EX" + md.getColumnName(i)) + "'";
			}
			
			out.println("Query: " + query);
			stmt.executeUpdate(query);
			res.sendRedirect("SelectMD?table=" + nomtable);
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
