package examenes.ordinaria_2019_2020.test;

import examenes.ordinaria_2019_2020.ejercicio1.RemoveFrontier;
import structures.Position;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveFrontierTest {

    RemoveFrontier<String> frontier;
    NAryTree<String> tree;

    @BeforeEach
    void setUp() {
        frontier = new RemoveFrontier<>();
        tree = new LinkedTree<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void removeFrontierA(){
        Position<String> pos[] = new Position[10];

        pos[0] = tree.addRoot("A");
        pos[1] = tree.add("B", pos[0]);
        pos[2] = tree.add("C", pos[0]);
        pos[3] = tree.add("D", pos[1]);
        pos[4] = tree.add("E", pos[2]);
        pos[5] = tree.add("F", pos[2]);
        pos[6] = tree.add("G", pos[5]);

        frontier.removeFrontier(tree);
        assertEquals(4, tree.size());
    }

}