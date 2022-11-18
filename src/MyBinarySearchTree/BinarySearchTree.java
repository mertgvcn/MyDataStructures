package MyBinarySearchTree;

import java.util.Queue;

import MyQueueWithArray.MyQueueWithArray;
import MyQueueWithLL.MyQueueWithLL;

public class BinarySearchTree {
	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		Node pointer = root;
		Node temp = null; //pointer null olduðunda önceki adresi kaybetmemek için geçici node

		if (isEmpty()) {
			root = newNode;
		} else {

			while (pointer != null) { //pointer ile eklenecek adresi bulacaðýz		
				temp = pointer;	//pointer null olacaðý için bir önceki deðerini yedekliyoruz
				
				if (newNode.data < pointer.data) {
					pointer = pointer.left;
				} else if (newNode.data > pointer.data) {
					pointer = pointer.right;
				}
			}
			
			if(newNode.data < temp.data) { //temp eklenecek node'un atasý. 
				temp.left = newNode;
			}else {
				temp.right = newNode;
			}
		}
	}
	
	public Node insertRec(Node focus, int data) {
		
		if(focus == null) {
			Node newNode = new Node(data);
			return newNode;	
		}
		
		if(data < focus.data) {
			focus.left = insertRec(focus.left, data);
		}else if (data > focus.data){
			focus.right = insertRec(focus.right, data);
		}
		
		return focus;
	}
	
	//Other Functions
    public boolean sameTree(Node a, Node b) {
        
        if(a == null && b == null) {
            return true;
        }

        if (a != null && b != null) {
            return ((a.data == b.data) && sameTree(a.left, b.left) && sameTree(a.right, b.right));
        }
           
        return false;
    }
    
    public int maxDepth(Node focus) {
        if (focus == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(focus.left), maxDepth(focus.right));

    }
	
    public int sumRec(Node focus) {
        if (focus == null) {
            return 0;
        }

        return focus.data + sumRec(focus.left) + sumRec(focus.right);
    }
    
	// Search and traverse
	public Node search(Node root, int data) {
		return root;
	}
	
	public void preOrder(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);	
	}
	
	public void postOrder(Node root) {
	
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
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
