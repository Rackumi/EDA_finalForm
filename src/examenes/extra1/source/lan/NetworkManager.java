package examenes.extra1.source.lan;

import java.util.List;

/**
 *
 * @author Rackumi
 */
public class NetworkManager {

    /**
     * Adds a terminal to the network.
     *
     * @param terminal The terminal to be added.
     * @param router The router in which the terminal is added
     * @param bps The bits per second of the connection between the router and
     * the terminal.
     */
    public void addTerminal(Terminal terminal, Router router, int bps) {
        throw new RuntimeException("Implementa este método");
    }

    /**
     * Adds a router to the network
     *
     * @param router The router to be added.
     * @param routerList The router list to which ths router is connected
     * @param bps The bps for each router in routerList
     */
    public void addRouter(Router router, List<Router> routerList, List<Integer> bps) {
        throw new RuntimeException("Implementa este método");    }    

    /**
     * @param r
     * @return the routers connected to the router r
     */
    public List<Router> getRouters(Router r) {
        throw new RuntimeException("Implementa este método");
    }

    /**
     * @param t
     * @return the router connected to the terminal t
     */
    public Router getRouter(Terminal t) {
        throw new RuntimeException("Implementa este método");
    }

    /**
     *
     * @param t1
     * @param t2
     * @return Return the number of jumps between t1 and t2
     */
    public int findHops(Terminal t1, Terminal t2) {
        throw new RuntimeException("Implementa este método");
    }

}