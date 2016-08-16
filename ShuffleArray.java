public class ShuffleArray {
 	int[] original;

    public Solution(int[] num) {
    	original = num; 
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    
    	int[] temp = original.clone();

        int index=0;
        Random r = new Random();
        while (index < temp.length-1) {
        	int n = r.nextInt(temp.length-index-1) + index + 1;
        	int t = temp[n]; //swap
        	temp[n] = temp[index];
        	temp[index]=t;
        	index++;
        }
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
