package Arrays.arrayRotation;

/*Problem page: https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array*/

//Here we consider that a ascending order sorted array was rotated along a pivot point which we dont know
//How to identify Pivot? -> The element whose next element is smaller is pivot. {3,4,5,1,2} -> 5 is pivot

public class ArraySearch_Rotated {

	int search(int arr[], int key, int n) {

		int pivot_index = 0;
		int tmp = 0;
		int final_index = -1;

		// Find the pivot index. Index where next element is smaller than current is
		// pivot
		for (int i = 0; i < n - 1; i++) {

			if (arr[i] > arr[i + 1]) {
				pivot_index = i;
				break;
			}

		}

		// Divide main array into two i.e. start -> pivot_index-1 and pivot_index -> n-1

		int[] arrL = new int[pivot_index];
		int[] arrR = new int[n - pivot_index];

		// Creating the sub-indexes
		for (int j = 0; j <= pivot_index - 1; j++)
			arrL[j] = arr[j];

		for (int m = pivot_index; m <= n - 1; m++) {
			arrR[tmp] = arr[m];
			tmp++;

		}

		// If key is >= zeroth ele of left element then seach in left else search in
		// right array
		if (key >= arrL[0])
			final_index = binarySearch(arr, 0, pivot_index - 1, key);
		else
			final_index = binarySearch(arr, pivot_index, n - 1, key);
		// return binarySearch(arr, 0, n-pivot_index-1, key);

		return final_index;
	}

	int binarySearch(int[] arr, int start, int end, int key) {

		int mid = (start + end) / 2;
		if (key == arr[mid]) {
			return mid;
		}

		if (key < arr[mid]) {
			return binarySearch(arr, start, mid - 1, key);
		}

		return binarySearch(arr, mid + 1, end, key);

	}

	public static void main(String args[]) {
		// Let us search 3 in below array
		// int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int arr1[] = { 3, 4, 5, 6, 1, 2 };
		int n = arr1.length;
		int key = 3;

		ArraySearch_Rotated asr = new ArraySearch_Rotated();
		System.out.println("Index of the element is : " + asr.search(arr1, key, n));
	}

}
