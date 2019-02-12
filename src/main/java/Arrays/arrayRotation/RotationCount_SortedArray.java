package Arrays.arrayRotation;

/*Problem link: https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/*/

public class RotationCount_SortedArray {
	
	//My Method-> Per my understanding we first find the lowest element, the number of rotations is equal to index of minimum element
	//A trick for finding the lowest element in array is just find the pivot(i) and element(i+1) is the lowest.
	
	int rotationCount(int[] arr, int n) {
		int pivot_index = 0;
		int minElement_index = 0;

		//O(n) -> LinearSearch
		for (int i = 0; i < n; i++) {

			if (arr[i] > arr[i + 1]) {
				minElement_index = i + 1;
				break;
			}

		}

		return minElement_index;
	}
	
	 public static void main (String[] args)  
	    { 
	        int arr[] = {15, 18, 2, 3, 6, 12}; 
	        int n = arr.length; 
	        RotationCount_SortedArray rc = new RotationCount_SortedArray();
	      
	        System.out.println(rc.rotationCount(arr, n)); 
	    } 

}
