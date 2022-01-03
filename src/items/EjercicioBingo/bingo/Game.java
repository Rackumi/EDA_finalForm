package items.EjercicioBingo.bingo;

import items.EjercicioBingo.utils.NumberGetter;

/**
 *
 * @author Rackumi
 */
class Game {

    private final Hype hype;
    private Player[] players;
    private float prize = 0;

    public Game() {
        hype = new Hype();
        prize = createPlayers();
    }

    public void play() {
        boolean lineDetected = false;
        boolean bingo = false;
        while (hype.hasNumbers() && !bingo) {
            int number = hype.getNumber();
            for (int i = 0; i < players.length; i++) {
                players[i].removeNumber(number);
                if (!lineDetected) {
                    if (players[i].hasLine()) {
                        System.out.println("Line detected, player " + i + " has line");
                        lineDetected = true;
                    }
                }
                if (players[i].hasBingo()) {
                    System.out.println("Bingo detected, player " + i + " has bingo");
                    System.out.println(prize/2 + " is the prize for player " + i);
                    bingo = true;
                    break;
                }

            }
        }

    }

    private float createPlayers() {
        NumberGetter n = new NumberGetter();
        int prize = 0;
        final int numPlayers = n.getNumber("Number of players:");
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
            prize += players[i].getMoney();
        }
        return prize;
    }


}