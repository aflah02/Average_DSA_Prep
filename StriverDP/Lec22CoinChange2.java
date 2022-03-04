public class Lec22CoinChange2 {
    public static void main(String[] args) {
        System.out.println(countWaysToMakeChange(new int[]{1,2}, 4));
    }
    public static long countWaysToMakeChange(int[] denominations, int value){
//        return solveRecursive(denominations, value, 0, denominations.length);
//        long[][] memArray = new long[denominations.length][value+1];
//        for (long[] ls: memArray){
//            for (int i = 0; i < ls.length; i++){
//                ls[i] = -1;
//            }
//        }
//        return solveMemoized(denominations, value, 0, denominations.length, memArray);
        return solveDP(denominations, value, denominations.length);
    }
    static long solveRecursive(int[] denominations, int value, int i, int n){
        if (i == n-1){
            if (value % denominations[i] == 0){
                return 1;
            }
            return 0;
        }
        long notTake = solveRecursive(denominations, value, i+1, n);
        long Take = 0;
        if (value >= denominations[i]){
            Take = solveRecursive(denominations, value-denominations[i], i, n);
        }
        return Take + notTake;
    }
    static long solveMemoized(int[] denominations, int value, int i, int n, long[][] memArray){
        if (i == n-1){
            if (value % denominations[i] == 0){
                return 1;
            }
            return 0;
        }
        if (memArray[i][value] != -1){
            return memArray[i][value];
        }
        long notTake = solveMemoized(denominations, value, i+1, n , memArray);
        long Take = 0;
        if (value >= denominations[i]){
            Take = solveMemoized(denominations, value-denominations[i], i, n, memArray);
        }
        return memArray[i][value] = Take + notTake;
    }
    static long solveDP(int[] denominations, int value, int n){
        long[][] dp = new long[n][value+1];
        for (int i = 0; i < value+1; i++){
            if (i % denominations[0] == 0){
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= value; j++){
                long notTake = dp[i-1][j];
                long Take = 0;
                if (j >= denominations[i]){
                    Take = dp[i][j-denominations[i]];
                }
                dp[i][j] = Take + notTake;
            }
        }
        return dp[n-1][value];
    }
}
