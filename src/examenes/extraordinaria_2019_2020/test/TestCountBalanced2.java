package examenes.extraordinaria_2019_2020.test;

import examenes.extraordinaria_2019_2020.ejercicio1.CountBalanced;
import examenes.extraordinaria_2019_2020.ejercicio1.CountBalanced2;
import org.junit.jupiter.api.Test;
import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCountBalanced2 {

    CountBalanced2 cb = new CountBalanced2();

    @Test
    public void countBalancedEmpty() {
        BinaryTree<Integer> tree = new LinkedBinaryTree<>();
        assertEquals(0, cb.countBalanced2(tree));
    }

    @Test
    public void countBalanced1() {
        BinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> p1 = tree.addRoot(1);
        Position<Integer> p2 = tree.insertLeft(p1, 2);
        Position<Integer> p3 = tree.insertRight(p1, 3);
        assertEquals(3, cb.countBalanced2(tree));
    }

    @Test
    public void countBalanced2() {
        BinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> p1 = tree.addRoot(1);
        Position<Integer> p2 = tree.insertLeft(p1, 2);
        Position<Integer> p3 = tree.insertRight(p1, 3);
        Position<Integer> p4 = tree.insertLeft(p2, 4);
        Position<Integer> p6 = tree.insertRight(p3, 6);
        Position<Integer> p7 = tree.insertRight(p4, 7);
        Position<Integer> p8 = tree.insertRight(p6, 8);

        assertEquals(5, cb.countBalanced2(tree));
    }

}