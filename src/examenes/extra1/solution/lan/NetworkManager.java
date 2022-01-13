package examenes.extra1.solution.lan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import structures.graphs.graph.ELGraph;
import structures.graphs.Edge;
import structures.graphs.graph.Graph;
import structures.graphs.Vertex;

/**
 *
 * @author Rackumi
 */
public class NetworkManager {
    Graph<Host,Integer> grafo = new ELGraph <>();
    HashMap<Host,Vertex<Host>> agenda = new HashMap<>();
    /**
     * Adds a terminal to the network.
     *
     * @param terminal The terminal to be added.
     * @param router The router in which the terminal is added
     * @param bps The bits per second of the connection between the router and
     * the terminal.
     */
    public void addTerminal(Terminal terminal, Router router, int bps) {
        Vertex<Host> v1 = grafo.insertVertex(terminal);
        agenda.put(terminal,v1);
        Vertex<Host> v2 = buscaVertex (router);
        grafo.insertEdge(v1, v2, bps);
        
    }

    /**
     * Adds a router to the network
     *
//     * @param router The router to be added.
//     * @param routerList The router list to which ths router is connected
//     * @param bps The bps for each router in routerList
//     */
    /*
    private Vertex<Host> buscaVertex (Host host) {
        for (Vertex<Host> v: grafo.vertices()) {
            if (v.getElement()==host)
                return v;
        }
        return null;
    }
    */
    
    private Vertex<Host> buscaVertex (Host host) {
        return agenda.get (host);
    }
    
    public void addRouter(Router router, List<Router> routerList, List<Integer> bps) {
        Vertex<Host> v1 = grafo.insertVertex(router);
        agenda.put(router,v1);
        
        if (routerList!=null) {
            for (int i=0; i<routerList.size(); i++) {
                Router destino = routerList.get(i);
                Integer velocidadEnlace = bps.get(i);
                Vertex<Host> hostDestino = buscaVertex(destino);
                grafo.insertEdge(v1, hostDestino, velocidadEnlace);
            }
        }
    }    

    /**
     * @param r
     * @return the routers connected to the router r
     */
    public List<Router> getRouters(Router r) {
        List<Router> almacenRouters= new ArrayList<Router>();
        Vertex<Host> miRouter = buscaVertex (r);
        for (Edge<Integer> arco: grafo.incidentEdges(miRouter)) {
            Vertex<Host> otro = grafo.opposite(miRouter, arco);
            Host h = otro.getElement();
            if (h instanceof Router) {
                Router aux = (Router) h;
                almacenRouters.add(aux);
            }
        }
        
                
        return almacenRouters;
    }

    /**
     * @param t
     * @return the router connected to the terminal t
     */
    public Router getRouter(Terminal t) {
        Vertex<Host> v = buscaVertex (t);
        for (Edge<Integer> arco: grafo.incidentEdges(v)) {
            return (Router) grafo.opposite(v, arco).getElement();
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
        throw new RuntimeException("Implementa este método");
    }

}