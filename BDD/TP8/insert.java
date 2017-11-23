import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("*/servlet/Insert")
public class Insert extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
    {
	res.setContextType ("text.html");
	PrintWriter out = res.getWriter();
	out.println("<html> <body>");
	

}
