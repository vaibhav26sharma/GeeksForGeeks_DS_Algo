package gkg_practice.sorting.impl;

/*

The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
*/


public class SelectionSort {
	
	
	int[] selectionSort(int arr[], int n) {
		
		int min; //variable to set min element in each pass and move it to sorted array
		
		
		//O(n2)
		for( int i =0; i< n-1 ; i++) { 
			
			min = i;
			
			for(int j= i+1; j <n; j++) { //j=i+1 bcz we are skipping the left side of numbers which are least and sorted already

				
				if(arr[min] > arr[j]) {
					
					min = j;
				}
			}
			
			//Swapping
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min]= tmp;
			
		}
		
		return arr;
		
		
		
	}
	
	public static void main(String args[]) {
		
		int arr[] = {4,6,1,0,55,23,14,77,8};
		
		arr = new SelectionSort().selectionSort(arr, arr.length);
		
		GenericMethodsImpl.printArray(arr);
		

	}

}
