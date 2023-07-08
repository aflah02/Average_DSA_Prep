public class Lec18CountPartitionsWithGivenDifference {
    public static void main(String[] args) {
        System.out.println(countPartitions(5, 1, new int[]{3,2,2,5,1}));
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // S1 - S2 = d
        // S1 + S2 = sum(arr)
        // S1 - (sum(arr)-S1) = d
        // S1 = (d + sum(arr))/2
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        if (sum-d <= 0){
            return 0;
        }
        if ((sum - d) % 2 != 0){
            return 0;
        }
        int[][] memArray = new int[n][((sum-d)/2)+1];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < ((sum-d)/2)+1; j++){
                memArray[i][j] = -1;
            }
        }
        return solveMemoized(arr, n, 0, (sum-d)/2, memArray);
//        return solveRecursive(arr, n, 0, (sum-d)/2);
//        return (solveDP(n,(sum+d)/2, arr);
    }
    static int solveRecursive(int[] arr, int n, int i, int target){
        if (i == n-1){
            if (target == 0 && arr[n-1] == 0){
                return 2;
            }
            if (target == 0 || arr[n-1] == target){
                return 1;
            }
            return 0;
        }
        int take = 0;
        if (arr[i] <= target){
            take = solveRecursive(arr, n, i+1, target-arr[i]);
        }
        int notTake = solveRecursive(arr, n, i+1, target);
        return (int) ((take + notTake)%(Math.pow(10,9)+7));
    }
    static int solveMemoized(int[] arr, int n, int i, int target, int[][] memArray){
        if (i == n-1){
            if (target == 0 && arr[n-1] == 0){
                return 2;
            }
            if (target == 0 || arr[n-1] == target){
                return 1;
            }
            return 0;
        }
        if (memArray[i][target] != -1){
            return memArray[i][target];
        }
        int take = 0;
        if (arr[i] <= target){
            take = solveMemoized(arr, n, i+1, target-arr[i], memArray);
        }
        int notTake = solveMemoized(arr, n, i+1, target, memArray);
        return memArray[i][target] = (int) ((take + notTake)%(Math.pow(10,9)+7));
    }
    static int solveDP(int n, int target, int[] arr){
        int[][] dp = new int[n][target+1];
        if (arr[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
        }
        if (arr[0] != 0 && arr[0] <= target){
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= target; j++){
                int notTake = dp[i-1][j];
                int Take = 0;
                if (arr[i] <= j){
                    Take = dp[i-1][j-arr[i]];
                }
                dp[i][j] =(int) ((Take + notTake)%(Math.pow(10,9)+7));
            }
        }
        return dp[n-1][target];
    }
}
