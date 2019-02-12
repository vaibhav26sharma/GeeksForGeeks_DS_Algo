package Arrays.arrayRotation;

public class ArrayCyclicRotationBy1 {

	void cyclicRotateBy1Clockwise(int arr[]) {
		// Backing up the last element because rotating clockwise i.e. towards right
		int tmp = arr[arr.length - 1];

		for (int i = arr.length - 1; i > 0; i--) {

			arr[i] = arr[i - 1];
		}
		// Putting the backed up last element to first place per the one position cyclic
		// rotation
		arr[0] = tmp;

	}

	/* utility function to print an array */
	void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };

		ArrayCyclicRotationBy1 m = new ArrayCyclicRotationBy1();
		m.cyclicRotateBy1Clockwise(arr);
		m.printArray(arr, arr.length);

	}
}
