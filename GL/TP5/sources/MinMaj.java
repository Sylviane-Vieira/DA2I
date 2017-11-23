import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class MinMaj {
    public static void main (String [] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("entrez une phrase :");
	String str = sc.nextLine();
	StringTokenizer st = new StringTokenizer(str);
	while (st.hasMoreTokens()){
	    if ((st.countTokens())%2==0)
		System.out.println( st.nextToken().toUpperCase());
	    else
		System.out.println(st.nextToken());
        }
	}
}
	
	
