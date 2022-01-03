package structures.orderedMapsAndDictionaries.ordereddictionary;

import java.util.Comparator;
import structures.tree.binarySearchTree.LinkedBinarySearchTree;

/**
 * Realization of a dictionary by means of a binary search tree.
 *
 * @author Rackumi
 */
public class BSTOrderedDict<K, V> extends AbstractTreeOrderedDict<K, V> {
	
	public BSTOrderedDict() {
		super();
	}
	
	public BSTOrderedDict(Comparator<K> keyComparator) {
		super(keyComparator);
	}

	@Override
	protected LinkedBinarySearchTree<Entry<K,V>> createTree (){
		return new LinkedBinarySearchTree<Entry<K,V>>();		
	}

}