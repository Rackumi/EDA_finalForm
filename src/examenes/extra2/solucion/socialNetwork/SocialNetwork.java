package examenes.extra2.solucion.socialNetwork;

import structures.graphs.graph.ELGraph;
import structures.graphs.graph.Graph;
import structures.graphs.Vertex;
import structures.graphs.graphAlgorithms.Recorridos;

import java.util.*;

/**
 * Stores a social network and analyses the relevance of
 * its users.
 * @author Rackumi
 */
public class SocialNetwork {

    Graph<String, Integer> redSocial;
    HashMap<String, Vertex<String>> agenda;

    public SocialNetwork() {
        redSocial = new ELGraph<>();
        agenda = new HashMap<>();
    }

    /**
     * Adds a new user to the social network
     * @param user the name of the user to be added
     */
    public void addUser(String user) {
        Vertex<String> vertice = redSocial.insertVertex(user);
        agenda.put (user, vertice);
    }

    /**
     * Sets a friendship relation between two user
     * @param user1 name of the first user
     * @param user2 name of the second user
     */
    public void makeFriends(String user1, String user2) {
        redSocial.insertEdge(agenda.get(user1), agenda.get(user2), Integer.MIN_VALUE);
    }

    /**
     * Removes all users in the social network with a number of friends
     * lower than a given number k
     * @param k value for filtering
     * @return users removed from the social network
     */
    public Iterable<String> filter(int k) {
        ArrayList<String> toReturn = new ArrayList<>();
        
        ArrayList<Vertex<String>> para_eliminar;
        boolean hemos_eliminado=true;
        do {
            para_eliminar = 
                            new ArrayList<Vertex<String>>();
            for (Vertex<String> nodo: redSocial.vertices()) {
                if (redSocial.incidentEdges(nodo).size()<k) {
                    //Tengo que eliminar ese Vertex
                    para_eliminar.add (nodo);
                }
            }

            if (para_eliminar.size()==0)
                hemos_eliminado=false;
            //Ahora me cargo a todos
            for (Vertex<String> nodo:para_eliminar) {
                redSocial.removeVertex (nodo);
                toReturn.add (nodo.getElement());
            }
        }while (hemos_eliminado);

        return toReturn;
    }

    /**
     * Evaluates how many groups there are in the social network
     * @return number of groups in the social network
     */
    public int groups() {
        ArrayList<Vertex<String>> nodos = new ArrayList<>();
        
        for (Vertex<String> nodo: redSocial.vertices()) {
            nodos.add (nodo);
        }
        
        int cont=0;
        Recorridos<String, Integer> utilidades = new Recorridos<>();
        while (!nodos.isEmpty()) {
            Vertex<String> nodo = nodos.remove(0);
            for (Vertex<String> aux: utilidades.traverse(redSocial, nodo)) {
                nodos.remove (aux);
            }
            cont++;
        }
        return cont;
    }

}