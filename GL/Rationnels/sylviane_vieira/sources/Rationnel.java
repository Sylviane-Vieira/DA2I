//Sylviane Vieira
//DA2I

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
    //getteurs et setteurs
    public void setN(int n){
	this.n=n;
    }
    public String getN(){
	if (n == 0){return String.valueOf(0);}
        else if (a > b) {
	    this.n += (a / b);
	}
	return String.valueOf(this.n);
    }
    public int getA(){
	if (a < 0) {return (-this.a);}
	return this.a;
    }
    public void setA(int a){
	this.a=a;
    }
    public int getB(){
	if (b < 0) {return (-this.b);}
	return this.b;
    }
    public void setB(int b){
	this.b=b;
    }

    //methode qui recupere la partie entière de la fraction avec 3 valeurs
    public String partieEntiere() {
	if (a > b) {
	    this.n += (a / b);
	}
	return String.valueOf(this.n);
    }
    //methode qui recupere la partie entière de la fraction avec 2 valeurs
    public Rationnel addN() {
	return new Rationnel(Integer.parseInt(partieEntiere()),a,b);
    }

    //methode verifiant si = 0
    public boolean isNul(){
	return this.n == 0 || this.a == 0;
    }
    //methode qui renvoie inverse
    public Rationnel inverse(){
	return new Rationnel (0, this.b, (this.n*this.b + this.a));
    }
    //methode qui additionne deux rationnels entre eux
    public Rationnel ajouter(Rationnel r){
	return new Rationnel ((this.n + n), (this.a*b + a*this.b), (this.b*b));
    }
    //methode qui multiplie deux rationnels entre eux
    public Rationnel multiplier(Rationnel r){
	return new Rationnel((this.n*n),(this.a*a), (this.b*b));
    }
     //methode qui divise a/b et renvoie un float
    public float division() {
	float result = (a / b);
	if ((a / b) > 1) {return (float) result;}
	return result;
    }

    //methode toString
    public String toString(){
	if (b == 0 || a == 0 || (a%b) == 0) {
	    return getN();
	}
        else if (a > b && n != 0){
	    return partieEntiere();
	}
	else  if (a < 0 || b < 0) {
	    return this.getN() + "-" + this.getA() + "/" + this.getB();
	}
        else 
	    return this.getN() + "+" + this.getA() + "/" + this.getB();
    }
}
