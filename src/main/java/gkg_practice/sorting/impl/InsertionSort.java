package gkg_practice.sorting.impl;

/*
It iterates the array by growing the sorted list behind it at each iteration. 
It checks the current element with the largest value in the sorted list. 
If the current element is larger, then it leaves the element at its place and 
moves to the next element else it finds its correct position in the sorted list and moves it to that position. 
It is done by shifting all the elements which are larger than the current element to one position ahead.


12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 5 (Size of input array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
5, 6, 11, 12, 13
*/

public class InsertionSort {
	
	
	
	int[] insertionSort(int arr[], int n) {
		
		//O(n2)
		for(int i=1; i < n ;  i++) {
			
			int key = arr[i];  /*storing current element whose left side is checked for its 
            correct position .*/
			
			int j = i-1;
			
			while (j>=0 && arr[j] > key) {
				
				arr[j+1] = arr[j]; //Moving the number greater to right
				j = j-1;
				
			}
			arr[j+1] = key; //Moving smaller to it's correct position
			
		}
		
		
		return arr;
		
		
		
	}
	
	
	
	public static void main(String args[]) {
		
		int arr[] = {4,6,1,0,55,23,14,77,8};
		
		arr = new InsertionSort().insertionSort(arr, arr.length);
		
		GenericMethodsImpl.printArray(arr);	}

}
