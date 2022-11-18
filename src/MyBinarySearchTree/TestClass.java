package MyBinarySearchTree;

public class TestClass {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		Node node = null;
		Node node2 = null;
		
		node = bst.insertRec(node, 5);
		node = bst.insertRec(node, 8);
		node = bst.insertRec(node, 3);
		
		node2 = bst.insertRec(node2, 9);
		node2 = bst.insertRec(node2, 12);
		node2 = bst.insertRec(node2, 4);
		
		bst.postOrder(node);
		System.out.println();
		bst.postOrder(node2);
		

	}

}
