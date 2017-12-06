import java.util.*;

/*classe dont les reponses sont des valeurs numériques à choisir parmi une liste de possibilités*/
public class QuestionNumeriqueOuverte extends QuestionNumerique implements VerificateurNumerique{
      /** la chaîne attendue */
      protected VerificateurNumerique verif;
      /** la chaîne donnée par le joueur */
      protected String reponseDuJoueur ;
      protected String bonneReponse;

  public QuestionNumeriqueOuverte (String e,  VerificateurNumerique verif , String r, int v){
    super(e, r, v) ;
    this.verif = verif;
  }

  /** méthode permettant de lire la réponse du joueur */
  public void saisirReponseJoueur() {
    reponseDuJoueur = Clavier.readString() ;
  }
    public boolean verifier( int x){
      return this.verif;
    }

  /** méthode retournant vrai si la réponse du joueur est correcte*/
  public boolean bonneReponseTrouvee() {
    return this.verif = true;
  }

  /** renvoie la réponse correcte */
  public String donnerBonneReponse()  { return bonneReponse ; }
}
