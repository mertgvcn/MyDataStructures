package MyBinarySearchTree;

public class TestClass {

	public static void main(String[] args) {
		
		MyBST bst = new MyBST();		
		bst.insert(8);
		bst.insert(4);
		bst.insert(15);
		bst.insert(2);
		bst.insert(6);
		bst.insert(20);
		bst.insert(25);
		bst.insert(10);
		bst.insert(9);
		bst.insert(12);
		bst.insert(17);
		bst.insert(16);
		
		System.out.println(bst.delete(15).data);
		bst.traverse();
		
	}

}
