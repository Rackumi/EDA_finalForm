package examenes.extra1.source.lan;

import structures.graphs.*;
import structures.graphs.graph.ALGraph;
import structures.graphs.graphAlgorithms.Recorridos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Rackumi
 */
public class NetworkManager {

    private ALGraph<Host, Integer> g = new ALGraph<>();
    private HashMap<Host, Vertex<Host>> map = new HashMap<>();

    /**
     * Adds a terminal to the network.
     *
     * @param terminal The terminal to be added.
     * @param router The router in which the terminal is added
     * @param bps The bits per second of the connection between the router and
     * the terminal.
     */
    public void addTerminal(Terminal terminal, Router router, int bps) {
        Vertex<Host> t = g.insertVertex(terminal);
        map.put(terminal, t);
        g.insertEdge(t, map.get(router), bps);
    }

    /**
     * Adds a router to the network
     *
     * @param router The router to be added.
     * @param routerList The router list to which ths router is connected
     * @param bps The bps for each router in routerList
     */
    public void addRouter(Router router, List<Router> routerList, List<Integer> bps) {
        Vertex<Host> r = g.insertVertex(router);
        map.put(router, r);
        int cont = 0;
        if(routerList != null && !routerList.isEmpty()){
            for (Host p : routerList) {
                g.insertEdge(r, map.get(p), bps.get(cont));
                cont++;
            }
        }
    }

    /**
     * @param r
     * @return the routers connected to the router r
     */
    public List<Router> getRouters(Router r) {
        List<Router> l = new LinkedList<>();
        for(Edge<Integer> p: g.incidentEdges(map.get(r))){
            Vertex<Host> vh = g.opposite(map.get(r), p);
            Host h = vh.getElement();
            if(h instanceof Router){
                Router router = (Router)h;
                l.add(router);
            }
        }

        return l;
    }

    /**
     * @param t
     * @return the router connected to the terminal t
     */
    public Router getRouter(Terminal t) {
        Vertex<Host> vh = map.get(t);
        for(Edge<Integer> e: g.incidentEdges(vh)){
            Host h = g.opposite(vh, e).getElement();
            return (Router)h;
        }

        return null;
    }

    /**
     *
     * @param t1
     * @param t2
     * @return Return the number of jumps between t1 and t2
     */
    public int findHops(Terminal t1, Terminal t2) {
        Recorridos<Host, Integer> recorridos = new Recorridos<>();
        return recorridos.getPath(g, map.get(t1), map.get(t2)).size();
    }

}