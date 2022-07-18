import java.util.Arrays;

public class Lec48BurstBalloons {
    public static void main(String[] args) {

    }
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[newNums.length-1] = 1;
        System.arraycopy(nums, 0, newNums, 1, newNums.length - 1 - 1);
//        return solveRecursive(nums, 1, nums.length);
//         int[][] memArray = new int[nums.length+1][nums.length+1];
//         for (int[] ls: memArray){
//             Arrays.fill(ls, -1);
//         }
//        return solveMemoized(nums, 1, nums.length, memArray);
        return solveDP(newNums, nums.length);
    }
    static int solveRecursive(int[] nums, int i, int j){
        if (i > j){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++){
            int cost = nums[i-1] * nums[ind] * nums[j+1] + solveRecursive(nums, i, ind-1) + solveRecursive(nums, ind+1, j);
            max = Math.max(cost, max);
        }
        return max;
    }
    static int solveMemoized(int[] nums, int i, int j, int[][] memArray){
        if (i > j){
            return 0;
        }
        if (memArray[i][j] != -1){
            return memArray[i][j];
        }
        int max = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++){
            int cost = nums[i-1] * nums[ind] * nums[j+1] + solveMemoized(nums, i, ind-1, memArray) + solveMemoized(nums, ind+1, j, memArray);
            max = Math.max(cost, max);
        }
        return memArray[i][j] = max;
    }
    static int solveDP(int[] nums, int n){
        int[][] dpArray = new int[nums.length+2][nums.length+2];
        for (int i = n; i >= 1; i--){
            for (int j = 1; j <= n; j++){
                if (i > j){
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++){
                    int cost = nums[i-1] * nums[ind] * nums[j+1] + dpArray[i][ind-1] + dpArray[ind+1][j];
                    max = Math.max(cost, max);
                }
                dpArray[i][j] = max;
            }
        }
        return dpArray[1][n];
    }
}
