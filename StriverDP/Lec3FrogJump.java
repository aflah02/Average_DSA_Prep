public class Lec3FrogJump {
    // https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
    public static void main(String[] args) {
        int n = 6;
        int[] heights = new int[]{4, 8, 3, 10, 4, 4 };
        System.out.println(frogJump(n, heights));
    }
    public static int frogJump(int n, int[] heights) {
        int[] memArray = new int[n+1];
        for (int i = 0; i < n+1; i++){
            memArray[i] = 0;
        }
//        return solveSimpleRecursion(n-1, heights);
//        return solveRecursionAndMemoization(n-1, heights, memArray);
//        return solveDP(n-1, heights);
        return solveDPConstantSpace(n, heights);
    }

    public static int solveSimpleRecursion(int n, int[] heights){
        if (n == 0){
            return 0;
        }
        int j2 = Integer.MAX_VALUE;
        int j1 = solveSimpleRecursion(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        if (n > 1){
            j2 = solveSimpleRecursion(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        }
        return Math.min(j1, j2);
    }
    public static int solveRecursionAndMemoization(int n, int[] heights, int[] memArray){
        if (n == 0){
            return 0;
        }
        if (memArray[n] != 0){
            return memArray[n];
        }
        int j2 = Integer.MAX_VALUE;
        int j1 = solveRecursionAndMemoization(n-1, heights, memArray) + Math.abs(heights[n] - heights[n-1]);
        if (n > 1){
            j2 = solveRecursionAndMemoization(n-2, heights, memArray) + Math.abs(heights[n] - heights[n-2]);
        }
        return memArray[n] = Math.min(j1, j2);
    }
    public static int solveDP(int n, int[] heights){
        int[] dpArray = new int[n+1];
        dpArray[0] = 0;
        for (int i = 1; i < n; i++){
            int j1 = dpArray[i-1] + Math.abs(heights[i]-heights[i-1]);
            int j2 = Integer.MAX_VALUE;
            if (i > 1){
                j2 = dpArray[i-2] + Math.abs(heights[i]-heights[i-2]);
            }
            dpArray[i] = Math.min(j1, j2);
        }
        return dpArray[n-1];
    }
    public static int solveDPConstantSpace(int n, int[] heights){
        int prev1 = 0, prev2 = 0;
        for (int i = 1; i < n; i++){
            int fs = prev1 + Math.abs(heights[i-1] - heights[i]);
            int ss = Integer.MAX_VALUE;
            if (i > 1){
                ss = prev2 + Math.abs(heights[i-2] - heights[i]);
            }
            int curr = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
