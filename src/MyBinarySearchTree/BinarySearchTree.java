package MyBinarySearchTree;

public class BinarySearchTree {
	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		Node pointer = root;
		Node temp = null; //pointer null oldu�unda �nceki adresi kaybetmemek i�in ge�ici node

		if (isEmpty()) {
			root = newNode;
		} else {

			while (pointer != null) { //pointer ile eklenecek adresi bulaca��z		
				temp = pointer;	//pointer null olaca�� i�in bir �nceki de�erini yedekliyoruz
				
				if (newNode.data < pointer.data) {
					pointer = pointer.left;
				} else if (newNode.data > pointer.data) {
					pointer = pointer.right;
				}
			}
			
			if(newNode.data < temp.data) { //temp eklenecek node'un atas�. 
				temp.left = newNode;
			}else {
				temp.right = newNode;
			}
		}
	}

	// SUPPORT
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}

		return false;
	}

}
