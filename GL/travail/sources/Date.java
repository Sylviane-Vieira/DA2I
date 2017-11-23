public class Date
{
    // les attributs des instances
    private int jour, mois, annee ;
    private String lang;
    // les attributs de la classe
    public static final String [] NOM_DES_MOIS =
    { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet",
      "Aout", "Septembre", "Octobre", "Novembre", "Decembre" } ;
    public static final String [] MONTH_NAME =
    {"January", "february", "March", "April", "May", "June", "July",
     "August", "September", "October", "November", "December" } ;
    public Date(int jour, int mois, int annee, String lang)
    {
        this.jour = jour ;
        this.mois = mois ;
        this.annee = annee ;
	this.lang = lang;
    }
    public static final String [] LANGUE = {"-francais", "-anglais"};
    public String toString()
    {
	if (this.lang.equals("-anglais")){
		return jour + " " + MONTH_NAME[mois-1] + " " + annee ;}
	else
	    return jour + " " + NOM_DES_MOIS[mois-1] + " " + annee ;
    }
    public static void main(String [] arg){
	System.out.println("Jour");
	int j = Clavier.readInt();
	System.out.println("Mois");
	int m = Clavier.readInt();
	System.out.println("Annee");
	int a = Clavier.readInt();
	String l = arg[0];

	Date d = new Date(j,m,a,l);
	System.out.println(d);
    }
	
}


