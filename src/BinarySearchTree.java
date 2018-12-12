// ==============================================================
// Authors: Nick Hess, Justin Marshall, Katie Schmidt, Kai Bo

public class BinarySearchTree<V extends Comparable<V>> {
	
	private LinkedBinaryTreeNode<V> root = null;
	private int size = 0;

	public boolean isEmpty( ) {
		return size == 0 || root == null;
	}

	public int size( ) {
		return size;
	}

	public void add( V value ) {
		if ( isEmpty() ) {
			root = new LinkedBinaryTreeNode<V>(this, value);
		} else {
			add(root, value);
		}
		size++;
	}

	@SuppressWarnings("unchecked")
	private void add(LinkedBinaryTreeNode<V> node, V value) {
		LinkedBinaryTreeNode<V> created = null;
		// Value Greater Than Node Value
		if ( node.getData().compareTo(value) < 0 ) {
			if ( node.getRight() == null ) {
				created = new LinkedBinaryTreeNode<V>(this, value);
				node.setRight(created);
				created.setParent(node);
			}
			else {
				add(((LinkedBinaryTreeNode<V>)node.getRight()), value);
			}
		}
		// Value Less Than Node Value
		else if (node.getData().compareTo(value) > 0) {
			if ( node.getLeft() == null ) {
				created = new LinkedBinaryTreeNode<V>(this, value);
				node.setLeft(created);
				created.setParent(node);
			} else {
				add(((LinkedBinaryTreeNode<V>)node.getLeft()), value);
			}
		}
		// Value Equals Node Value
		else {
			throw new IllegalArgumentException( "value already exists in tree");
		}
	}

	public boolean isInTree( V value ) {
		return find(root, value) != null;
	}

	public LinkedBinaryTreeNode<V> find( V value ) {
		return find(root, value);
	}

	@SuppressWarnings("unchecked")
	private LinkedBinaryTreeNode<V> find( LinkedBinaryTreeNode<V> node, V value ) {
		if ( node == null ) {
			// value not found in tree
			return null;
		}
		if ( value.compareTo(node.getData()) < 0 ) {
			return find((LinkedBinaryTreeNode<V>) node.getLeft(), value);
		}else if ( value.compareTo(node.getData()) > 0 ) {
			return find((LinkedBinaryTreeNode<V>) node.getRight(), value);
		} else {
			// found it!
			return node;
		}
	}

	public void remove(V value) {
		LinkedBinaryTreeNode<V> selected = find(value);

		if(selected == null)
			return;

		if(selected == root && size() == 1) {
			root = null;
			size--;
			return;
		}
		remove(selected);
	}

	public void remove(LinkedBinaryTreeNode<V> node) {
		LinkedBinaryTreeNode<V> nextLargest = getNextLargest(node);
		//Has a right child
		if(nextLargest != null) {
			node.setData(nextLargest.getData());
			LinkedBinaryTreeNode<V> parent = (LinkedBinaryTreeNode<V>) nextLargest.getParent();
			if(parent.getLeft() == nextLargest) {
				parent.setLeft(nextLargest.getRight());;
				if(parent.getLeft() != null) {
					((LinkedBinaryTreeNode<V>) parent.getLeft()).setParent(parent);
				}
			}
			else {
				parent.setRight(nextLargest.getRight());
				if(parent.getRight() != null) {
					((LinkedBinaryTreeNode<V>) parent.getRight()).setParent(parent);
				}
			}
			size--;
		}
		//No right child
		else {
			if(node == root) {
				root = (LinkedBinaryTreeNode<V>) node.getLeft();
				root.setParent(null);
				size--;
			}
			else {
				nextLargest = (LinkedBinaryTreeNode<V>) node.getLeft();
				LinkedBinaryTreeNode<V> parent = (LinkedBinaryTreeNode<V>) node.getParent();
				if(parent.getLeft() == node) {
					parent.setLeft(nextLargest);
					if(parent.getLeft() != null)
						((LinkedBinaryTreeNode<V>) parent.getLeft()).setParent(parent);
				}
				else {
					parent.setRight(nextLargest);
					if(parent.getRight() != null) {
						((LinkedBinaryTreeNode<V>) parent.getRight()).setParent(parent);
					}
				}
				size--;
			}
		}
	}

	private LinkedBinaryTreeNode<V> getNextLargest(LinkedBinaryTreeNode<V> node) {
		return (LinkedBinaryTreeNode<V>) node.getRight();
	}

	public interface Visitor {
		public void visit(LinkedBinaryTreeNode node);
	}

	//Root, left, right
	public void preorderTraversal(LinkedBinaryTreeNode<V> node, Visitor v) {
		if (node == null) {
			return;
		}
		v.visit(node);
		preorderTraversal((LinkedBinaryTreeNode<V>) node.getLeft(), v);
		preorderTraversal((LinkedBinaryTreeNode<V>) node.getRight(), v);
	}

	//Left, root, right
	public void inorderTraversal(LinkedBinaryTreeNode<V> node, Visitor v) {
		if (node == null) {
			return;
		}
		inorderTraversal((LinkedBinaryTreeNode<V>) node.getLeft(), v);
		v.visit(node);
		inorderTraversal((LinkedBinaryTreeNode<V>) node.getRight(), v);
	}

	//Left, right, root
	public void postorderTraversal(LinkedBinaryTreeNode<V> node, Visitor v) {
		if (node == null) {
			return;
		}
		postorderTraversal((LinkedBinaryTreeNode<V>) node.getRight(), v);
		postorderTraversal((LinkedBinaryTreeNode<V>) node.getLeft(), v);
		v.visit(node);
	}

	//Level by level
	public void breadthfirstTraversal(LinkedBinaryTreeNode<V> node, Visitor v) {
		if(node == null)
			return;
		else {
			v.visit(node);
			if(node.getLeft() != null)
				breadthfirstTraversal((LinkedBinaryTreeNode<V>) node.getLeft(), v);
			if(node.getRight() != null)
				breadthfirstTraversal((LinkedBinaryTreeNode<V>) node.getRight(), v);
		}
	}

	public LinkedBinaryTreeNode<V> getRoot() {
		return root;
	}
}