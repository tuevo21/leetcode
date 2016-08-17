public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
    	if (num < 0) return false;
 		int i = binarySearch(0, num, num);       
 		return (i*i == num);
    }

    public static int binarySearch(int start, int end, int val) {
    	if (start > end) return end;
    	int mid = (start+end)/2;
    	if (mid * mid > val) return binarySearch(start, mid-1, val);
    	else if (mid * mid < val) return binarySearch(mid+1, end, val);
    	return mid;
    }

    public static void main(String[] args) {
    	int[] arr = {0, 1, 2, 4, 5, 9, 15, 16, 17, 100, 125};
    	for (int val : arr) {
    		System.out.println(val + " " + isPerfectSquare(val));
    	}
    }
}