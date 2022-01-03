package examenes.ordinaria_2019_2020.test;

import examenes.ordinaria_2019_2020.ejercicio2.Half;
import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HalfTest {

    Half<String> live;
    BinaryTree<String> tree;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        live = new Half<>();
        tree = new LinkedBinaryTree<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void findHalfA() {
        Position<String> pos[] = new Position[10];

        pos[1] = tree.addRoot("1");
        pos[2] = tree.insertLeft(pos[1], "2");
        pos[3] = tree.insertLeft(pos[2], "3");
        pos[4] = tree.insertLeft(pos[3], "4");
        pos[5] = tree.insertRight(pos[2], "5");
        pos[6] = tree.insertRight(pos[1], "6");
        pos[7] = tree.insertRight(pos[6], "7");

        assertEquals("[2, 6]", live.findHalf(tree).toString());

    }

}