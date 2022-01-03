package structures.tree.narytree;

import java.util.*;

import structures.Position;
import structures.tree.Tree;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.iterators.BFSIterator;
import structures.tree.iterators.PreOrderIterator;

/**
 * Implementation for LinkedTree
 *
 * @author Rackumi
 */
public class LinkedTree<E> implements NAryTree<E> {

    private class TreeNode<T> implements Position<T>{

        private T element;
        private List<TreeNode<T>> children;
        private TreeNode<T> parent;

        private TreeNode<T> rightSibling; // A reference to the right sibling. Examen ordinaria_2020_2021

        public TreeNode(TreeNode<T> parent, T element){
            this.element = element;
            this.parent = parent;
            this.children = new LinkedList<>();
        }

        @Override
        public T getElement() {
            return this.element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public List<TreeNode<T>> getChildren() {
            return this.children;
        }

        public void setChildren(List<TreeNode<T>> children) {
            this.children = children;
        }

        public TreeNode<T> getParent() {
            return this.parent;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }

        public TreeNode<T> getRightSibling() {
            return rightSibling;
        }

        public void setRightSibling(TreeNode<T> rightSibling) {
            this.rightSibling = rightSibling;
        }

        public void removeChildren(TreeNode<T> node){
            this.children.remove(node);
        }

    }

    private TreeNode<E> root;
    private int size;

    public LinkedTree(){
        this.root = null;
        this.size = 0;
    }

    public LinkedTree(TreeNode<E> node){
        this.root = node;
        this.size = 1;
    }

    @Override
    public Position<E> addRoot(E e) {
        if(isEmpty()){
            this.root = new TreeNode<>(null, e);
        }
        else{
            throw new RuntimeException("Tree already has a root");
        }
        size++;
        return this.root;
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        TreeNode<E> hijo = new TreeNode<>(node, element);
        node.getChildren().add(hijo);
        size++;
        return hijo;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        TreeNode<E> node = checkPosition(p);
        TreeNode<E> hijo = new TreeNode<>(node, element);
        node.getChildren().add(n, hijo);
        size++;
        return hijo;
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        TreeNode<E> node1 = checkPosition(p1);
        TreeNode<E> node2 = checkPosition(p2);
        E aux = p1.getElement();
        node1.setElement(p2.getElement());
        node2.setElement(aux);
    }

    @Override
    public E replace(Position<E> p, E e) {
        TreeNode<E> n = checkPosition(p);
        E aux = n.getElement();
        n.setElement(e);
        return aux;
    }

