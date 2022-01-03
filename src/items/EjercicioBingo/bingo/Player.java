package items.EjercicioBingo.bingo;

import items.EjercicioBingo.utils.NumberGetter;

import java.util.*;

/**
 *
 * @author Rackumi
 */
class Player {

    private float money = 5;
    private Card [] cards;

    public Player() {
        NumberGetter n = new NumberGetter();
        int numCards = n.getNumber("Number of cards:");
        cards = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            cards[i] = new Card();
            
        }
    }

    public float getMoney(){
        return this.money;
    }

    void removeNumber(int number) {
        for(int i=0; i<cards.length; i++){
            cards[i].removeNumber(number);
        }
    }

    boolean hasLine() {
        for(int i=0; i<cards.length; i++){
            if(cards[i].lineDone()){
                return true;
            }
        }
        return false;
    }

    boolean hasBingo() {
        for(int i=0; i<cards.length; i++){
            if(cards[i].bingoDone()){
                return true;
            }
        }
        return false;
    }
    
}