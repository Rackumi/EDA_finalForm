package structures.linear.stack.floatStack;

/**
 * Implementation for FloatArrayStack
 *
 * @author Rackumi
 */
public class FloatArrayStack implements StackFloat {

    private float[] s;
    private int top;
    private int MAX_SIZE;

    public FloatArrayStack(int cap) {
        this.s = new float[cap];
        this.top = 0; //siempre estará un 1 por encima del elemento de arriba
        this.MAX_SIZE = cap;
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
    public void push(Float element) {
        if(this.top==MAX_SIZE/2){
            MAX_SIZE *= 2;
            float[] s2 = new float[this.MAX_SIZE];
            System.arraycopy(s,0,s2,0,top);
            s = s2;
        }
        this.s[this.top] = element;
        this.top++;
    }

    @Override
    public Float pop() throws RuntimeException{
        if(!isEmpty()){
            this.top--;
            return s[top];
        }
        else{
            throw new RuntimeException("The stack is empty");
        }
    }

    @Override
    public Float top() throws RuntimeException{
        if(!isEmpty()){
            return s[this.top-1];
        }
        else{
            throw new RuntimeException("The stack is empty");
        }
    }

}
