package dataBase;
/**
 * Defines a user with his name and his first name.
 * @author JC
 */

public class UserElt
{
	private String name;
	private String firstname;
	private String password;

	public UserElt()
	{
	}

	public UserElt(String name, String firstname, String password)
	{
		this.name = new String(name);
		this.firstname = new String(firstname);
		this.password = new String(password);
	}

	/**
	 * @return
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param string
	 */
	public void setFirstname(String string)
	{
		firstname = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string)
	{
		name = string;
	}

	/**
	 * @return
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string)
	{
		password = string;
	}

	public String toString()
	{
		return name + " " + firstname + " " + password;
	}

}
