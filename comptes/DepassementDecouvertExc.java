package comptes ;
/** Exception � lever dans le cas d'un solde n�gatif 
 * d�passant le d�couvert autoris� d'un compte courant */
public class DepassementDecouvertExc extends Exception
{
    public DepassementDecouvertExc(int num_compte)
    {
	super("Depassement du d�couvert autoris� sur le "
	      + "compte n� " + num_compte) ;
    }
}
