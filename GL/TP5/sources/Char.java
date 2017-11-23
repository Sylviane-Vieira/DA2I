import java.util.*;

public class Char {
    public static void main (String [] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("entrez une phrase :");
	String str = sc.nextLine();
	str = str.toUpperCase();
	ArrayList <Character> liste = new ArrayList<>();
	for (int i=0; i<str.length();i++){
	    if (Character.isLetter(str.charAt(i)))
		liste.add(str.charAt(i));
	}
        Iterator<Character> it = liste.iterator();
	while (it.hasNext())
	    System.out.print(it.next());

	Stack<Character> pile = new Stack<Character>();
	for (int i=0; i<str.length();i++){
	    if (Character.isLetter(str.charAt(i)))
		pile.push(str.charAt(i));
	}
	Iterator<Character> it2 = pile.iterator();
	while (!pile.empty())
	    System.out.print(pile.pop());
    }
}
