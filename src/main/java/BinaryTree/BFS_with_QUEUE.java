package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*Level Order Traversal OR or Breadth First Search
 * 
 *                      10        ------> Level 1
 *                    /    \
 *                   11      9    ------> Level 2
 *                  /       /  \
 *                 7       15   8 -------> Level 3
 * 
 * Level Order Traversal -> Root - Left - Right
 * 
 * i.e. 10 11 9 7 15 8
 * 
 * */


/*
 * Algorithm using queue:
 * printLevelorder(tree)
1) Create an empty queue q
2) temp_node = root 
3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children (first left then right children) to q
    c) Dequeue a node from q and assign it’s value to temp_node
 * */

public class BFS_with_QUEUE {

	static void breadthFirstTraversal(Node root) {

		Node tmp = null;

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			tmp = q.poll();

			System.out.println(tmp.key);

			if (tmp.left != null)
				q.add(tmp.left);

			if (tmp.right != null)
				q.add(tmp.right);

		}

	}
	
	
	public static void main(String args[]) {
		Node root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.left.right=new Node(12);
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8); 
        
        breadthFirstTraversal(root);
	}

}
