package dataBase;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Allows to stock some users in an HashTable
 * @author JC
 */

public class UserBase
{
	private final int NUMBER_OF_USER = 20;
	private LinkedHashMap map;

	public UserBase()
	{
		map = new LinkedHashMap(NUMBER_OF_USER);
	}

	public boolean addUser(UserElt u)
	{
		if (map.containsKey(u.getName()))
			return false;
		else
			map.put(u.getName(), u);

		return true;
	}

	public UserElt getUser(String nom)
	{
		return (UserElt)map.get(nom);
	}

	public boolean containsUser(String nom)
	{
		return map.containsKey(nom);
	}

	public String toString()
	{
		String s = new String("");

		Collection c = map.values();
		Iterator i = c.iterator();

		while (i.hasNext())
			s = s + (UserElt)i.next() + "\r\n";

		return s;
	}
}
