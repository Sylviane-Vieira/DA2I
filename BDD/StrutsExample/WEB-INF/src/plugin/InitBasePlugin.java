package plugin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import dataBase.UserBase;
import dataBase.UserElt;

/**
 * Allow to init UserBase in ServletContext
 * @author JC
 */

public class InitBasePlugin implements PlugIn
{
	UserBase ub = null;

	public InitBasePlugin()
	{
		super();
	}

	public void destroy()
	{
		System.out.println("sauvegarde de la base...");

		try
		{
			FileWriter f = new FileWriter("base.txt");
			BufferedWriter fileOut = new BufferedWriter(f);
			f.write(ub.toString());

			fileOut.close();
			f.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void init(ActionServlet arg0, ModuleConfig arg1) throws ServletException
	{
		ServletContext context = arg0.getServletContext();
		ub = (UserBase)context.getAttribute("USERBASE");

		if (ub == null)
		{
			ub = new UserBase();

			try
			{
				boolean boucle = true;
				FileReader f = new FileReader("base.txt");
				BufferedReader fileIn = new BufferedReader(f);
	
				String line = null;
				do
				{
					line = fileIn.readLine();
	
					if (line == null)
						boucle = false;
					else
						addLineToBase(line);
				}
				while (boucle);
	
				fileIn.close();
				f.close();
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Impossible de trouver le fichier 'base.txt'");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			context.setAttribute("USERBASE", ub);
		}
		else
		{
			System.out.println("Base existante !!!");
		}

		System.out.println(ub.toString());

	}

	private void addLineToBase(String s)
	{
		StringTokenizer st = new StringTokenizer(s, " ");
		ub.addUser(new UserElt(st.nextToken(), st.nextToken(), st.nextToken()));
	}
}
