package structures.tree.binarySearchTree;

import structures.Position;
import structures.tree.binarytree.LinkedBinaryTree;

/**
 * LinkedBinarySearchTree that implements the tri-node restructuration
 *
 * @author Rackumi
 */
      
class Reestructurator<T> {
    /**
     * Performs a tri-node restructuring. Assumes the nodes are in one of
     * following configurations:
     *
     * <pre>
     *          z=c       z=c        z=a         z=a
     *         /  \      /  \       /  \        /  \
     *       y=b  t4   y=a  t4    t1  y=c     t1  y=b
     *      /  \      /  \           /  \         /  \
     *    x=a  t3    t1 x=b        x=b  t4       t2 x=c
     *   /  \          /  \       /  \             /  \
     *  t1  t2        t2  t3     t2  t3           t3  t4
     * </pre>
     *
     * @return the new root of the restructured subtree
     */

//    public Position restructure(Position posNode, LinkedBinaryTree binTree){
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public Position restructure(Position posNode, LinkedBinaryTree binTree) {
        LinkedBinaryTree lowKey, midKey, highKey, t1, t2, t3, t4;

        final Position posParent = binTree.parent(posNode); // assumes x has a parent
        final Position posGrandParent = binTree.parent(posParent); // assumes y has a parent

        final Position zParent = binTree.isRoot(posGrandParent) ? null : binTree.parent(posGrandParent);
        final boolean leftCase = zParent == null ? false : posGrandParent == binTree.left(zParent);

        final boolean nodeLeft = (binTree.hasLeft(posParent) && (posNode == binTree.left(posParent)));
        final boolean parentLeft = (binTree.hasLeft(posGrandParent) && (posParent == binTree.left(posGrandParent)));

        if (nodeLeft && parentLeft) {// Desequilibrio izda-izda
            lowKey = binTree.subTree(posNode);
            midKey = binTree.subTree(posParent);
            highKey = binTree.subTree(posGrandParent);
            t1 = (lowKey.hasLeft(lowKey.root())) ? lowKey.subTree(lowKey.left(lowKey.root())) : null;
            t2 = (lowKey.hasRight(lowKey.root())) ? lowKey.subTree(lowKey.right(lowKey.root())) : null;

            t3 = (midKey.hasRight(midKey.root())) ? midKey.subTree(midKey.right(midKey.root())) : null;
            t4 = (highKey.hasRight(highKey.root())) ? highKey.subTree(highKey.right(highKey.root())) : null;
        } else if (!nodeLeft && parentLeft) {// Desequilibrio izda-dcha
            midKey = binTree.subTree(posNode);
            lowKey = binTree.subTree(posParent);
            highKey = binTree.subTree(posGrandParent);
            t1 = (lowKey.hasLeft(lowKey.root())) ? lowKey.subTree(lowKey.left(lowKey.root())) : null;
            t2 = (midKey.hasLeft(midKey.root())) ? midKey.subTree(midKey.left(midKey.root())) : null;

            t3 = (midKey.hasRight(midKey.root())) ? midKey.subTree(midKey.right(midKey.root())) : null;
            t4 = (highKey.hasRight(highKey.root())) ? highKey.subTree(highKey.right(highKey.root())) : null;
        } else if (nodeLeft && !parentLeft) {// Desequilibrio dcha-izda
            midKey = binTree.subTree(posNode);
            highKey = binTree.subTree(posParent);
            lowKey = binTree.subTree(posGrandParent);
            t1 = (lowKey.hasLeft(lowKey.root())) ? lowKey.subTree(lowKey.left(lowKey.root())) : null;
            t2 = (midKey.hasLeft(midKey.root())) ? midKey.subTree(midKey.left(midKey.root())) : null;

            t3 = (midKey.hasRight(midKey.root())) ? midKey.subTree(midKey.right(midKey.root())) : null;
            t4 = (highKey.hasRight(highKey.root())) ? highKey.subTree(highKey.right(highKey.root())) : null;
        } else { // Desequilibrio dcha-dcha
            highKey = binTree.subTree(posNode);
            midKey = binTree.subTree(posParent);
            lowKey = binTree.subTree(posGrandParent);
            t1 = (lowKey.hasLeft(lowKey.root())) ? lowKey.subTree(lowKey.left(lowKey.root())) : null;
            t2 = (midKey.hasLeft(midKey.root())) ? midKey.subTree(midKey.left(midKey.root())) : null;

            t3 = (highKey.hasLeft(highKey.root())) ? highKey.subTree(highKey.left(highKey.root())) : null;
            t4 = (highKey.hasRight(highKey.root())) ? highKey.subTree(highKey.right(highKey.root())) : null;
        }

        // place the rest of the nodes and their children
        lowKey.attachLeft(lowKey.root(), t1);
        lowKey.attachRight(lowKey.root(), t2);
        highKey.attachLeft(highKey.root(), t3);
        highKey.attachRight(highKey.root(), t4);

        midKey.attachLeft(midKey.root(),lowKey);
        midKey.attachRight(midKey.root(), highKey);

        Position output = midKey.root();

        //If zparent is root binTree isEmpty and it must be replaced by midkey
        //If zparent not is null you must attach midkey in the corresponding position of zparent
        if (zParent == null) {
//            binTree.attach(midKey);
        } else {
            if (leftCase) {
                binTree.attachLeft(zParent,midKey);
            } else {
                binTree.attachRight(zParent,midKey);
            }
        }

        return output;
    }

//    public Position<T> restructure(Position<T> posNode, LinkedBinarySearchTree<T> bst) {
//        BTNode<T> lowKey, midKey, highKey, t1, t2, t3, t4;
//        Position<T> posParent = bst.binTree.parent(posNode); // assumes x has a parent
//        Position<T> posGrandParent = bst.binTree.parent(posParent); // assumes y has a parent
//        boolean nodeLeft = (posNode == bst.binTree.left(posParent));
//        boolean parentLeft = (posParent == bst.binTree.left(posGrandParent));
//        BTNode<T> node = (BTNode<T>) posNode, parent = (BTNode<T>) posParent, grandParent = (BTNode<T>) posGrandParent;
//        if (nodeLeft && parentLeft) {// Desequilibrio izda-izda
//            lowKey = node;
//            midKey = parent;
//            highKey = grandParent;
//            t1 = lowKey.getLeft();
//            t2 = lowKey.getRight();
//            t3 = midKey.getRight();
//            t4 = highKey.getRight();
//        } else if (!nodeLeft && parentLeft) {// Desequilibrio izda-dcha
//            lowKey = parent;
//            midKey = node;
//            highKey = grandParent;
//            t1 = lowKey.getLeft();
//            t2 = midKey.getLeft();
//            t3 = midKey.getRight();
//            t4 = highKey.getRight();
//        } else if (nodeLeft && !parentLeft) {// Desequilibrio dcha-izda
//            lowKey = grandParent;
//            midKey = node;
//            highKey = parent;
//            t1 = lowKey.getLeft();
//            t2 = midKey.getLeft();
//            t3 = midKey.getRight();
//            t4 = highKey.getRight();
//        } else { // Desequilibrio dcha-dcha
//            lowKey = grandParent;
//            midKey = parent;
//            highKey = node;
//            t1 = lowKey.getLeft();
//            t2 = midKey.getLeft();
//            t3 = highKey.getLeft();
//            t4 = highKey.getRight();
//        }
//
//        // put b at z's place
//        if (bst.binTree.isRoot(posGrandParent)) {
//            bst.binTree = (LinkedBinaryTree<T>) bst.binTree.subTree(midKey);//FIXED: bad practice...
//        } else {
//            BTNode<T> zParent = (BTNode<T>) bst.binTree.parent(posGrandParent);
//            if (posGrandParent == bst.binTree.left(zParent)) {
//                midKey.setParent(zParent);
//                zParent.setLeft(midKey);
//            } else { // z was a right child
//                midKey.setParent(zParent);
//                zParent.setRight(midKey);
//            }
//        }
//        // place the rest of the nodes and their children
//        midKey.setLeft(lowKey);
//        lowKey.setParent(midKey);
//        midKey.setRight(highKey);
//        highKey.setParent(midKey);
//        lowKey.setLeft(t1);
//        t1.setParent(lowKey);
//        lowKey.setRight(t2);
//        t2.setParent(lowKey);
//        highKey.setLeft(t3);
//        t3.setParent(highKey);
//        highKey.setRight(t4);
//        t4.setParent(highKey);
//
//        return midKey; // the new root of this subtree
//    }

//    public Position restructure(Position posNode, LinkedBinaryTree binTree){
//        Position x = posNode; //nodo de abajo
//        Position y = binTree.parent(x); // su padre
//        Position z = binTree.parent(y); //el abuelo de x que es el padre de y
//
//        boolean leftChild = (binTree.hasLeft(y) && binTree.left(y) == x);
//        boolean leftParent = (binTree.hasLeft(z) && binTree.left(z) == y);
//
//        Position a,b,c;
//        LinkedBinaryTree t1, t2, t3, t4;
//
//        if(leftChild && leftParent){
//            //izq-izq
//            a = binTree.subtree(x);
//            b = binTree.subtree(y);
//            c = binTree.subtree(z);
//            if binTree.hasLeft(a){
//                Position aux = binTre.left(a);
//                t1 = binTre.subTree(aux);
//            }
//        else{
//                t1 = null;
//            }
//            //t1 = (!binTree.hasLeft(a.root()))?null:binTree.subTree(binTree.left(a.root()));
//            //t1 = (binTree.hasLeft(a.root()))?binTree.subtree(binTree.left(a.root())):null;
//            t2 = (!binTree.hasRight(a.root()))?null:binTree.subTree(binTree.right(a.root()));
//            t3 = (!binTree.hasRight(b.root()))?null:binTree.subTree(binTree.right(b.root()));
//            t4 = (!binTree.hasRight(c.root()))?null:binTree.subTree(binTree.right(c.root()));
//        }
//        else if(!leftChild && leftParent){
//            //izq-der
//        }
//        else if(leftChild && !leftParent){
//            //der-izq
//        }
//        else{
//            //der-der
//        }
//
//        binTree.attachLeft(a.root(), t1);
//        binTree.attachRight(a.root(), t2);
//        binTree.attachLeft(c.root(), t3);
//        binTree.attachRight(c.root(), t4);
//        binTree.attachLeft(b.root(), a);
//        binTree.attachRight(b.root(), c);
//
//        if(zParent != null){
//            if(leftZ){
//                binTree.attachLeft(zParent, b);
//            }
//            else{
//                binTree.attachRight(zParent, b);
//            }
//        }
//        else{
//            binTree.attach(b);
//        }
//
//        return b.root();
//    }

}