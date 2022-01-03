package structures.tree.narytree;

import java.util.*;
import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.narytree.NAryTree;

/**
 * Methods for more funcionality
 *
 * @author Rackumi
 */
public class NAryTreeUtils<E> {

    private class Pair<X,Y>{

        private X elem1;
        private Y elem2;

        public Pair(X elem1, Y elem2) {
            this.elem1 = elem1;
            this.elem2 = elem2;
        }

        public X getElem1() {
            return elem1;
        }

        public void setElem1(X elem1) {
            this.elem1 = elem1;
        }

        public Y getElem2() {
            return elem2;
        }

        public void setElem2(Y elem2) {
            this.elem2 = elem2;
        }

    }

    /**
     * This method recives a NArytree and returns a List with the elements of the
     * tree that can be seen if the tree is viewed from the left side.
     * @param tree
     * @return
     */
    public List<E> leftView(NAryTree<E> tree){
        if(tree.isEmpty()){
            return new LinkedList<>();
        }

        Deque<Pair<Position<E>, Integer>> q = new LinkedList<>();
        List<E> l = new LinkedList<>();
        boolean[] lvl = new boolean[100]; //esto estaria mal?

        Position<E> node = tree.root();
        Pair<Position<E>, Integer> nodePair = new Pair<>(node, 0);
        q.add(nodePair);

        while(!q.isEmpty()){
            nodePair = q.remove();
            for(Position<E> p: tree.children(nodePair.getElem1())){
                Pair<Position<E>, Integer> nodeAux = new Pair<>(p, nodePair.getElem2()+1);
                q.add(nodeAux);
            }
            if(!lvl[nodePair.getElem2()]) {
                l.add(nodePair.getElem1().getElement());
                lvl[nodePair.getElem2()] = true;
            }
        }
        return l;
    }

    /**
     * This method recives a NArytree and returns a List with the elements of the
     * tree that can be seen if the tree is viewed from the right side.
     * @param tree
     * @return
     */
    public List<E> rightView(NAryTree<E> tree){
        if(tree.isEmpty()){
            return new LinkedList<>();
        }

        Deque<Pair<Position<E>, Integer>> q = new LinkedList<>();
        List<E> l = new LinkedList<>();
        boolean[] lvl = new boolean[100]; //esto estaria mal?

        Position<E> node = tree.root();
        Pair<Position<E>, Integer> nodePair = new Pair<>(node, 0);
        q.add(nodePair);

        while(!q.isEmpty()){
            nodePair = q.remove();

            List<Position<E>> rev = (List<Position<E>>) tree.children(nodePair.getElem1());
            Collections.reverse(rev);
            for(Position<E> p: rev){
                Pair<Position<E>, Integer> nodeAux = new Pair<>(p, nodePair.getElem2()+1);
                q.add(nodeAux);
            }
            if(!lvl[nodePair.getElem2()]) {
                l.add(nodePair.getElem1().getElement());
                lvl[nodePair.getElem2()] = true;
            }
        }
        return l;
    }

    public int level(NAryTree<E> tree, Position<E> node){ //habria que hacer un return aux para que el +1 solo se ejecutase al final final?
        List<Integer> sib = new LinkedList<>();
        int i=0;
        for(Position<E> p: tree.children(node)){
            sib.add(i, level(tree, p));
            i++;
        }
        return Collections.max(sib)+1;
    }

}