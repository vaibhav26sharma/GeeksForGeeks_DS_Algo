package BinaryTree;
/*
 * Talking about representation, trees can be represented in two way:
1) Dynamic Node Representation (Linked Representation).
2) Array Representation (Sequential Representation).

We are going to talk about the sequential representation of the trees.
To represent tree using an array, numbering of nodes can start either from 0–(n-1) or 1– n.

       A(0)    
     /   \
    B(1)  C(2)  
  /   \      \
 D(3)  E(4)   F(6) 
OR,
      A(1)    
     /   \
    B(2)  C(3)  
  /   \      \
 D(4)  E(5)   F(7)  
 
For first case(0—n-1),
if (say)father=p;
then left_son=(2*p)+1;
and right_son=(2*p)+2;

For second case(1—n),
if (say)father=p;
then left_son=(2*p);
and right_son=(2*p)+1;
where father,left_son and right_son are the values of indices of the array.


 * */

public class BinaryTree_ArrayImpl {

	static int root =0;
    static String[] str = new String[10]; 

    /*create root*/

	public void root(String key) {
		str[0] = key;
	}
	
    /*create left son of root*/
	void set_LeftChild(String key, int r) {
		// Per the comment at top left child has to be at 2P+1
		int t = (r * 2) + 1;

		if (str[r] == null)
			System.out.println("Cannot set left child at" + t + ", no parent found"+" "+ "Params sent"+": "+key+" ,"+r);

		else {
			str[t] = key;
		}

	}
	
    /*create right son of root*/
	void set_RightChild(String key, int r) {
		// Per the comment at top left child has to be at 2P+2
		int t = (r * 2) + 2;

		if (str[r] == null)
			System.out.println("Cannot set right child at" + t + ", no parent found"+" "+ "Params sent"+": "+key+" ,"+r);

		else {
			str[t] = key;
		}

	}
	
	
	void print_Tree() {
		
		for(int i =0; i < str.length ; i++) {
		if(str[i]!=null)
			System.out.print(str[i]);
		else
			System.out.print("-");
			
		}
	}
	
	public static void main(String[] args) 
    { 
		BinaryTree_ArrayImpl obj = new BinaryTree_ArrayImpl(); 
        obj.root("A"); 
       //obj.set_LeftChild("B", 0); 
        obj.set_RightChild("C", 0); 
        obj.set_LeftChild("D", 1); 
        obj.set_RightChild("E", 1); 
        obj.set_LeftChild("F", 2); //This is child of C bcz as per right child formula 2p+2, C will land at index =2 
        obj.print_Tree(); 
    } 
	
	

} 

