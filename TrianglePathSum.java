/*
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/

public class TrianglePathSum {

    public int minimumTotal(List<List<Integer>> triangle) {
    	int n = triangle.size();
    	int[][] memory = new int[n][n];
        aux(triangle, 0, 0, memory);
        return memory[0][0];
    }

    public void aux(List<List<Integer>> triangle, int row, int col, int[][] memory) {
    	//calculate the minimum path with top at row - col, store in memory
    	if (row >= triangle.size() || 
    		col >= triangle.get(row).size() || memory[row][col] > 0) return;
    	
    	aux(triangle, row+1, col, memory);
    	aux(triangle, row+1, col+1, memory);
    	if (row +1 < triangle.size() && col + 1 < triangle.get(row+1).size()) {
    		memory[row][col] = Math.min(memory[row+1][col], memory[row+1][col+1]) + triangle.get(row).get(col);
    	}
    	else {
    		memory[row][col] = triangle.get(row).get(col);
    	}
    	return;
    }
}