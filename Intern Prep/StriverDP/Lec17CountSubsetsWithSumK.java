public class Lec17CountSubsetsWithSumK {
    public static void main(String[] args) {
        System.out.println(findWays(new int[]{16,13,16,6}, 16));
    }
    public static int findWays(int num[], int tar) {
//        int[][] memArray = new int[num.length+1][tar+1];
//        for (int i = 0; i < memArray.length; i++){
//            for (int j = 0; j < memArray[0].length; j++){
//                memArray[i][j] = -1;
//            }
//        }
//        return solveMemoized(num, tar, 0, num.length, memArray);
        return solveDP(num, tar);
    }

    static int solveRecursive(int num[], int tar, int i, int n){
        if (i == n-1){
            if (num[i] == tar || tar == 0){
                return 1;
            }
            return 0;
        }
        return solveRecursive(num, tar-num[i], i+1, n) + solveRecursive(num, tar, i+1, n);
    }
    static int solveMemoized(int num[], int tar, int i, int n, int[][] memArray){
        if (i == n-1){
            if (num[i] == tar || tar == 0){
                return 1;
            }
            return 0;
        }
        if (memArray[i][tar] != -1){
            return memArray[i][tar];
        }
        int take = 0;
        if (tar-num[i] >= 0){
            take = solveMemoized(num, tar-num[i], i+1, n, memArray);
        }
        return memArray[i][tar] =  take + solveMemoized(num, tar, i+1, n, memArray);
    }
    static int solveDP(int[] nums, int target){
        int[][] dp = new int[nums.length][target+1];
        for (int i = 0; i < nums.length; i++){
            dp[i][0] = 1;
        }
        if (nums[0] <= target){
            dp[0][nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < target+1; j++){
                int notTake = dp[i-1][j];
                int Take = 0;
                if (j-nums[i] >= 0){
                    Take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = Take + notTake;
            }
        }
        for (int[] b: dp){
            for (int b2: b){
                System.out.print(b2 + " ");
            }
            System.out.println();
        }
        return dp[dp.length-1][target];
    }
}
