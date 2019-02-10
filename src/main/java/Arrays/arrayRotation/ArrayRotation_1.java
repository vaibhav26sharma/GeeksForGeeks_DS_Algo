package Arrays.arrayRotation;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class ArrayRotation_1 {

	// d-> rotate by d elements
	public void left_Rotate1(int arr[], int d) {

		// Method 1 - Trivial
		int tmp[] = new int[d];
		int j = d;
		int z = 0;
		// Temp array containing no of ele from left by which array
		// is to be rotated
		for (int m = 0; m < d; m++)
			tmp[m] = arr[m];

		for (int i = 0; i < arr.length - d; i++) {

			arr[i] = arr[j];
			j++;
		}

		for (int mm = arr.length - d; mm < arr.length; mm++) {
			arr[mm] = tmp[z];
			z++;
		}

	}

	// Method 2 - (Rotating Array by 1)

	void left_Rotate2(int arr[], int d) {

		for (int i = 0; i < d; i++)
			leftRotateByOne(arr);

	}

	void leftRotateByOne(int arr[]) {

		int i;
		int tmp = arr[0];

		for (i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = tmp;// now when i is pointing to last index of array, insert tmp to that index
	}

	// Method 3 - The Reversal Algorithm
	/*Reverse array into 3 phases: First from 0 to d-1 -> next d to n-1 -> reverse
	the whole array*/

	void left_Rotate3(int arr[], int d) {

		reverse(arr, 0, d - 1);
		reverse(arr, d, arr.length - 1);
		reverse(arr, 0, arr.length - 1);

	}

	void reverse(int arr[], int start, int end) {
		int tmp = 0;

		while (start < end) {
			tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

	/* utility function to print an array */
	void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		ArrayRotation_1 aar0 = new ArrayRotation_1();
		System.out.println("*** Using Method 1 ***");

		aar0.left_Rotate1(arr, 2);
		aar0.printArray(arr, arr.length);

		System.out.println("");

		System.out.println("*** Using Method 2 ***");
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8 };

		ArrayRotation_1 aar = new ArrayRotation_1();
		aar.left_Rotate2(arr1, 2);
		aar.printArray(arr1, arr1.length);

		System.out.println("");

		System.out.println("*** Using Method 3 ***");
		int[] arr3 = { 1, 2, 3, 4, 5, 6, 7, 8 };

		ArrayRotation_1 aar2 = new ArrayRotation_1();
		aar2.left_Rotate2(arr3, 2);
		aar2.printArray(arr3, arr3.length);

	}

}
