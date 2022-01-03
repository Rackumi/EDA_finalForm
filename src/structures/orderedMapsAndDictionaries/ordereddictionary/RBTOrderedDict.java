package structures.orderedMapsAndDictionaries.ordereddictionary;

import structures.tree.binarySearchTree.BinarySearchTree;
import structures.tree.binarySearchTree.RBTree;

import java.util.Comparator;

/**
 * Realization of a dictionary by means of a RBTree.
 *
 * @author Rackumi
 */
public class RBTOrderedDict<K, V> extends AbstractTreeOrderedDict<K, V> {

	public RBTOrderedDict() {
		super();
	}

	public RBTOrderedDict(Comparator<K> keyComparator) {
		super(keyComparator);
	}
	
	@Override
	protected BinarySearchTree<Entry<K,V>> createTree() {
		return new RBTree<>();
	}
	
}