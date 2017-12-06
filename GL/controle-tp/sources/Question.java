
/*classe Question qui représente l'ensemble des questions de tout type*/
public class Question {
  protected String enonce;
  protected int valeur;

  public Question(String e, int v){
    this.enonce = e;
    this.valeur = v;
  }

  public String toString(){
    return " "+this.enonce;
  }

  public int getValeur() {
    return this.valeur;
  }
}
