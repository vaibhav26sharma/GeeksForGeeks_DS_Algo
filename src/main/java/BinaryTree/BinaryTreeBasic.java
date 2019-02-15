package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*Binary Tree Properties: https://www.geeksforgeeks.org/binary-tree-set-2-properties/
 * 						  https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
 * ---------------------
 * 1) The maximum number of nodes at level ‘l’ of a binary tree is 2^l-1.
 * 2) Maximum number of nodes in a binary tree of height ‘h’ is 2^h – 1.
 * 3) In a Binary Tree with N nodes, minimum possible height or minimum number of levels is  ⌈ Log2(N+1) ⌉   
 * 4) A Binary Tree with L leaves has at least   ⌈ Log2L ⌉ + 1   levels
 * 5) In Binary tree where every node has 0 or 2 children, number of leaf nodes is always one more than nodes with two children:
 *  L = T + 1
	Where L = Number of leaf nodes
      T = Number of internal nodes with two children
*/

public class BinaryTreeBasic {
	
	static Node root;
	
	public BinaryTreeBasic(int key) {

		this.root = new Node(key);
	}
	
	BinaryTreeBasic(){
		root = null;
	}
	
    /* Inorder traversal of a binary tree*/
	static void inOrder(Node tmp) {
		if(tmp == null)
			return;
		
		inOrder(tmp.left);
		System.out.println(tmp.key+" ");
		inOrder(tmp.right);
	}
	
	
    /*function to insert element in binary tree */
	static void levelOrderInsertion(Node tmp, int key) { //tmp->root ; key-> element to insert
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(tmp);		
		
		while(!q.isEmpty()) { //run loop until an empty element is found 
			tmp = q.peek(); // peek() returns the element at the front the container & doesn't delete
			q.remove();  // remove() method of Queue Interface returns and removes the element at the front the container.
		
			if(tmp.left == null) {//As we are inserting breadth wise, we first check if left element is empty
				tmp.left = new Node(key);
				break;
			}
			else {
				q.add(tmp.left); //adding in queue so that at the end queue has elements in level order 
			}
			
			if(tmp.right == null) {
				tmp.right = new Node(key); //insert in right if right is empty
				break;
			}
			else
				q.add(tmp.right);
		}
		
	}
	


	
	public static void main(String args[]) {
	
		//BinaryTreeBasic tree = new BinaryTreeBasic();
		
		/*create root*/
        root = new Node(1); 
  
        /* following is the tree after above statement 
  
              1 
            /   \ 
          null  null     */
  
        root.left = new Node(2); 
        root.right = new Node(3); 
  
        /* 2 and 3 become left and right children of 1 
               1 
             /   \ 
            2      3 
          /    \    /  \ 
        null null null null  */
  
  
        root.left.left = new Node(4); 
        /* 4 becomes left child of 2 
                    1 
                /       \ 
               2          3 
             /   \       /  \ 
            4    12     15  16 
           /   \ 
          null null 
         */
        System.out.println( "Inorder traversal before insertion:"); 

        inOrder(root);
        int key = 12; 
        int key1 = 15;
        int key2 = 16;
        levelOrderInsertion(root, key); 
        levelOrderInsertion(root, key1); 
        levelOrderInsertion(root, key2); 


       
        System.out.println("\nInorder traversal after insertion:"); 
        inOrder(root); 
       
		
	
	}
	}
