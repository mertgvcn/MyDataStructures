package MyBinarySearchTree;

public class TestClass {

	public static void main(String[] args) {
		
		MyBST bst = new MyBST();		
		bst.insert(8);
		bst.insert(4);
		bst.insert(15);
		bst.insert(2);
		bst.insert(6);
		
		bst.traverse();
		
		System.out.println(bst.getMin(bst.root).data);
	}

}
