public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		tree.add(1);
		tree.add(3);
		tree.add(2);
		tree.add(9);
		tree.add(6);
		tree.add(8);
		tree.add(7);
		tree.add(4);
		
		BinarySearchTree.Visitor v = new BinarySearchTree.Visitor() {

			@Override
			public void visit(LinkedBinaryTreeNode node) {
				System.out.print(node.getData() + " ");
			}
			
		};

		System.out.print("Preorder Traversal: ");
		tree.preorderTraversal(tree.getRoot(), v);
		System.out.println();
		System.out.print("Inorder Traversal: ");
		tree.inorderTraversal(tree.getRoot(), v);
		System.out.println();
		System.out.print("Postorder Traversal: ");
		tree.postorderTraversal(tree.getRoot(), v);
		System.out.println();
		System.out.print("Breadthfirst Traversal: ");
		tree.breadthfirstTraversal(tree.getRoot(), v);
		System.out.println();
	}
	
}