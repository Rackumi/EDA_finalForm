package structures.linear.stack.genericStack;

/**
 * Implementation for GenericArrayStack
 *
 * @author Rackumi
 */
public class GenericArrayStack<E> implements StackGeneric<E> {

    private E[] s;
    private int top;
    private int MAX_SIZE;

    public GenericArrayStack(int cap) {
        this.s = (E[]) new Object[cap];
        this.top = 0; //siempre estará un 1 por encima del elemento de arriba
        MAX_SIZE = cap;
    }

    @Override
    public int size() {
        return this.top;
    }

    @Override
    public boolean isEmpty() {
        return this.top==0;
    }

    @Override
    public void push(E element) {
        if(this.top==MAX_SIZE/2){
            MAX_SIZE *= 2;
            E[] s2 = (E[]) new Object[this.MAX_SIZE];
            System.arraycopy(s,0,s2,0,top);
            s = s2;
        }
        this.s[this.top] = element;
        this.top++;
    }

    @Override
    public E pop() throws RuntimeException{
        if(!isEmpty()){
            this.top--;
            return s[top];
        }
        else{
            throw new RuntimeException("The stack is empty");
        }
    }

    @Override
    public E top() throws RuntimeException{
        if(!isEmpty()){
            return s[this.top-1];
        }
        else{
            throw new RuntimeException("The stack is empty");
        }
    }

}
