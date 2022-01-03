package items.EjercicioBingo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Rackumi
 */
public class NumberGetter {
    public int getNumber(String message){
        int numPlayers = 0;
        try {
            System.out.print(message);
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            boolean exit = false;
            while (!exit) {
                String n = bf.readLine();
                try {
                    numPlayers = Integer.parseInt(n);
                    exit = true;
                } catch (RuntimeException ex) {
                }
            }

        } catch (IOException ex) {
            throw new RuntimeException("System problem");
        }
        return numPlayers;
    }
    
}