package items.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Colecciones {

    public static void main (String[] args){

        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();

        l1.add(1);
        l1.add(5);
        l1.add(111);
        l1.add(14);
        l1.add(56);
        l1.add(111);
        l1.add(17);
        l1.add(532);
        l1.add(21);
        System.out.println("Inicialization: "+l1);

        //para que no de error al hacer el copy
        Collections.addAll(l2, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        System.out.println("AddAll:         "+l2);

        Collections.sort(l1);
        System.out.println("Sort:           "+l1);

        Collections.shuffle(l1);
        System.out.println("Shuffle:        "+l1);

        Collections.reverse(l1);
        System.out.println("Reverse:        "+l1);

        Collections.copy(l2, l1);
        System.out.println("Copy:           "+l2);

        Collections.fill(l2, 1);
        System.out.println("Fill:           "+l2);

        Collections.swap(l1, 0, l1.size()-1);
        System.out.println("Swap:           "+l1);

        Collections.sort(l1); //debe estar ordenado para poder hacer binarySearch
        System.out.println("BinarySearch:   "+Collections.binarySearch(l1, 1));

        System.out.println("Frequency:      "+Collections.frequency(l1, 111));

        System.out.println("Disjoint:       "+Collections.disjoint(l1, l2));

        System.out.println("Min:            "+Collections.min(l1));

        System.out.println("Max:            "+Collections.max(l1));
    }

}