package structures.linear.list.floatList;

/**
 * Implementation for FloatLinkedList
 *
 * @author Rackumi
 */
public class FloatLinkedList implements ListFloat {

    private class FloatNode {

        private Float element;
        private FloatNode next;

        public FloatNode(float element){
            this.element = element;
            this.next = null;
        }

        public FloatNode getNext() {
            return next;
        }

        public void setNext(FloatNode next) {
            this.next = next;
        }

        public Float getElement() {
            return element;
        }

        public void setElement(Float element) {
            this.element = element;
        }

    }

    private FloatNode head;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public void add(Float value) {
        FloatNode node = new FloatNode(value);
        node.setNext(this.head); //si esta vacia apuntará a null
        this.head = node;
        this.size++;
    }

    @Override
    public void add(int index, Float value) {
        if((index>=1)&&(index<=this.size)) {
            FloatNode node = new FloatNode(value);
            if (index==1) {
                node.setNext(this.head);
                this.head = node;
            }
            else{
                FloatNode aux = head;
                for (int i = 0; i<index-1; i++) {
                    aux = aux.getNext();
                }
                FloatNode auxPrev = aux;
                aux = aux.getNext();

                auxPrev.setNext(node);
                node.setNext(aux);
            }
            this.size++;
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public Float remove() {
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        else{
            this.size--;
            FloatNode aux = this.head;
            this.head = this.head.getNext();
            return aux.getElement();

        }
    }

    @Override
    public Float remove(int index) {
        if((index>=1)&&(index<=this.size)) {
            this.size--;
            if (index==1) {
                float auxElem = this.head.getElement();
                this.head = this.head.getNext();
                return auxElem;
            }
            else{
                FloatNode aux = head;
                float auxElem;
                for (int i = 1; i<index-1; i++) {
                    aux = aux.getNext();
                }
                auxElem = aux.getNext().getElement();
                aux.setNext(aux.getNext().getNext());
                return auxElem;
            }
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public Float get() {
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        else{
            return head.getElement();
        }
    }

    @Override
    public Float get(int index) {
        if((index>=1)&&(index<=this.size)) {
            if (index==1) {
                return this.head.getElement();
            }
            else{
                FloatNode aux = head;
                float auxElem;
                for (int i = 1; i<index-1; i++) {
                    aux = aux.getNext();
                }
                auxElem = aux.getNext().getElement();
                return auxElem;
            }
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public int search(Float value) {
        if(!isEmpty()) {
            if (this.head.getElement().equals(value)) {
                return 1;
            }
            else {
                int cont = 1;
                FloatNode aux = this.head;
                while(cont<this.size) {
                    cont++;
                    aux = aux.getNext();
                    if (aux.getElement().equals(value)) {
                        return cont;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public boolean contains(Float value) {
        int position = search(value);
        return position != 0;
    }

}