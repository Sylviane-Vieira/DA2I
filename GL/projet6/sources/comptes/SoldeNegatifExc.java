package comptes ;
/** Exception � lever dans le cas d'un solde n�gatif 
 * d�passant le d�couvert autoris� d'un compte courant */
public class SoldeNegatifExc extends Exception
{
    public SoldeNegatifExc(String message)
    {
	super(message) ;
    }
}
