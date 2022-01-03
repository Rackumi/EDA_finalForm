package examenes.extra1.test.tree;

import examenes.extra1.source.tree.WeightedLinkedTree;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import structures.Position;
import org.junit.Test;

/**
 *
 * @author Rackumi
 */
public class WeightedLinkedTreeTest extends TestCase {

    private WeightedLinkedTree<String> tree;

    @Test
    public void testSize() {
        tree = new WeightedLinkedTree<>();
        Position<String> p = this.tree.addRoot("+");
        this.tree.add("2", p, 4);
        Position<String> h = this.tree.add("*", p, 1);
        this.tree.add("3", h, 5);
        this.tree.add("5", h, 3);
        assertEquals(this.tree.size(), 5);
    }

    @Test
    public void testIsEmpty() {
        tree = new WeightedLinkedTree<>();
        assertEquals(this.tree.isEmpty(), true);
        Position<String> p = this.tree.addRoot("+");
        assertEquals(this.tree.isEmpty(), false);
    }

    @Test
    public void testGetWeight() {
        tree = new WeightedLinkedTree<>();
        Position<String> p = this.tree.addRoot("+");
        Position<String> h1 = this.tree.add("2", p, 2);
        Position<String> h2 = this.tree.add("3", p, 0);

        assertEquals(2, this.tree.getWeight(p, h1));
        assertEquals(0, this.tree.getWeight(p, h2));
    }

    @Test
    public void testGetWeightError() {
        tree = new WeightedLinkedTree<>();
        Position<String> p = this.tree.addRoot("+");
        Position<String> h1 = this.tree.add("2", p, 2);
        Position<String> h2 = this.tree.add("3", p, 0);
        try {
            tree.getWeight(h2, h1);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}