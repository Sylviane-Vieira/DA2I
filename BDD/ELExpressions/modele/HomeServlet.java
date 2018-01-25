// Servlet HomeServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet-Home")
public class HomeServlet extends HttpServlet
{
  public void service( HttpServletRequest req, HttpServletResponse res )
       throws ServletException, IOException
  {
    PrintWriter out = res.getWriter();

    res.setContentType( "text/html" );

// cree un employe de type Personne
    Personne personne = new Personne ();
    personne.setNom("Paul");
    request.setAttribute("personne, personne");

// un employe de type Employe et le range dans session
    Employe emp = new Employe();
    Adresse add = new Adresse();
    add.setAdresse("Lille");
    emp.setAdresse(add);
    emp.setId(1);
    emp.setNom("Pierre");

    HttpSession session = request.getSession();
    session.setAttribute("employe", emp);

//cree un cookie chez utilisateur
    reponse.addCookie(new Cookie("User.Cookie", "Chez_Utilisateur"));

    //cree un cookie rangé dans le scope
    getServletContext().setAttribte("User.Cookie", "Dans Le Contexte");

    //redirection
    RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
    rd.forward(request, response);
  }
