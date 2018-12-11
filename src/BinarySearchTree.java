// ==============================================================
// Yeet

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

	private void add(Node node, V value) {
		Node created = null;
		// Value Greater Than Node Value
		if ( node.getValue().compareTo(value) < 0 ) {
			if ( node.getRightChild() == null ) {
				created = new Node(value);
				node.setRightChild(created);
				created.setParent(node);
			} else {
				add(node.getRightChild(), value);
			}
		}
		// Value Less Than Node Value
		else if (node.getValue().compareTo(value) > 0) {
			if ( node.getLeftChild() == null ) {
				created = new Node(value);
				node.setLeftChild(created);
				created.setParent(node);
			} else {
				add( node.getLeftChild(), value);
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

	public Node find( V value ) {
		return find(root, value);
	}

	private Node find( Node node, V value ) {
		if ( node == null ) {
			// value not found in tree
			return null;
		}
		if ( value.compareTo(node.getValue()) < 0 ) {
			return find( node.getLeftChild(), value);
		}else if ( value.compareTo(node.getValue()) > 0 ) {
			return find( node.getRightChild(), value);
		} else {
			// found it!
			return node;
		}
	}

	public void remove(V value) {
		Node selected = find(value);

		if(selected == null)
			return;

		if(selected == root && size() == 1) {
			root = null;
			size--;
			return;
		}
		remove(selected);
	}

	public void remove(Node node) {
		Node nextLargest = getNextLargest(node);
		//Has a right child
		if(nextLargest != null) {
			node.setValue(nextLargest.getValue());
			Node parent = nextLargest.getParent();
			if(parent.getLeftChild() == nextLargest) {
				parent.setLeftChild(nextLargest.getRightChild());;
				if(parent.getLeftChild() != null) {
					parent.getLeftChild().setParent(parent);
				}
			}
			else {
				parent.setRightChild(nextLargest.getRightChild());
				if(parent.getRightChild() != null) {
					parent.getRightChild().setParent(parent);
				}
			}
			size--;
		}
		//No right child
		else {
			if(node == root) {
				root = node.getLeftChild();
				root.setParent(null);
				size--;
			}
			else {
				nextLargest = node.getLeftChild();
				Node parent = node.getParent();
				if(parent.getLeftChild() == node) {
					parent.setLeftChild(nextLargest);
					if(parent.getLeftChild() != null)
						parent.getLeftChild().setParent(parent);
				}
				else {
					parent.setRightChild(nextLargest);
					if(parent.getRightChild() != null) {
						parent.getRightChild().setParent(parent);
					}
				}
				size--;
			}
		}
	}

	private BinarySearchTree<V>.Node getNextLargest(BinarySearchTree<V>.Node node) {
		return node.getRightChild();
	}

	public interface Visitor {
		public void visit( BinarySearchTree.Node node );
	}

	//Root, left, right
	public void preorderTraversal(Node node, Visitor v) {
		if (node == null) {
			return;
		}
		v.visit(node);
		preorderTraversal(node.getLeftChild(), v);
		preorderTraversal(node.getRightChild(), v);
	}

	//Left, root, right
	public void inorderTraversal(Node node, Visitor v) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.getLeftChild(), v);
		v.visit(node);
		inorderTraversal(node.getRightChild(), v);
	}

	//Left, right, root
	public void postorderTraversal(Node node, Visitor v) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.getRightChild(), v);
		postorderTraversal(node.getLeftChild(), v);
		v.visit(node);
	}

	//Level by level
	public void breadthfirstTraversal(Node node, Visitor v) {
		if(node == null)
			return;
		else {
			v.visit(node);
			if(node.getLeftChild() != null)
				breadthfirstTraversal(node.getLeftChild(), v);
			if(node.getRightChild() != null)
				breadthfirstTraversal(node.getRightChild(), v);
		}
	}
}