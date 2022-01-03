package examenes.ordinaria_2019_2020.solucion;

import structures.Position;
import structures.tree.binarytree.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Half<E> {

    //Complejidad O(n)
    public Iterable<E> findHalf(BinaryTree<E> tree) {
        if (tree.isEmpty())
            return Collections.emptyList();

        int height = height(tree, tree.root());
        int midLevel = height / 2;

        List<E> list = new ArrayList<>();
        findLevel(tree, tree.root(), 1, midLevel, list);
        return list;

    }

    //Complejidad: O(n)
    private void findLevel(BinaryTree<E> tree, Position<E> pos, int level, int midLevel, List<E> output) {
        if (level == midLevel)
            output.add(pos.getElement());
        if (level < midLevel)
            for (Position<E> child : tree.children(pos))
                findLevel(tree, child, level + 1, midLevel, output);
    }

    //Complejidad: O(n)
    private int height(BinaryTree<E> tree, Position<E> node) {
        int left = 0, right = 0;
        if (tree.hasLeft(node))
            left = height(tree, tree.left(node));
        if (tree.hasRight(node))
            right = height(tree, tree.right(node));
        return 1 + Math.max(left, right);

    }

    //Tambien se puede resolver haciendo un recorrido por "niveles"
    //similar a un BFS. En dicho caso es mejor NO guardar las listas
    //de todos los niveles, basta con el nivel actual y el siguiente.

    //No se admite una solucion que sea O(n^2)

    //Uso variables globales: No se penaliza, excepto si se usan mal.
    //Llamadas consecutivas a findHalf no deben dejar
    //datos residuales en listas u otras variables que produzcan
    //un resultado erroneo.

    //Cualquier conversion de tipos invalida (cast) penliza gravemente.
    //Ejemplos:
    // List<E> list = (List<E>) tree.children(pos);
    // LinkedTree<E> t = (LinkedTree<E>) tree;
}
