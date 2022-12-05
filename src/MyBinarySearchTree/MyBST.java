package MyBinarySearchTree;

public class MyBST {
	
	//Node class
	public class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	//attribute of BST
	Node root;
	
	//constructor of BST
	public MyBST() {
		root = null;
	}
	
	//insert methods
	public void insert(int data) { //the method that user is able to access
		root = insert(root, data);
	}
	
	private Node insert(Node focus, int data) { //the method running in background recursively; in every insertion, we are redefining the nodes that we passed through
		
		if(focus == null) { //same thing with calling isEmpty()
			Node newNode = new Node(data);
			return newNode;
		}
		
		if(data < focus.data) { 
			focus.left = insert(focus.left, data);
		}else {
			focus.right = insert(focus.right, data);
		}
		
		return focus; //because we redefine the path, we need to specify transition method's focus.
	}
	
	
	//delete method
	public Node delete(int data) {
		return delete(root, data);
	}
	
	private Node delete(Node focus, int data) {
		if(focus == null) return null; //node is not in the tree
		
		if(data < focus.data) {
			focus.left = delete(focus.left, data);
		} else if(data > focus.data){
			focus.right = delete(focus.right, data);
		}else {
			//case 1 : when deleted node is leaf
			if(focus.left == null && focus.right == null) {
				return null;
			}
			
			//case 2 : when node has single child
			if(focus.left == null) return focus.right;
			if(focus.right == null) return focus.left;
			
			//case 3: when node has two children
			int replaceData = getMin(focus.right).data;
			focus.data = replaceData;
			focus.right = delete(focus.right, focus.data);
		}
		
		return focus;
	}	
	
	//other methods
	public Node getMin(Node focus) {
		if(focus.left == null) {
			return focus;
		}
		
		return getMin(focus.left);
	}
	
	public Node getMax(Node focus) {
		if(focus.right == null) {
			return focus;
		}
		
		return getMax(focus.right);
	}
	
	public Node search(Node focus, int data) {
		
		if (focus == null) return null;
		
		if (data == focus.data) {
			return focus;
		}
		else if (data < focus.data) {
			return search(focus.left, data);
		}else {
			return search(focus.right, data);
		}
		
	}
	
	
	//supportive methods
	public boolean isEmpty() {
		return (root == null);
	}
	
	
	//traverse the BST
	public void traverse() {
		System.out.print("inOrder : ");
		inOrder(this.root);
		
		System.out.print("\npreOrder : ");
		preOrder(this.root);
		
		System.out.print("\npostOrder : "); 
		postOrder(this.root);
		
		System.out.println();
	}
	
	private void inOrder(Node focus) {
		if(focus != null) {
			inOrder(focus.left);
			System.out.print(focus.data + " ");
			inOrder(focus.right);
		}
	}
	
	private void preOrder(Node focus) {
		if(focus != null) {
			System.out.print(focus.data + " ");
			preOrder(focus.left);
			preOrder(focus.right);
		}
	}
	
	private void postOrder(Node focus) {
		if(focus != null) {			
			postOrder(focus.left);
			postOrder(focus.right);
			System.out.print(focus.data + " ");
		}
	}
	
	private void levelOrder() {}
	
	
	
	/*
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
	*/
}
