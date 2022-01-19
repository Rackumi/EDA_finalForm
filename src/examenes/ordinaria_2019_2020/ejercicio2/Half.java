package examenes.ordinaria_2019_2020.ejercicio2;

import structures.Position;
import structures.tree.binarytree.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class Half<E> {

    public class Pair<X,Y>{

        private X x;
        private Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public X getX() {
            return x;
        }

        public void setX(X x) {
            this.x = x;
        }

        public Y getY() {
            return y;
        }

        public void setY(Y y) {
            this.y = y;
        }

    }

    public Iterable<E> findHalf(BinaryTree<E> tree) {
        LinkedList<E> l = new LinkedList<>();
        int hh = getHeight(tree, tree.root())/2;

        Deque<Pair<Position<E>, Integer>> q = new LinkedList<>();
        q.addFirst(new Pair(tree.root(), 0));

        while(!q.isEmpty()){
            Pair<Position<E>, Integer> node = q.removeLast();
            for(Position<E> p : tree.children(node.getX())){
                q.addFirst(new Pair(p, node.getY()+1));
            }
            if(node.getY() == hh-1){
                l.add(node.getX().getElement());
            }
        }

        System.out.println(l);
        return l;
    }

    public int getHeight(BinaryTree<E> tree, Position<E> node){
        int left = 0;
        int right = 0;
        if(tree.hasLeft(node)){
            left = getHeight(tree, tree.left(node));
        }
        if(tree.hasRight(node)){
            right = getHeight(tree, tree.right(node));
        }
        return Math.max(left, right) + 1; //+1 por la raiz desde donde llamamos
    }

}