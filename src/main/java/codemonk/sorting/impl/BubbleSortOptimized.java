package codemonk.sorting.impl;

/*
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
Example:
First Pass:
( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

Second Pass:
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

Third Pass:
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
*/


public class BubbleSortOptimized {
	// arr-> Array to be sorted ; n -> size of the array
	
	int[] bubbleSort(int arr[], int n) {
		
		boolean swapped = false;
		
		//O(n2)
		
		for(int i =0; i < n-1; i ++) {//Going over the full array giving each element the chance to compare against all others
			
			
			for(int j = 0 ; j< n -i-1 ; j++) {// n-i-1 just to make sure that the elements that are largest and moved to right most corners and not compared in next pass
			
				
				if(arr[j] > arr[j+1]) { //swap if left element > right element
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					swapped = true;
					
				}
				
			}
			
			//****OPTIMIZER****
			//Optimizing using below code by breaking out of the loop is swapped still false bcz that means not even one swap happened over one full pass
			//and that is because the array is sorted
			if(swapped == false){
				break;
			}
		}
		
		return arr;
		
		
		
	}
	
	
	public static void main(String args[]) {
		
		int arr[] = {4,6,1,0,55,23,14,77,8};
		
		arr = new BubbleSort().bubbleSort(arr, arr.length);
		
		GenericMethodsImpl.printArray(arr);
		

	}
	
	
	

}
