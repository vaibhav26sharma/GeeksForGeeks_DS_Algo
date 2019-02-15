package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*Problem link: https://www.geeksforgeeks.org/deletion-binary-tree/*/
/*Deleting by shrinking the tree as explained in : https://www.geeksforgeeks.org/deletion-binary-tree/*/

/*tree, delete a node from it by making sure that tree shrinks 
 * from the bottom (i.e. the deleted node is replaced by bottom most and rightmost node).
 * 
 * Delete 10 in below tree
   10
 /    \         
20     30
Output :    
   30
 /             
20     


Delete 20 in below tree
   10
 /    \         
20     30
        \
        40
Output :    
   10
 /   \             
40    30   

1-> Find rightmost bottom most node and the node to be deleted
2-> replace node to be deleted with the bottom most rightmost node 
3-> Delete bottom most right most node from its original position


*/
public class BinaryTreeBasicShrinkDeletion {
	

	static Node root;
	
	public BinaryTreeBasicShrinkDeletion(int key) {

		this.root = new Node(key);
	}
	
	BinaryTreeBasicShrinkDeletion(){
		root = null;
	}
	
	 /* Inorder traversal of a binary tree*/
    static void inorder(Node temp) {
        if(temp==null){
            return;
        }
        inorder(temp.left);
        System.out.print(temp.key+" ");
        inorder(temp.right);
    }
	
	static void deletion(Node node,int key){
        Node deleteNode=null;
        Node tmp=null; //by end of below while loop this will represent rightmost bottom most element of the tree
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(node);
        /*Below method traverses the tree in breadth first manner i.e. breadth wise or level wise as a result of which 
         * by the end when q becomes empty, the tmp variable will have the rightmost bottom most element of the tree*/
        while(!queue.isEmpty()){
            tmp=queue.poll(); //poll() returns and removes the head of queue
            if(tmp.key==key){
                deleteNode=tmp;
            }
            if(tmp.left!=null){
                queue.add(tmp.left);
            }
            if(tmp.right!=null){
                queue.add(tmp.right);
            }
        }
        
        
        int replaceWith = tmp.key; // cz tmp now has rightmost bottom most element of the tree which will replace the key to be deleted
        if(replaceWith!=key) { //if rightmost bottom most element is not the one to be deleted
        	deleteDeepest(node,tmp);
        	deleteNode.key = replaceWith;
        }
        else {
        	deleteDeepest(node,tmp);//if rightmost bottom most element is  the one to be deleted, then simply delete it
        }
        
}
	
	static void deleteDeepest(Node r, Node deleteNode) {

		Node tmp = null;
		Queue<Node> q = new LinkedList<Node>();
		q.add(r);

		while (!q.isEmpty()) {
			tmp = q.poll();

			if (tmp.right != null) {
				if (tmp.right.key == deleteNode.key) {
					tmp.right = null;
				return;
				}
			 else {
				q.add(tmp.right);
			}
			}
			
			if(tmp.left !=null) {
				if(tmp.left.key == deleteNode.key) {
					tmp.left = null;
					return;
				}
				else {
					q.add(tmp.left);
				}
			}
		}

	}
	
	 public static void main(String[] args) 
	    {     
	        root = new Node(10); 
	        root.left = new Node(11); 
	        root.left.left = new Node(7); 
	        root.left.right=new Node(12);
	        root.right = new Node(9); 
	        root.right.left = new Node(15); 
	        root.right.right = new Node(8); 
	       
	        System.out.println( "Inorder traversal before deletion :\n"); 
	        inorder(root); 
	       
	        int key = 11; 
	        deletion(root, key); 
	       
	        System.out.print("\nInorder traversal after deletion :\n"); 
	        inorder(root); 
	    } 
	
}
