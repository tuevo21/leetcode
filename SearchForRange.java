/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

*/

public class SearchForRange {
	
	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = binarySearchStart(nums, target);
		result[1] = (result[0] == -1) ? -1 : binarySearchEnd(nums, target);
		return result;
	}

	public static int binarySearchStart(int[] nums, int target) {
		int low = 0, high = nums.length - 1, result = -1;
		while (low <= high) {
			int mid = (low+high)/2;
			if (nums[mid] == target) {
				result=mid; high = mid-1;
			}
			else if (nums[mid] > target) {
				high = mid-1;
			}
			else if (nums[mid] < target) {
				low = mid+1;
			}
		}
		return result;
	}

	public static int binarySearchEnd(int[] nums, int target) {
		int low = 0, high = nums.length - 1, result = -1;
		while (low <= high) {
			int mid = (low + high)/2;
			if (nums[mid] == target) {
				result = mid; low = mid+1;
			}
			else if (nums[mid] > target) {
				high = mid-1;
			}
			else if (nums[mid] < target) {
				low = mid+1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		//test helper function
		int[] arr1 = {1, 2, 2, 2, 2, 2, 3};
		int[] arr2 = {1, 1, 3, 4, 5, 5, 6};
		int[] arr3 = {1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4};
		int[] arr4 = {1, 1, 1, 1, 1, 1, 2, 2, 3};

		System.out.println(binarySearchStart(arr1, 2));
		System.out.println(binarySearchStart(arr2, 2));
		System.out.println(binarySearchStart(arr3, 2));
		System.out.println(binarySearchStart(arr4, 2));	

		System.out.println(binarySearchEnd(arr1, 2));
		System.out.println(binarySearchEnd(arr2, 2));
		System.out.println(binarySearchEnd(arr3, 2));
		System.out.println(binarySearchEnd(arr4, 2));				
	}

}