package examenes.extra6.solucion;

import java.util.Iterator;
import structures.Position;
import structures.tree.Tree;

public class TreeUtils<E> {

    public boolean igualesExamen(Tree<E> t1, Tree<E> t2) {
        if ((t1.isEmpty()) && (t2.isEmpty()))
            return true;
        else if ((!t1.isEmpty()) && (t2.isEmpty()))
            return false;
        else if ((t1.isEmpty()) && (!t2.isEmpty()))
            return false;
        else 
            return igualesExamen (t1, t1.root(), t2, t2.root());
        
    }
    
    public boolean iguales(Tree<E> t1, Tree<E> t2) {
        if ((t1.isEmpty()) && (t2.isEmpty()))
            return true;
        else if ((!t1.isEmpty()) && (t2.isEmpty()))
            return false;
        else if ((t1.isEmpty()) && (!t2.isEmpty()))
            return false;
        else 
            return iguales (t1, t1.root(), t2, t2.root());
            
    }

    //Nota: La otra función la hacemos en los LinkedTree con la siguiente cabecera
    //public LinkedTree<E> copiarDesde (Position<E> origen);

    private boolean iguales(Tree<E> t1, Position<E> p1,
                            Tree<E> t2, Position<E> p2) {
        if (!p1.getElement().equals(p2.getElement())) {
            return false;
        }
        Iterator<? extends Position<E>> it1 = t1.children(p1).iterator();
        Iterator<? extends Position<E>> it2 = t2.children(p2).iterator();
        
        
        while ((it1.hasNext()) && (it2.hasNext())) {
            Position<E> hijoT1 = it1.next();
            Position<E> hijoT2 = it2.next();
            boolean aux = iguales (t1, hijoT1, t2, hijoT2);
            if (!aux) {
                return false;
            }
            
        }
        return ((!it1.hasNext()) && (!it2.hasNext()));
        
    }

    private boolean igualesExamen(Tree<E> t1, Position<E> p1, 
                                Tree<E> t2, Position<E> p2) {
        if (!p1.getElement().equals(p2.getElement())) {
            return false;
        }
        
        int contP1=0;
        for (Position<E> p: t1.children(p1)) {
            contP1++;
        }
        int contP2=0;
        for (Position<E> p: t2.children(p2)) {
            contP2++;
        }
        
        if (contP1!=contP2) {
            return false;
        }
        
        for (Position<E> hijoP1: t1.children(p1)) {
            boolean encontrado=false;
            for (Position<E> hijoP2: t2.children(p2)) {
                if (hijoP1.getElement().equals(hijoP2.getElement())) {
                    encontrado=true;
                    boolean aux = igualesExamen (t1, hijoP1, t2, hijoP2);
                    if (!aux)
                        return false;
                }
            }
            if (!encontrado) {
                return false;
            }
        }

        return true;
    }

}