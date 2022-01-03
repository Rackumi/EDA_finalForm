package items.EjercicioBingo.bingo;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Rackumi
 */
class Card {

    private float price = 5;

    private Set<Integer> line1 = new HashSet<>(5);
    private Set<Integer> line2 = new HashSet<>(5);
    private Set<Integer> line3 = new HashSet<>(5);

    public Card(){
        while(line1.size() < 5){
            int n = ThreadLocalRandom.current().nextInt(1,91);
            while(!contains(n)){
                line1.add(n);
            }
        }
        while(line2.size() < 5){
            int n = ThreadLocalRandom.current().nextInt(1,91);
            while(!contains(n)){
                line2.add(n);
            }
        }
        while(line3.size() < 5){
            int n = ThreadLocalRandom.current().nextInt(1,91);
            while(!contains(n)){
                line3.add(n);
            }
        }
    }

    public boolean contains(int n){
        return line1.contains(n) || line2.contains(n) || line3.contains(n);
    }

    public boolean removeNumber(int n){
        return line1.remove(n) || line2.remove(n) || line3.remove(n);
    }

    public boolean lineDone(){
        return line1.isEmpty() || line2.isEmpty() || line3.isEmpty();
    }

    public boolean bingoDone(){
        return line1.isEmpty() && line2.isEmpty() && line3.isEmpty();
    }

}