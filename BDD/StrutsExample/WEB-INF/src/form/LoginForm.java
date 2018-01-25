// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionMessage;

/** 
 * LoginForm.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 11-18-2003
 * 
 * XDoclet definition:
 * @struts:form name="loginForm"
 */
public class LoginForm extends ActionForm
{
	// --------------------------------------------------------- Instance Variables
	/** pass property */
	private String pass;
	/** nom property */
	private String nom;

	// --------------------------------------------------------- Methods

	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		nom = null;
		pass = null;
	}

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request)
	{
		ActionErrors ae = new ActionErrors();

		if (nom.length() == 0)
		{
			ae.add(nom, new ActionError("error.login"));
//			ae.add(nom, new ActionMessage("error.login"));
		}
		if (pass.length() == 0)
		{
			ae.add(nom, new ActionError("error.password"));
//			ae.add(nom, new ActionMessage("error.password"));
		}

		return ae;

//		throw new UnsupportedOperationException("Generated method 'validate(...)' not implemented.");
	}
	/** 
	 * Returns the pass.
	 * @return String
	 */
	public String getPass()
	{
		return pass;
	}
	/** 
	 * Set the pass.
	 * @param pass The pass to set
	 */
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	/** 
	 * Returns the nom.
	 * @return String
	 */
	public String getNom()
	{
		return nom;
	}
	/** 
	 * Set the nom.
	 * @param nom The nom to set
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
