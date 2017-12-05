package transport;

import java.util.*;

public abstract class Cargaison {

   protected int distance;
   protected List<Marchandise> lesMarchandises;
   protected int encombrementCourant;
   protected int encombrementLimite;

   public Cargaison(int d, int l) {
      this.distance = d;
      this.encombrementLimite = l;
      this.encombrementCourant = 0;
      this.lesMarchandises = new ArrayList<Marchandise>();
   }

   public void add(Marchandise m) throws EncombrementLimiteAtteintException {
      if (this.encombrementCourant + critereEncombrement(m) <= this.encombrementLimite) {
         this.lesMarchandises.add(m);
         this.encombrementCourant += critereEncombrement(m);
      } else {
         throw new EncombrementLimiteAtteintException();
      }
   }

   protected abstract int critereEncombrement(Marchandise m);

   public abstract int cout();

   public int encombrement() {
      return this.encombrementCourant;
   }
}

