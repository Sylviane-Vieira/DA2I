package transport;

public abstract class EncombrementPoids extends Cargaison {

   public EncombrementPoids(int d, int l) {
      super(d, l);
    }

   protected int critereEncombrement(Marchandise m) {
      return m.poids();
   }
}
