public class Lec21TargetSum {
    public static void main(String[] args) {
        System.out.println(targetSum(3, 2, new int[]{1,2,3}));
    }
    public static int targetSum(int n, int target, int[] arr) {
        // S1 -  S2 = K
        // S1 + S2 = sum(arr)
        // S2 = (sum(arr)-k)/2
        // Count Subsets with this size
        int sum = 0;
        for (int i: arr){
            sum += i;
        }
        if ((sum - target) % 2 != 0){
            return 0;
        }
        if (sum < target){
            return 0;
        }
//        int[][] memArray = new int[n][(sum-target)/2 + 1];
//        for (int[] ls: memArray){
//            for (int i = 0; i < ls.length; i++){
//                ls[i] = -1;
//            }
//        }
//        return solveMemoized(n, (sum-target)/2, arr, 0, memArray);
        return solveDP(n, (sum-target)/2, arr);
    }
    static int solveRecursive(int n, int target, int[] arr, int i){
        if (i == n-1){
            if (arr[i] == target || target == 0){
                return 1;
            }
            return 0;
        }
        int notTake = solveRecursive(n, target, arr, i+1);
        int Take = 0;
        if (target >= arr[i]){
            Take = solveRecursive(n, target-arr[i], arr, i+1);
        }
        return Take + notTake;
    }
    static int solveMemoized(int n, int target, int[] arr, int i, int[][] memArray){
        if (i == n-1){
            if (arr[i] == target || target == 0){
                return 1;
            }
            return 0;
        }
        if (memArray[i][target] != -1){
            return memArray[i][target];
        }
        int notTake = solveMemoized(n, target, arr, i+1, memArray);
        int Take = 0;
        if (target >= arr[i]){
            Take = solveMemoized(n, target-arr[i], arr, i+1, memArray);
        }
        return memArray[i][target] = Take + notTake;
    }
    static int solveDP(int n, int target, int[] arr){
        int[][] dp = new int[n][target+1];
        for (int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        if (arr[0] <= target){
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= target; j++){
                int notTake = dp[i-1][j];
                int Take = 0;
                if (j >= arr[i]){
                    Take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = Take + notTake;
            }
        }
        return dp[n-1][target];
    }
}
