package BinaryTree;

public class DFS {
	
	/*Inorder traversal
	 * 
	 *                      10        
	 *                    /    \
	 *                   11      9   
	 *                  /  \     /  \
	 *                 7    12   15   8
	 * 
	 * Left -> Root -> Right
	 * 
	 * i.e.7 11 12 10 15 9 8
	 * 
	 * */

	void inOrder(Node root) {

		if (root == null)
			return;

		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);

	}
	
	/*Pre-Order traversal
	 * 
	 *                      10        
	 *                    /    \
	 *                   11      9   
	 *                  /  \     /  \
	 *                 7    12   15   8
	 * 
	 * Root -> Left -> Right
	 * 
	 * i.e.10 11 7 12 9 15 8
	 * 
	 * */
	
	void preOrder(Node root) {
		if(root == null)
			return;
		System.out.println(root.key);
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
	

	/*Post-Order traversal
	 * 
	 *                      10        
	 *                    /    \
	 *                   11      9   
	 *                  /  \     /  \
	 *                 7    12   15   8
	 * 
	 * Left -> Right -> Root
	 * 
	 * i.e. 7 12 11 15 8 9 10
	 * 
	 * */
	void postOrder(Node root) {
		if(root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.key);
				
		
		
		
	}

	public static void main(String args[]) {
		Node root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.left.right=new Node(12);
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8); 
        System.out.println("Printing in Order Traversal......Left-> Root -> Right");
        new DFS().inOrder(root);
        System.out.println("Printing Pre- Order Traversal......Root-> Left -> Right");
        new DFS().preOrder(root);
        System.out.println("Printing Post- Order Traversal......Left-> Right -> Root");
        new DFS().postOrder(root);

	}
	
}
