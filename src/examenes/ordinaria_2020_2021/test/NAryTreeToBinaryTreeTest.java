package examenes.ordinaria_2020_2021.test;

import structures.Position;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

import static org.junit.jupiter.api.Assertions.*;

class NAryTreeToBinaryTreeTest {

    /*
                       1
                   / \  |  \
                  2   3 4   5
                 / \  |   / | \
                6   7 8   9 10 11

                      |
                      |
                      V

                    1                                 1
                   /                                 /
                  2 - 3 - 4 -5           --->       2
                 /    |     /                     /   \
                6 - 7 8    9 - 10 - 11           6     3
                                                  \   / \
                                                   7 8   4
                                                          \
                                                           5
                                                          /
                                                         9
                                                          \
                                                           10
                                                            \
                                                             11
    */
    private NAryTree<Integer> tree;
    private Position<Integer> p[];

    @org.junit.jupiter.api.Test
    void test1() {
        tree = new LinkedTree<>();
        p = new Position[11];
        p[0] = tree.addRoot(1);
        p[1] = tree.add(2, p[0]);
        p[2] = tree.add(3, p[0]);
        p[3] = tree.add(4, p[0]);
        p[4] = tree.add(5, p[0]);
        p[5] = tree.add(6, p[1]);
        p[6] = tree.add(7, p[1]);
        p[7] = tree.add(8, p[2]);
        p[8] = tree.add(9, p[4]);
        p[9] = tree.add(10, p[4]);
        p[10] = tree.add(11, p[4]);
        LinkedBinaryTree<Integer> result = (LinkedBinaryTree<Integer>) tree.convertToBinaryTree();
        String expected = "6728349101151";
        StringBuilder stb = new StringBuilder();
        for (Position<Integer> p : result) {
            stb.append(p.getElement());
        }
        assertEquals(expected, stb.toString());
    }

    @org.junit.jupiter.api.Test
    void test2() {
        tree = new LinkedTree<>();
        p = new Position[15];
        p[0] = tree.addRoot(1);
        p[1] = tree.add(2, p[0]);
        p[2] = tree.add(3, p[1]);
        p[3] = tree.add(4, p[1]);
        p[4] = tree.add(5, p[1]);
        p[5] = tree.add(6, p[0]);
        p[6] = tree.add(7, p[5]);
        p[7] = tree.add(8, p[5]);
        p[8] = tree.add(9, p[0]);
        p[9] = tree.add(10, p[8]);
        p[10] = tree.add(11, p[8]);
        p[11] = tree.add(12, p[8]);
        p[12] = tree.add(13, p[8]);
        p[13] = tree.add(14, p[11]);
        p[14] = tree.add(15, p[11]);
        LinkedBinaryTree<Integer> result = (LinkedBinaryTree<Integer>) tree.convertToBinaryTree();
        String expected = "345278610111415121391";
        StringBuilder stb = new StringBuilder();
        for (Position<Integer> p : result) {
            stb.append(p.getElement());
        }
        assertEquals(expected, stb.toString());
    }

    @org.junit.jupiter.api.Test
    void test3() {
        tree = new LinkedTree<>();
        p = new Position[11];
        p[0] = tree.addRoot(1);
        p[1] = tree.add(2, p[0]);
        p[2] = tree.add(3, p[0]);
        p[3] = tree.add(4, p[0]);
        p[4] = tree.add(5, p[0]);
        p[5] = tree.add(6, p[1]);
        p[6] = tree.add(7, p[1]);
        p[7] = tree.add(8, p[2]);
        p[8] = tree.add(9, p[4]);
        LinkedBinaryTree<Integer> result = (LinkedBinaryTree<Integer>) tree.convertToBinaryTree();
        String expected = "672834951";
        StringBuilder stb = new StringBuilder();
        for (Position<Integer> p : result) {
            stb.append(p.getElement());
        }
        assertEquals(expected, stb.toString());
    }
}