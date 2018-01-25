// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Descripteur non valide))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.UserBase;
import dataBase.UserElt;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoginForm;

/** 
 * LoginAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 11-18-2003
 * 
 * XDoclet definition:
 * @struts:action path="/login" name="loginForm" input="/login.jsp" validate="true"
 * @struts:action-forward name="login.jsp" path="login.jsp"
 * @struts:action-forward name="userList.jsp" path="userList.jsp"
 */
public class LoginAction extends Action
{
	// --------------------------------------------------------- Instance Variables
	// --------------------------------------------------------- Methods
	/** 
	 * Method execute
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception
	{
		LoginForm loginForm = (LoginForm)form;

		UserBase ub = (UserBase)getServlet().getServletContext().getAttribute("USERBASE");

		if (ub == null)
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p>Base Inexistante</p>");
			out.close();
		}

		String userName = loginForm.getNom();

		if (ub.containsUser(userName))
		{
			UserElt ue = ub.getUser(userName);
			if (ue.getPassword().compareTo(loginForm.getPass()) == 0)
				return mapping.findForward("log_ok");
			else
			{
				loginForm.setPass(null);
				return mapping.findForward("log_failed");
			}
		}
		else
		{
			loginForm.reset(mapping, request);
			return mapping.findForward("log_failed");
		}
	}
}
