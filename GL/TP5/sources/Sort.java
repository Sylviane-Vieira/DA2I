import java.util.*;

public class Sort {
    public static void main (String [] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("entrez une phrase :");
	String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str);
	ArrayList <String> liste = new ArrayList<>();
	while (st.hasMoreTokens()) liste.add(st.nextToken());
	Collections.sort(liste);
	System.out.println(liste);
    }
}
	
	
