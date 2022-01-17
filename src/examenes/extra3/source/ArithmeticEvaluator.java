package examenes.extra3.source;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;

/**
 * Evaluador de expresiones artiméticas desde cadenas.
 *
 * @author Rackumi
 */
public class ArithmeticEvaluator {

    LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

    /**
     * Construye el árbol usando una expresión artimética.
     * @param expresion Expresión aritmética con la que construir el árbol binario.
     */
    public ArithmeticEvaluator(String expresion) {
        int posSuma = expresion.lastIndexOf("+");
        int posResta = expresion.lastIndexOf("-");
        int posDivision = expresion.lastIndexOf("/");

        int pos = Integer.max(posSuma, posResta);
        if (pos==-1) { //No tengo ni suma ni resta
            if (posDivision==-1) { // NO tengo tampoco la /
                tree.addRoot(expresion);
            }
            else {
                Position<String> p = tree.addRoot("/");
                String cadenaIzquierda = expresion.substring(0, posDivision);
                String cadenaDerecha = expresion.substring(posDivision+1);
                RecursivoIzquierda (tree,p,cadenaIzquierda);
                RecursivoDerecha (tree, p, cadenaDerecha);
            }
        }
        else {
            Position<String> p = tree.addRoot(expresion.substring(pos,pos+1));
            String cadenaIzquierda = expresion.substring(0, pos);
            String cadenaDerecha = expresion.substring(pos+1);
            RecursivoIzquierda (tree,p,cadenaIzquierda);
            RecursivoDerecha (tree, p, cadenaDerecha);
        }
    }

    /**
     * @return La propiedad de tipo árbol contenida en el objeto.
     */
    public BinaryTree <String> getTree() {
        return tree;
    }

    /**
     * Evalua el árbol.
     * @return El resultado de evaluar el árbol.
     */
    public int evaluate() {
        if (tree.isEmpty())
            return 0;
        else {
            return evaluate (tree.root());
        }
    }

    private void RecursivoIzquierda(BinaryTree<String> tree, Position<String> padre, String expresion) {
        int posSuma = expresion.lastIndexOf("+");
        int posResta = expresion.lastIndexOf("-");
        int posDivision = expresion.lastIndexOf("/");

        int pos = Integer.max(posSuma, posResta);
        if (pos==-1) { //No tengo ni suma ni resta
            if (posDivision==-1) { // NO tengo tampoco la /
                tree.insertLeft(padre, expresion);
            }else {
                Position<String> p = tree.insertLeft(padre, "/");
                String cadenaIzquierda = expresion.substring(0, posDivision);
                String cadenaDerecha = expresion.substring(posDivision+1);
                RecursivoIzquierda (tree,p,cadenaIzquierda);
                RecursivoDerecha (tree, p, cadenaDerecha);
            }
        }else {
            Position<String> p = tree.insertLeft(padre, expresion.substring(pos,pos+1));
            String cadenaIzquierda = expresion.substring(0, pos);
            String cadenaDerecha = expresion.substring(pos+1);
            RecursivoIzquierda (tree,p,cadenaIzquierda);
            RecursivoDerecha (tree, p, cadenaDerecha);

        }
    }

    private void RecursivoDerecha(BinaryTree<String> tree, Position<String> padre, String expresion) {
        int posSuma = expresion.lastIndexOf("+");
        int posResta = expresion.lastIndexOf("-");
        int posDivision = expresion.lastIndexOf("/");

        int pos = Integer.max(posSuma, posResta);
        if (pos==-1) { //No tengo ni suma ni resta
            if (posDivision==-1) { // NO tengo tampoco la /
                tree.insertRight(padre, expresion);
            }else {
                Position<String> p = tree.insertRight(padre, "/");
                String cadenaIzquierda = expresion.substring(0, posDivision);
                String cadenaDerecha = expresion.substring(posDivision+1);
                RecursivoIzquierda (tree,p,cadenaIzquierda);
                RecursivoDerecha (tree, p, cadenaDerecha);
            }
        }else {
            Position<String> p = tree.insertRight(padre, expresion.substring(pos,pos+1));
            String cadenaIzquierda = expresion.substring(0, pos);
            String cadenaDerecha = expresion.substring(pos+1);
            RecursivoIzquierda (tree,p,cadenaIzquierda);
            RecursivoDerecha (tree, p, cadenaDerecha);

        }
    }

    private int evaluate(Position<String> p) {
        if (tree.isLeaf(p)) {
            return Integer.parseInt(p.getElement());
        }else {
            switch (p.getElement()) {
                case "+": return evaluate (tree.left(p))+ evaluate (tree.right(p));
                case "-": return evaluate (tree.left(p))- evaluate (tree.right(p));
                case "/": return evaluate (tree.left(p))/ evaluate (tree.right(p));
            }
        }
        return 0;
    }

}