package examenes.extraordinaria_2020_2021.test;

import examenes.extraordinaria_2020_2021.HeapTree;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTreeTest {
    private HeapTree<Integer> heap;

    @BeforeEach
    void init(){
        heap = new HeapTree<>(7, 3);
        heap.insert(24);
        heap.insert(6);
        heap.insert(23);
        heap.insert(12);
        heap.insert(75);
        heap.insert(78);
        heap.insert(29);
    }
    @org.junit.jupiter.api.Test
    void test1() {
        assertEquals(heap.findMin(), 6);
    }

    @org.junit.jupiter.api.Test
    void test2() {
        heap.remove(0);
        assertEquals(heap.findMin(), 12);
    }

    @org.junit.jupiter.api.Test
    void test3() {
        String heapAct = "6 24 23 12 75 78 29 ";
        assertEquals(heap.printHeap(), heapAct);
    }

    @org.junit.jupiter.api.Test
    void test4() {
        heap.insert(5);
        assertEquals(heap.findMin(), 5);
    }

    @org.junit.jupiter.api.Test
    void test5(){
        assertTrue(heap.isFull());
        heap.insert(9);
        assertFalse(heap.isFull());
    }

}