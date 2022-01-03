package items.EjercicioBingo.bingo;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Rackumi
 */
class Hype {

    Set<Integer> bombo = new HashSet<>(90);

    public Hype() {
        for(int i=0; i<=90; i++){
            this.bombo.add(i);
        }
    }

    boolean hasNumbers() {
        return !bombo.isEmpty();
    }

    int getNumber() {
        int aux = ThreadLocalRandom.current().nextInt(1,91);
        while(!bombo.contains(aux)){ //esto seria o(n)? por lo que seria mejor un array de booleanos?
            aux = ThreadLocalRandom.current().nextInt(1, 91);
        }
        bombo.remove(aux);
        return aux;
    }
    
}
