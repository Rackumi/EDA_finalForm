package examenes.ordinaria_2020_2021.test;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.BinaryTreeUtils;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

import static org.junit.jupiter.api.Assertions.*;

class isBalancedTest {

    /*
            3
          /   \
         2     5
        / \
       1   4
          TRUE

            4
          /   \
         2     5
        /
       1
        \
         3
          FALSE
    */

    private BinaryTree<Integer> tree;
    private Position<Integer> p[];

    @org.junit.jupiter.api.Test
    void test1() {
        tree = new LinkedBinaryTree<>();
        BinaryTreeUtils<Integer> binaryTreeUtils = new BinaryTreeUtils<>();
        p = new Position[5];
        p[0] = tree.addRoot(3);
        p[1] = tree.insertLeft(p[0], 2);
        p[2] = tree.insertRight(p[0], 5);
        p[3] = tree.insertLeft(p[1], 1);
        p[4] = tree.insertRight(p[1], 4);
        assertTrue(binaryTreeUtils.isBalanced(tree));
    }

    @org.junit.jupiter.api.Test
    void test2() {
        tree = new LinkedBinaryTree<>();
        BinaryTreeUtils<Integer> binaryTreeUtils = new BinaryTreeUtils<>();
        p = new Position[5];
        p[0] = tree.addRoot(4);
        p[1] = tree.insertLeft(p[0], 2);
        p[2] = tree.insertRight(p[0], 5);
        p[3] = tree.insertLeft(p[1], 1);
        p[4] = tree.insertRight(p[3], 3);
        assertFalse(binaryTreeUtils.isBalanced(tree));
    }
}