package Arrays.arrayRotation;

/*Problem page: https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
 * */
public class MaxSumRotation {

	// ******My Trivial Solution *******
	// Idea is to keep on rotating the array to left n times and storing the maximum
	// Sum at any point of time
	// Complexity-> O(n2)

	// Helper function to rotate Array towards left by 1
	static int[] rotateLeftByOne(int[] arr, int n) {
		int first = arr[0];

		for (int i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1]; // moving or rotating elements towards left

		}

		arr[n - 1] = first;
		return arr;

	}

	int maxSum(int arr[], int n) {

		int max_sum = 0;

		for (int m = 0; m < n; m++) { // Outer loop to rotate n-1 times to find largest sum
			int tmp_sum = 0;
			for (int k = 0; k < n; k++) {// Inner loop to find sum of current array sum+= i*arr[i]
				tmp_sum += k * arr[k];
			}

			if (tmp_sum > max_sum)
				max_sum = tmp_sum;

			arr = rotateLeftByOne(arr, n);

		}

		return max_sum;

	}

	public static void main(String args[]) {
		int[] arr = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		MaxSumRotation msr = new MaxSumRotation();
		System.out.println(msr.maxSum(arr, arr.length));

	}

}
