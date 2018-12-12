

import java.util.ArrayList;

public class LinkedBinaryTreeNode<V extends Comparable<V>> implements BinaryTreeNode<V> {

	BinarySearchTree<V> tree = new BinarySearchTree<V>();
	
	static int height;
	
	private V data;
	private LinkedBinaryTreeNode<V> parent;
	private LinkedBinaryTreeNode<V> left;
	private LinkedBinaryTreeNode<V> right;
	
	public LinkedBinaryTreeNode(BinarySearchTree<V> tree, V data) {
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
		return tree.getRoot();
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
		while(parent != null) {
			count++;
		}
		return count;
	}

	@Override
	public int getHeight() {
		return height;
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
		//if(this != root) {
			
		//}
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
		
	}

	@Override
	public void traversePostorder(Visitor visitor) {
		
	}

	@Override
	public void traverseInorder(Visitor visitor) {
		
	}

	public void setParent(LinkedBinaryTreeNode<V> node) {
		this.parent = node;
	}

}
