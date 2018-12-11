

import java.util.ArrayList;

public class LinkedBinaryTreeNode<E extends Comparable<E>> implements BinaryTreeNode<E> {

	BinarySearchTree<E> tree = new BinarySearchTree<E>();
	
	static int height;
	
	private E data;
	private LinkedBinaryTreeNode<E> parent;
	private LinkedBinaryTreeNode<E> left;
	private LinkedBinaryTreeNode<E> right;
	
	public LinkedBinaryTreeNode(BinarySearchTree<E> tree, E data) {
		this.data = data;
	}
	
	@Override
	public E getData() {
		return data;
	}

	@Override
	public void setData(E data) {
		this.data = data;
	}

	@Override
	public BinaryTreeNode<E> getRoot() {
		return root;
	}

	@Override
	public BinaryTreeNode<E> getParent() {
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
		left = (LinkedBinaryTreeNode<E>) child;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public BinaryTreeNode getRight() {
		return right;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setRight(BinaryTreeNode child) {
		right = (LinkedBinaryTreeNode<E>) child;
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
	
	private int size(LinkedBinaryTreeNode<E> node) {
		return 0;
	}

	@Override
	public void removeFromParent() {
		if(this != root) {
			
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
		
	}

	@Override
	public void traversePostorder(Visitor visitor) {
		
	}

	@Override
	public void traverseInorder(Visitor visitor) {
		
	}

}
