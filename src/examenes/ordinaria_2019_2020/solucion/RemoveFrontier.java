package examenes.ordinaria_2019_2020.solucion;

import structures.Position;
import structures.tree.narytree.NAryTree;

import java.util.ArrayList;

public class RemoveFrontier<E> {

    //Complejidad: O(n)
    public void removeFrontier(NAryTree<E> tree) {
        //No se puede modificar el arbol en [1] mientras
        //se recorre con SU iterador. Por eso almacenamos
        //las hojas en una primera pasada y se borra en
        //una segunda pasada en [2].

        //Ademas, segun la implementacion de iterator()
        //se podrian borrar todos los nodos si se intenta
        //hacer la busqueda y eliminacion en el mismo for.
        //El iterador podria devolver primero los nodos hojas.
        //(depende de su implementacion, que podria ser cualquiera)

        ArrayList<Position<E>> frontier = new ArrayList<>();

        for (Position<E> position : tree) {
            if(tree.isLeaf(position)) //[1]
                frontier.add(position);
        }

        for (Position<E> posToRemove : frontier) { //[2]
            tree.remove(posToRemove);
        }
    }

    //Este ejercicio se puede hacer con recursividad. En dicho
    //caso tambien hay que guardar los nodos en una lista y no
    //borrarlos mientras se recorre el arbol. Esto se debe a que
    //children() devuelve un iterador y si modificamos el arbol
    //puede lanzar la excepcion ConcurrentModificationException.

    //No se admite como solucion correcta ninguna con complejidad O(n^2)

    //Uso variables globales: No se penaliza, excepto si se usan mal.
    //Llamadas consecutivas a removeFrontier no deben dejar
    //datos residuales en listas u otras variables que produzcan
    //un resultado erroneo.

    //Cualquier conversion de tipos invalida (cast) penliza gravemente.
    //Ejemplos:
    // List<E> list = (List<E>) tree.children(pos);
    // LinkedTree<E> t = (LinkedTree<E>) tree;

    //Se debe tener MUY en cuenta que NAryTree no implica ninguna implementacion
    //en particular, lo que incluye el iterador, por lo que no se garantiza
    //ningun orden de iteracion.
}
