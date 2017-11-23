public class CoupleObj<K,V> implements Couple<K,V> {
    K cle;
    V valeur;

    public CoupleObj(K cle,V valeur) {
	this.cle = cle;
	this.valeur = valeur;
    }
    public K premier(){
	return this.cle;
    }
    public V second(){
	return this.valeur;
    }
    public void defPremier(K k){
	this.cle = k;
    }
    public void defSecond(V v){
	this.valeur = v;
    }
    public boolean equals(CoupleObj couple){
	return couple.cle == this.cle && couple.valeur == this.valeur;	
    }
    
	
} 
