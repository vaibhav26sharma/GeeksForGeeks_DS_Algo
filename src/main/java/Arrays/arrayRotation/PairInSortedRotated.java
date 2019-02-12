package Arrays.arrayRotation;

/*Problem page: https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/*/

/*Algorithm:
 * 
 * Find Pivot(element next to which is smaller than pivot element). now in a sorted array pivot will be the largest and next to it will be the smallest
 * 
 * lar = pivot; small =pivot+1;
 * 
 * for(int i =0; i< A.length; i++){
 * 		
 * 	if((A[lar] + a[small]) == sum) return 1
 * 
 *  else if((A[lar] + a[small]) < sum) -> small++    (we will increase small index bcz we need to increase the sum on left side as it is smaller than the sum we want and on moving right of small, number will increase)
 *  
 *  else ((A[lar] + a[small]) > sum) -> lar--  (we will decrease lar index bcz we need to reduce sum on left side as it is greater than the sum we want and on moving left of lar, number will decrease)
 * 	
 * 		} * */

public class PairInSortedRotated {

	boolean isPairForSum(int[] arr, int sum) {

		int large = findPivot(arr, arr.length);

		int small = (large + 1) % arr.length;

		while (large != small) {

			if ((arr[large] + arr[small]) == sum)
				return true;

			else if ((arr[large] + arr[small]) < sum)
				// indexes are incremented and decremented in rotational manner using modular
				// arithmetic
				small = (small + 1) % arr.length;

			else
				// indexes are incremented and decremented in rotational manner using modular
				// arithmetic
				large = (arr.length + large - 1) % arr.length;

		}

		return false;
	}

	static int findPivot(int[] arr, int n) {

		int pivot = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] > arr[i + 1]) {
				pivot = i;
				break;

			}
		}

		return pivot;
	}

	public static void main(String[] args) {
		int arr[] = { 11, 15, 6, 8, 9, 10 };
		int sum = 16;
		PairInSortedRotated pisr = new PairInSortedRotated();

		if (pisr.isPairForSum(arr, sum))
			System.out.print("Array has two elements" + " with sum 16");
		else
			System.out.print("Array doesn't have two" + " elements with sum 16 ");
	}

}
