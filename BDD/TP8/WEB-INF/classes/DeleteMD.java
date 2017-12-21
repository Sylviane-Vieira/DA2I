import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/servlet/DeleteMD")
public class DeleteMD extends HttpServlet
{
	public void service( HttpServletRequest req, HttpServletResponse res )
			throws ServletException, IOException
	{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		Connection con=null;
		Statement stmt;
		try{
		    Class.forName("org.postgresql.Driver");
		    String url = "jdbc:postgresql://localhost/template1";
		    String nom = "mathieu";
		    String mdp = "moi";
		    con = DriverManager.getConnection(url,nom,mdp);
		    
		    stmt = con.createStatement();
		    String table=req.getParameter("table");
		    if(table==null || table.equals("")){
			throw new IllegalArgumentException("Le param table ne peut être vide");
		    }
		    ResultSetMetaData md=stmt.executeQuery("SELECT * FROM "+table).getMetaData();
		    String query="";
		    query = "DELETE FROM "+table+" WHERE "+md.getColumnName(1)+"="+"'"+req.getParameter(md.getColumnName(1))+"'";
		    for(int i=2;i<=md.getColumnCount();++i){
			query+= " AND "+md.getColumnName(i)+"="+"'"+req.getParameter(md.getColumnName(i))+"'";
			out.println(query);
			stmt.executeUpdate(query);
		    }
		    res.sendRedirect("SelectMD?table="+table);
		}catch(Exception e){
		    out.println(e.getMessage());
		}finally{
		    try{
			con.close();
		    }catch(Exception e){};
		}
	}
}

