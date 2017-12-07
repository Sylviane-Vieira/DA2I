package comptes ;
/** La classe <code>CompteCourant</code> d�crit le fonctionnement
 * d'un compte de retrait courant (celui par exemple sur lequel on
 * dispose d'une carte bleue). Elle d�rive de <code>CompteGenerique</code>
 * donc la plupart des m�thodes sont automatiquement h�rit�es.
 */
public class CompteCourant extends CompteGenerique
{
    /** Constante facultative donnant le taux d'aggios pour les comptes r�cents */
    public static double AGGIOS1 = 0.1 ;
    /** Constante facultative donnant le taux d'aggios pour les comptes anciens */
    public static double AGGIOS2 = 0.06 ;
    /** Constante facultative donnant le nombre de mois � partir duquel un
     * compte est consid�r� comme ancien */
    public static int AGE_CHARNIERE = 60 ;

    /** Le niveau du d�couvert autoris� */
    protected double decouvert_autorise ;

    /** Constructeur permettant d'instancier un compte courant d'un
     * num�ro sp�cifi�, pour un certain d�couvert autoris�. */
    public CompteCourant(int numero, double decouvert_autorise) 
    { 
	// premi�re �tape : appeler le code du constructeur de CompteGenerique
	super(numero) ;
	// puis on stocke le param�tre dans l'attribut
	this.decouvert_autorise = decouvert_autorise ;
    }

    /** Tente d'effectuer un retrait de la somme sp�cifi�e sur le compte.
     * Dans le cas pr�sent il faut que le compte reste au-dessus de 
     * (-decouvert_autorise), ce qui revient � dire que la somme doit �tre
     * inf�rieure au montant + d�couvert. 
     */
    public void retirer(double somme) 
    {
	if (somme <= montant + decouvert_autorise)
	    montant = montant - somme ;
    }

    /** M�thode calculant les aggios en cas de d�couvert */
    protected double calculerAggios()
    {
	if (anciennete < AGE_CHARNIERE)
	    return AGGIOS1 * montant ;
	return AGGIOS2 * montant ;
    }

    /** Effectue les op�rations mensuelles de maintenance du compte. Cette m�thode est
     *  susceptible de d�clencher des exceptions si des anomalies sont d�tect�es. 
     *  Dans le cas d'un compte courant, il faut d'abord effectuer les op�rations
     *  propres � tous les comptes (la m�thode d�finie dans la superclasse), puis
     *  v�rifier s'il y a des aggios � d�biter, et enfin d�clencher une exception si
     *  le montant du compte est pass� en dessous (en n�gatif) du d�couvert autoris�. 
     */
    public void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc 
    {
	super.operationsMensuelles() ; // incr�mente l'anciennet�
	if (montant < 0) // si le solde est n�gatif il faut payer des aggios
	    {
		double aggios = this.calculerAggios() ; // nombre n�gatif !
		System.out.println("Aggios d�bit�s ce mois : " + aggios) ;
		this.ajouter(aggios) ; // ajout car n�gatif ; il ne faut 
		// de toute fa�on pas utiliser retirer car cette m�thode comporte
		// des conditions qui conduisent parfois � ne pas retirer les aggios
		if (Math.abs(montant) > decouvert_autorise)
		    throw new DepassementDecouvertExc(this.getNumero()) ;
	    }
    }
}
