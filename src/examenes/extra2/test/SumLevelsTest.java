package examenes.extra2.test;

import static org.junit.Assert.*;

import examenes.extra2.source.sumlevels.SumLevels;
import org.junit.Before;
import org.junit.Test;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

public class SumLevelsTest {

	BinaryTree<Integer> tree;
	SumLevels sumLevels;
	
	@Before
	public void setUp() throws Exception {
		tree = new LinkedBinaryTree<>();
		Position<Integer> tres = tree.addRoot(3);
		Position<Integer> dos = tree.insertLeft(tres, 2);
		Position<Integer> uno = tree.insertRight(tres, 1);
		Position<Integer> cero = tree.insertLeft(dos, 0);
		Position<Integer> ocho = tree.insertRight(uno, 8);
		Position<Integer> nueve = tree.insertLeft(ocho, 9);
		Position<Integer> diez = tree.insertRight(ocho, 10);
		
		sumLevels = new SumLevels(tree);
	}

	@Test
	public void testSumLevels1() {
		int sum = sumLevels.sumLevels(new int[]{0});
		assertEquals(3, sum);
	}
	
	@Test
	public void testSumLevels2() {
		int sum = sumLevels.sumLevels(new int[]{0,1});
		assertEquals(6, sum);
	}
	
	@Test
	public void testSumLevels3() {
		int sum = sumLevels.sumLevels(new int[]{1,2});
		assertEquals(11, sum);
	}
	
	@Test
	public void testSumLevels4() {
		int sum = sumLevels.sumLevels(new int[]{1,3});
		assertEquals(22, sum);
	}
	
	@Test
	public void testSumLevels5() {
		int sum = sumLevels.sumLevels(new int[]{0,1,2,3});
		assertEquals(33, sum);
	}

}