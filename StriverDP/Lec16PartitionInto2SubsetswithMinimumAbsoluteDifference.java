public class Lec16PartitionInto2SubsetswithMinimumAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(minSubsetSumDifference(new int[]{3,9,7,3}, 4));
    }
    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = 0;
        for (int i: arr){
            sum += i;
        }
        return subsetSum(n, sum, arr);
        // Write your code here.
    }
    public static int subsetSum(int n, int k, int[] nums){
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
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k/2; i++){
            if (dp[n][i]){
                min = Math.min(min, Math.abs(k - 2*i));
            }
        }
        return min;
    }
}
