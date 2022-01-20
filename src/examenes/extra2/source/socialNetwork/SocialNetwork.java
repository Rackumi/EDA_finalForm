package examenes.extra2.source.socialNetwork;

import structures.graphs.Vertex;
import structures.graphs.graph.*;
import structures.graphs.graphAlgorithms.Recorridos;

import java.util.*;

/**
 * Stores a social network and analyses the relevance of
 * its users.
 *
 * @author Rackumi
 */
public class SocialNetwork {

    Graph<String, Integer> g;
    Map<String, Vertex<String>> map;

    public SocialNetwork() {
        g = new ALGraph<>();
        map = new HashMap<>();
    }

    /**
     * Adds a new user to the social network
     * @param user the name of the user to be added
     */
    public void addUser(String user) {
		Vertex<String> v = g.insertVertex(user);
        map.put(user, v);
    }

    /**
     * Sets a friendship relation between two user
     * @param user1 name of the first user
     * @param user2 name of the second user
     */
    public void makeFriends(String user1, String user2) {
		g.insertEdge(map.get(user1), map.get(user2), 0);
    }

    /**
     * Removes all users in the social network with a number of friends
     * lower than a given number k
     * @param k value for filtering
     * @return users removed from the social network
     */
    public Iterable<String> filter(int k) {
        List<String> l = new LinkedList<>();
        List<Vertex<String>> delete = new LinkedList<>();
        int size;
        do {
            size = map.size();
            for (Vertex<String> v : g.vertices()) {
                if (g.incidentEdges(v).size() < k) {
                    delete.add(v);
                    l.add(v.getElement());
                }
            }
            for(Vertex<String> p: delete){ //no se puede borrar mientras lo recorrer
                map.remove(p.getElement());
                g.removeVertex(p);
            }
        }while(size != map.size());
        return l;
    }

    /**
     * Evaluates how many groups there are in the social network
     * @return number of groups in the social network
     */
    public int groups() { //este mas bien te dice si es conexo o no
        Recorridos<String, Integer> recorridos = new Recorridos<>();
        Set<Vertex<String>> rec = recorridos.traverse(g, g.vertices().iterator().next());
        int cont = 1;
        if(rec.size() == g.vertices().size()){
            return cont;
        }
        else{
            cont++;
        }
        return cont;
    }

    public int groups2() {
        List<Vertex<String>> nodos = new LinkedList<>(g.vertices());
        int cont=0;

        Recorridos<String, Integer> rec = new Recorridos<>();
        while (!nodos.isEmpty()) {
            Vertex<String> nodo = nodos.remove(0);
            for (Vertex<String> aux: rec.traverse(g, nodo)) {
                nodos.remove(aux);
            }
            cont++;
        }
        return cont;
    }

}