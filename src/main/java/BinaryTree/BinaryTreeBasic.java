package BinaryTree;

/*Binary Tree Properties: https://www.geeksforgeeks.org/binary-tree-set-2-properties/
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
	
	Node root;
	
	public BinaryTreeBasic(int key) {

		this.root = new Node(key);
	}
	
	BinaryTreeBasic(){
		root = null;
	}

	
	public static void main(String args[]) {
	
		BinaryTreeBasic tree = new BinaryTreeBasic();
		
		/*create root*/
        tree.root = new Node(1); 
  
        /* following is the tree after above statement 
  
              1 
            /   \ 
          null  null     */
  
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
  
        /* 2 and 3 become left and right children of 1 
               1 
             /   \ 
            2      3 
          /    \    /  \ 
        null null null null  */
  
  
        tree.root.left.left = new Node(4); 
        /* 4 becomes left child of 2 
                    1 
                /       \ 
               2          3 
             /   \       /  \ 
            4    null  null  null 
           /   \ 
          null null 
         */
		
	
	}
	}
