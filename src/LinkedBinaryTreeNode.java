// ==============================================================
// Authors: Nick Hess, Justin Marshall, Katie Schmidt, Kai Borah, Rhandie Grabinski
// Date Last Modified: 12/12/18
// Description: Yeah
// ==============================================================

import java.util.ArrayList;

public class LinkedBinaryTreeNode<V extends Comparable<V>> implements BinaryTreeNode<V> {
	
	private V data;
	private LinkedBinaryTreeNode<V> parent;
	private LinkedBinaryTreeNode<V> left;
	private LinkedBinaryTreeNode<V> right;
	
	public LinkedBinaryTreeNode(V data) {
		this.data = data;
	}
	
	@Override
	public V getData() {
		return data;
	}

	@Override
	public void setData(V data) {
		this.data = data;
	}

	@Override
	public BinaryTreeNode<V> getRoot() {
		if( this.parent == null ) {
			return this;
		}
		return parent.getRoot();
	}

	@Override
	public BinaryTreeNode<V> getParent() {
		return parent;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public BinaryTreeNode getLeft() {
		return left;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setLeft(BinaryTreeNode child) {
		left = (LinkedBinaryTreeNode<V>) child;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public BinaryTreeNode getRight() {
		return right;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setRight(BinaryTreeNode child) {
		right = (LinkedBinaryTreeNode<V>) child;
	}

	@Override
	public boolean isParent() {
		return (left != null || right != null);
	}

	@Override
	public boolean isLeaf() {
		return (left == null || right == null);
	}

	@Override
	public boolean hasLeftChild() {
		return left != null;
	}

	@Override
	public boolean hasRightChild() {
		return right != null;
	}

	@Override
	public int getDepth() {
		int count = 0;
		LinkedBinaryTreeNode<V> currentParent = parent;
		while(currentParent != null) {
			count++;
			currentParent = (LinkedBinaryTreeNode)parent.getParent();
		}
		return count;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public int size() {
		return 1 + size(this);
	}
	
	private int size(LinkedBinaryTreeNode<V> node) {
		return 0;
	}

	@Override
	public void removeFromParent() {
		if(parent == null) {
			return;
		}
		else
        {
            if(parent.left != null) {
                if (parent.left.data == data)
                    parent.left = null;
            }
            else if(parent.right != null) {
                if (parent.right.data == data) {
                    parent.right = null;
                }
            }
            else{
            	// Shouldn't actually happen.
                System.out.println("Parent wasn't properly followed.");
                return;
            }
        }
	}

	@Override
	public ArrayList<BinaryTreeNode> pathTo(BinaryTreeNode descendant) {
		return null;
	}

	@Override
	public ArrayList<BinaryTreeNode> pathFrom(BinaryTreeNode ancestor) {
		return null;
	}

	@Override
	public void traversePreorder(Visitor visitor) {
        LinkedBinaryTreeNode<V> root = (LinkedBinaryTreeNode<V>)getRoot();
        traversePreorder( root, visitor );
	}
	//Helper method for the traversePreorder method
	private void traversePreorder( LinkedBinaryTreeNode<V> node, Visitor visitor ) {
	    if( node == null ) {
	        return;
        }
	    visitor.visit( node );
	    traversePreorder( node.left, visitor );
	    traversePreorder( node.right, visitor );
    }

	@Override
	public void traversePostorder(Visitor visitor) {
        LinkedBinaryTreeNode<V> root = (LinkedBinaryTreeNode<V>)getRoot();
        traversePostorder( root, visitor );
	}
	//Helper method for the traversePostorder method
    private void traversePostorder( LinkedBinaryTreeNode<V> node, Visitor visitor ) {
        if( node == null ) {
            return;
        }
	    traversePostorder( node.left, visitor );
	    traversePostorder( node.right, visitor );
	    visitor.visit( node );
    }

	@Override
	public void traverseInorder(Visitor visitor) {
        LinkedBinaryTreeNode<V> root = (LinkedBinaryTreeNode<V>)getRoot();
        traverseInorder( root, visitor );
	}
	//Helper method for the traverseInorder method
    private void traverseInorder( LinkedBinaryTreeNode<V> node, Visitor visitor ) {
        if( node == null ) {
            return;
        }
        traverseInorder( node.left, visitor );
        visitor.visit( node );
        traverseInorder( node.right, visitor );
    }

	public void setParent(LinkedBinaryTreeNode<V> node) {
		this.parent = node;
	}

}
