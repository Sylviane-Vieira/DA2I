package modele;

public class Employe implements Personne {
  private String nom;
  private int id;
  private Adresse adresse;

  public Employe () {}

  public String getNom () {
    return this.nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
  public int getId () {
    return id;
  }
  public Adresse getAdresse () {
    return adresse;
  }
  public void setAdresse () {
    this.adresse = adresse;
  }

  oublic String toString () {
    return "ID = " + id + ",Nom = " + nom + ",Adresse = "+ adresse;
  }
}
