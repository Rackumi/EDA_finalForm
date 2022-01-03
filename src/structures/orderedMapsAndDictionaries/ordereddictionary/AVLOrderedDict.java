package structures.orderedMapsAndDictionaries.ordereddictionary;

import java.util.Comparator;
import structures.tree.binarySearchTree.AVLTree;
import structures.tree.binarySearchTree.BinarySearchTree;

/**
 * Realization of a dictionary by means of a AVL Tree.
 *
 * @author Rackumi
 */
public class AVLOrderedDict<K, V> extends AbstractTreeOrderedDict<K, V> {

	public AVLOrderedDict() {
		super();
	}

	public AVLOrderedDict(Comparator<K> keyComparator) {
		super(keyComparator);
	}

	@Override
	protected BinarySearchTree<Entry<K,V>> createTree() {
		return new AVLTree<>();
	}
	
}