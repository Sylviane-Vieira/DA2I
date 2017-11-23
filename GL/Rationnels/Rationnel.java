//classe principale
public class Rationnel{
    private int n;
    private int a;
    private int b;
    
    //constructeur avec 3 arguments
    public Rationnel(int n, int a, int b){
	this.n = n;
	this.a = a;
	this.b = b;
    }
    //constructeur a 2 arguments
    public Rationnel(int a, int b){
	this.a = a;
	this.b = b;
    }
    //constructeur a 1 argument
    public Rationnel(int n){
	this.n = n;
    }

    //methode verifiant si = 0
    public boolean isNul(int n, int a, int b){
	return n == 0 || a == 0;
    }
    //methode qui renvoie inverse
    public Rationnel inverse(int n, int a, int b){
	return new Rationnel (0, b, (n*b + a));
    }
    //methode qui additionne deux rationnels entre eux
    public Rationnel ajouter(Rationnel r){
	return new Rationnel ((this.n + n), (this.a*b + a*this.b), (this.b*b)); 
    }
    //methode qui multiplie deux rationnels entre eux
    public Rationnel multiplier(Rationnel r){
	return new Rationnel((this.n*n),(this.a*a), (this.b*b)); 
    }

    //methode toString
    public String toString(){
       	if (b!=0) {	    
	    if(n == 0) {return  this.a +  "/" + this.b;}
	    else if (a%b == 0) {
		this.n = (this.n + (this.a/this.b));
		return this.n;
	    }
	}
        return this.n + "+" + this.a + "/" + this.b;
    }
}

