package structures.linear.list.positionList;

import structures.Position;
import java.util.Iterator;

public class PositionLinkedListIterator<E> implements Iterator<Position<E>> {

    private Position<E> p;
    private PositionLinkedList<E> list;

    public PositionLinkedListIterator(PositionLinkedList<E> list) {
        this.list = list;
        this.p = list.get();
    }

    @Override
    public boolean hasNext() {
        return this.p != null;
    }

    @Override
    public Position<E> next() {
        Position<E> pAux = this.p;
        this.p = this.list.getNext(this.p);
        return pAux;
    }

}