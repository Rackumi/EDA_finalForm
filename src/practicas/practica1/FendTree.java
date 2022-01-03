package practicas.practica1;

/**
 *
 * @author Rackumi
 */
public class FendTree {

    int[] BITree;

    /**
     * Builds a Fendwick Tree with the array that receives
     * 
     * @param array
     */
    public FendTree(int [] array){
        BITree = new int[array.length+1];
        for(int i=0; i< BITree.length-1; i++){
            upDate(i, array[i]);
        }
    }
    
    /**
     * Receives an index and returns the partia  l sum from zero to that index.
     * An exception is thrown if the index is less than zero or greater than or equal to n.
     * @param index
     * @return 
     */
    public int getSum(int index){
        if(index<0 || index>=BITree.length){
            throw new RuntimeException("The index is less than zero or greater than or equal to n");
        }
        int suma=0;
        index = index+1;
        while(index > 0){
            suma = suma + BITree[index];
            index = index - (index & (-index));
        }

        return suma;
    }
 
    /**
     * Update the value of the position index in the array.
     * 
     * @param index
     * @param val
     */
    public void upDate (int index, int val){
        if(index<0 || index>=BITree.length){
            throw new RuntimeException("The index is less than zero or greater than or equal to n");
        }
        index = index+1;
        while(index <= BITree.length-1){
            BITree[index] = BITree[index] + val;
            index = index + (index & (-index));
        }
    }

}