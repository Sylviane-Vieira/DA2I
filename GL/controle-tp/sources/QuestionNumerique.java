/*classe dont les reponses sont des valeurs numériques*/
public class QuestionNumerique extends Question {
      /** la chaîne attendue */
      protected String bonneReponse ;
      /** la chaîne donnée par le joueur */
      protected String reponseDuJoueur ;

  public QuestionNumerique (String e, String r, int v){
    super(e, v) ;
    bonneReponse = r ;
  }

  /** méthode permettant de lire la réponse du joueur */
  public void saisirReponseJoueur() {
    reponseDuJoueur = Clavier.readString() ;
  }

  /** méthode retournant vrai si la réponse du joueur est correcte*/
  public boolean bonneReponseTrouvee() {
    return reponseDuJoueur == bonneReponse ;
  }

  /** renvoie la réponse correcte */
  public String donnerBonneReponse()  { return bonneReponse ; }
}
