package comptes ;
/** Exception a lever dans le cas d'un solde negatif 
 * depassant le decouvert autorise d'un compte courant */
public class SoldeNegatifExc extends Exception
{
    public SoldeNegatifExc(String message)
    {
	super(message) ;
    }
}