    @Override
    public void remove(Position<E> p) {
        TreeNode<E> node = checkPosition(p);

        if(!isRoot(node)) {

            int cont=0;
            Iterator<Position<E>> it = new BFSIterator<E>(this, node);
            while(it.hasNext()){
                cont++;
                it.next();
            }

            TreeNode<E> parent = node.getParent();
            parent.getChildren().remove(node);
            this.size = this.size - cont;
        }
        else{
            this.size=0;
            this.root = null;
        }
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        TreeNode<E> node = checkPosition(v);
//        TreeNode<E> parent = node.getParent(); //se puede usar el remove de la lista o el remove del arbol? valen los dos
//        parent.getChildren().remove(node);
        this.remove(node);
        return new LinkedTree<>(node);
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        TreeNode<E> nodeBase = checkPosition(p);
        TreeNode<E> rootNewTree = checkPosition(t.root());

        int cont = 0;
        Iterator<Position<E>> it = new BFSIterator<>(t, rootNewTree);
        while(it.hasNext()){
            cont++;
            it.next();
        }

        rootNewTree.setParent(nodeBase);
        nodeBase.getChildren().add(rootNewTree);
        this.size = this.size + cont;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Position<E> root() {
        if(!isEmpty()){
            return this.root;
        }
        else{
            throw new RuntimeException("The tree is empty");
        }
    }

    @Override
    public Position<E> parent(Position<E> v) {
        TreeNode<E> n = checkPosition(v);
        if(isRoot(n)){
            throw new RuntimeException("The node has not parent");
        }
        return n.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        TreeNode<E> n = checkPosition(v);
        return n.getChildren();
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        TreeNode<E> n = checkPosition(v);
        return n.getChildren().isEmpty();
    }

    @Override
    public boolean isRoot(Position<E> v) {
        TreeNode<E> n = checkPosition(v);
        return n == this.root;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        if(isEmpty()){
           throw new RuntimeException("The tree is empty");
        }
        return new BFSIterator<>(this, this.root);
    }
 
    public int size(){
        return this.size;
    }

    private TreeNode<E> checkPosition(Position<E> p){
        if(!(p instanceof TreeNode)){ //p==null no haria falta xq ya se comprueba en el instanceof
            throw new RuntimeException("The position is invalid");
        }
        return (TreeNode<E>) p;
    }

    //Extra methods

    public void moveSubtree(Position<E> pOrig, Position<E> pDest) throws RuntimeException {
        TreeNode<E> nodeOrig = checkPosition(pOrig);
        TreeNode<E> nodeDest = checkPosition(pDest);

        if(nodeOrig == this.root){
            throw new RuntimeException("Root node can't be moved");
        }
        else if(nodeDest == nodeOrig){
            throw new RuntimeException("Both positions are the same");
        }
        Iterator<Position<E>> it = new BFSIterator<>(this, nodeOrig);
        while(it.hasNext()){
            if(nodeDest == it.next()){
                throw new RuntimeException("Target position can't be a sub tree of origin");
            }
        }

        TreeNode<E> origPadre = nodeOrig.parent;
        nodeOrig.setParent(nodeDest);
        nodeDest.getChildren().add(nodeOrig);
        origPadre.children.remove(nodeOrig);
    }

    public BinaryTree<E> convertToBinaryTree() {
        reorderTree();
        return transformToBinary();
    }

    private BinaryTree<E> transformToBinary() {
        BinaryTree<E> res = new LinkedBinaryTree<>();
        res.addRoot(this.root().getElement());
        Queue<Position<E>> queue = new ArrayDeque<>();
        Queue<Position<E>> queueBinTree = new ArrayDeque<>();
        queue.add(this.root());
        queueBinTree.add(res.root());
        while (!queue.isEmpty()){
            Position<E> actNode = queue.poll();
            Position<E> actBinNode = queueBinTree.poll();
            List<Position<E>> childrenList = new ArrayList<>(checkPosition(actNode).children);
            Position<E> children = null;
            if (!childrenList.isEmpty()){
                children = childrenList.get(0);
            }
            Position<E> sibling = sibling(actNode);
            if(children != null){
                queue.add(children);
                res.insertLeft(actBinNode, children.getElement());
                queueBinTree.add(res.left(actBinNode));
            }
            if(sibling != null){
                queue.add(sibling);
                res.insertRight(actBinNode, sibling.getElement());
                queueBinTree.add(res.right(actBinNode));
            }
        }
        return res;
    }

    private void reorderTree() {
        Queue<Position<E>> queue = new ArrayDeque<>();
        queue.add(this.root());

        while(!queue.isEmpty()){
            Position<E> actNode = queue.poll();
            List<Position<E>> children = new ArrayList<>(checkPosition(actNode).children);

            for (int i = 0; i < children.size(); i++) {
                if(i!=0){
                    removeParentEdge(children.get(i));
                }
                if(i != children.size()-1){
                    addSibling(children.get(i), children.get(i+1));
                    queue.add(children.get(i));
                    queue.add(children.get(i+1));
                }else{
                    queue.add(children.get(i));
                }
            }
        }

    }

    //Añadido examen EDA FEBRERO 2021 Sergio
    public void removeParentEdge(Position<E> e) {
        TreeNode<E> node = checkPosition(e);
        TreeNode<E> parent = checkPosition(this.parent(e));
        node.setParent(null);
        parent.removeChildren(node);
    }

    //Añadido examen EDA FEBRERO 2021 Sergio
    public void addSibling(Position<E> e, Position<E> e1) {
        TreeNode<E> node1 = checkPosition(e);
        TreeNode<E> node2 = checkPosition(e1);
        node1.setRightSibling(node2);
    }

    public Position<E> sibling(Position<E> actNode) {
        TreeNode<E> node = checkPosition(actNode);
        return node.getRightSibling();
    }

    //Extra

    //Funcion para comprobar si un position contiene a otro
    private boolean contiene (Position<E> pO, Position<E> pD){
        TreeNode<E> nodeO = checkPosition(pO);
        TreeNode<E> nodeD = checkPosition(pD);
        Iterator<Position<E>> it = new PreOrderIterator<>(this, nodeO);
        while(it.hasNext()){
            TreeNode<E> nodeAux = (TreeNode<E>)it.next();
            if (nodeAux==nodeD){
                return true;
            }
        }
        return false;
    }

    private boolean igualesAux (LinkedTree<E> a1, Position<E> a1_p,
                                LinkedTree<E> a2, Position<E> a2_p) {
        if (!a1_p.getElement().equals(a2_p.getElement())) {
            return false;
        }
        List <TreeNode<E>> it1 = a1.checkPosition(a1_p).getChildren();
        List <TreeNode<E>> it2 = a2.checkPosition(a2_p).getChildren();

        if ((it1.size()!=it2.size()) || (!it2.containsAll(it1)))
            return false;

        for (TreeNode<E> n1: it1) {
            int posicion = it2.indexOf(n1);
            TreeNode<E> n2 = it2.get(posicion);
            boolean igual = igualesAux (a1,n1, a2, n2);
            if (!igual)
                return igual;

        }
        return true;
    }

    public boolean iguales (LinkedTree<E> otro) {
        if (this.isEmpty()) {
            return otro.isEmpty();
        }else {
            if (otro.isEmpty())
                return false;
            else { //Tienen los dos
                if (size()!=otro.size())
                    return false;
                else {
                    return igualesAux (this, this.root(),otro, otro.root());
                }
            }
        }
    }

    public Tree<E> copy (){
        LinkedTree<E> nuevo = new LinkedTree<E> ();
        if (!this.isEmpty()) {
            Position<E> raiz_nuevo = nuevo.addRoot(this.root.getElement());
            CopiarArbol (this, this.root(), nuevo, raiz_nuevo);
        }

        return nuevo;
    }

    private void CopiarArbol (LinkedTree<E> origen, Position<E> p_origen, LinkedTree<E> destino, Position<E> p_destino) {
        Iterable<Position <E>> it = (Iterable<Position<E>>) origen.children(p_origen);

        for (Position<E> p: it) {
            Position<E> p_aux = destino.add(p.getElement(), p_destino);
            CopiarArbol (origen, p, destino, p_aux);
        }
    }

    public LinkedTree<E> subarbol (Position<E> pos) {
        checkPosition (pos);

        LinkedTree<E> nuevo = new LinkedTree<E> ();
        Position<E> p_nuevo = nuevo.addRoot(pos.getElement());
        CopiarArbol (this,pos, nuevo, p_nuevo);

        return nuevo;
    }

}