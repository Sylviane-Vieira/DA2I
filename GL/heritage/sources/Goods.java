public class Goods{
    protected int weight;
    protected int volume;

    public Goods(int weight, int volume){
	this.weight = weight;
	this.volume = volume;
    }

    public int getWeight(){
	return this.weight;
    }

    public int getVolume(){
	return this.volume;
    }

}
