public class Lec15PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{4,3,2,1}));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums){
            sum += i;
        }
        if (sum % 2 != 0){
            return false;
        }
        return subsetSum(nums.length, sum/2, nums);
    }
    public static boolean subsetSum(int n, int k, int[] nums){
        boolean[][] dp = new boolean[n+1][k+1];
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < k+1; j++){
                if (i == 0){
                    dp[i][j] = false;
                }
                if (j == 0){
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= k; j++){
                boolean notTake = dp[i-1][j];
                boolean Take = false;
                if (nums[i-1] <= j){
                    Take = dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = Take || notTake;
            }
        }
        return dp[n][k];
    }
}
