import java.util.* ;

public class Utiles {
    public static final Scanner clavier = new Scanner(System.in) ;
    public static void exercice1() {
	System.out.println("Q1 - Majuscules et minuscules") ;
	String s ;
	StringTokenizer t ;
	System.out.print("Entrez une phrase : ") ;
	s = clavier.nextLine() ;
	t = new StringTokenizer(s) ;
	while (t.hasMoreTokens()) {
	    System.out.print(t.nextToken().toUpperCase() + " ") ;
	    if (t.hasMoreTokens())
		System.out.print(t.nextToken().toLowerCase() + " ") ;
	}
	System.out.println() ;
    }

    public static void exercice2() {
	System.out.println("Q2 - Tri") ;
	String s ;
	StringTokenizer t ;
	List l = new ArrayList() ;
	System.out.print("Entrez une phrase : ") ;
	s = clavier.nextLine() ;
	t = new StringTokenizer(s) ;
	while (t.hasMoreTokens()) 
	    l.add(t.nextToken()) ;
	Collections.sort(l) ;
	Iterator it = l.iterator() ;
	while (it.hasNext())
	    System.out.print(it.next()+" ") ;
	System.out.println() ;
    }

    public static void exercice31() {
	System.out.println("Q3 - Renversements") ;
	System.out.print("Entrez une phrase : ") ;
	String s = clavier.nextLine() ;
	ArrayList l1, l2 ;
	Stack st = new Stack() ;
	Iterator it ;
	l1 = new ArrayList() ;
	l2 = new ArrayList() ;
	for (int i = 0 ; i < s.length() ; i++)
	    if (Character.isLetter(s.charAt(i))) {
		Character c = new Character(Character.toUpperCase(s.charAt(i))) ;
		l1.add(c) ;
		st.push(c) ;
	    }
	it = l1.iterator() ;
	while (it.hasNext()) System.out.print(it.next()) ;
	System.out.println() ;

	while (!st.empty()) l2.add(st.pop()) ;
	it = l2.iterator() ;
	while (it.hasNext()) System.out.print(it.next()) ;
	System.out.println() ;
	System.out.println("Palindrome : " + (l1.equals(l2))) ;
    }

    public static void exercice32() {
	System.out.println("Q4 - Renversements") ;
	System.out.print("Entrez une phrase : ") ;
	String s = clavier.nextLine() ;
	Stack st = new Stack() ;
	StringTokenizer t = new StringTokenizer(s) ;
	while (t.hasMoreTokens()) st.push(t.nextToken()) ;
	while (!st.empty()) System.out.print(st.pop() + " ") ;
	System.out.println() ;
    }
    
    public static String inverse(String s) {
	Stack st = new Stack() ;
	String r = "" ;
	for (int i = 0; i < s.length() ; i++)
	    st.push(new Character(s.charAt(i))) ;
	while (!st.empty()) r += st.pop() ;
	return r ;
    }

    public static void exercice33() {
	System.out.println("Q5 - Renversements") ;
	System.out.print("Entrez une phrase : ") ;
	String s = clavier.nextLine() ;
	StringTokenizer t = new StringTokenizer(s) ;
	while (t.hasMoreTokens()) 
	    System.out.print(inverse(t.nextToken()) + " ") ;
	System.out.println() ;
    }

    public static void exercice41() {
	System.out.println("Q6 - Recensements") ;
	BitSet bs = new BitSet() ;
	System.out.print("Entrez une phrase : ") ;
	String s = clavier.nextLine() ;
	for (int i = 0; i < s.length() ; i++)
	    bs.set(s.charAt(i)) ;
	for (char c = 32; c < 256; c++)
	    if (bs.get(c)) System.out.print(c+" ") ;
	System.out.println() ;
    }
    
    public static void exercice42() {
	System.out.println("Q7 - Recensements") ;
	HashSet h = new HashSet() ;
	System.out.print("Entrez une phrase : ") ;
	String s = clavier.nextLine() ;
	for (int i = 0; i < s.length() ; i++)
	    h.add(new Character(s.charAt(i))) ;
	Iterator it = h.iterator() ;
	while (it.hasNext()) System.out.print(it.next() + " ") ;
	System.out.println() ;
    }

    public static void exercice43() {
	System.out.println("Q8 - Recensements") ;
	System.out.print("Entrez une phrase : ") ;
	String s = clavier.nextLine() ;
	HashMap<Character,Integer> m = countLetters(s) ;
	for (char clef: m.keySet()) 
	    System.out.print(clef + "->" + m.get(clef) + "\t") ;
	System.out.println() ;
    }

    public  static HashMap<Character,Integer> countLetters(String s) {
	HashMap<Character,Integer> m = new HashMap<Character,Integer>() ;
	for (int i = 0; i < s.length() ; i++) {
	    Character c = Character.toUpperCase(s.charAt(i)) ;
	    if (m.containsKey(c)) 
		m.put(c, m.get(c)+1) ;
	    else m.put(c, 1) ;
	}
	return m ;
    }
	    
    
    public static void exercice5(String [] a) {
	System.out.println("Q9 - Anagrammes") ;
	System.out.print(a[0] + " et " + a[1]) ;
	if (countLetters(a[0]).equals(countLetters(a[1])))
	    System.out.println(" sont des anagrammes") ;
	else
	    System.out.println(" ne sont pas des anagrammes") ;
    }
    
    public static void main(String [] a) {
	exercice1() ;
	exercice2() ;
	exercice31() ;
	exercice32() ;
	exercice33() ;
	exercice41() ;
	exercice42() ;
	exercice43() ;
	if (a.length > 1) exercice5(a) ;
	else System.out.println("Pour le dernier exercice il faut au moins deux mots en argument");
    }
}
