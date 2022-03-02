public class Lec20MinimumCoins {
    public static void main(String[] args) {
        System.out.println(minimumElements(new int[]{2,1}, 11));
    }
    public static int minimumElements(int weights[], int x) {
        int n = weights.length;
        int[] val = new int[n];
        for (int i = 0; i < n; i++){
            val[i] = 1;
        }
        int[][] memArray = new int[n][x+1];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < x+1; j++){
                memArray[i][j] = -1;
            }
        }
//        int ans = solveMemoized(weights, val, n, 0, x, memArray);
//        int ans = solveRecursive(weights, val, n,0, x);
        int ans = solveDP(weights, val, n, x);
        if (ans >= 10000000){
            return -1;
        }
        return ans;
    }
    static int solveRecursive(int[] weight, int[] value, int n, int i, int maxWeight){
        if (i == n-1){
            if (maxWeight % weight[i] == 0){
                return maxWeight/weight[i];
            }
            return 10000000;
        }
        int notTake = solveRecursive(weight, value, n, i+1, maxWeight);
        int TakeandStay = 10000000;
        if (weight[i] <= maxWeight){
            TakeandStay = value[i] + solveRecursive(weight, value, n, i, maxWeight - weight[i]);
        }
        return Math.min(notTake, TakeandStay);
    }
    static int solveMemoized(int[] weight, int[] value, int n, int i, int maxWeight, int[][] memArray){
        if (i == n-1){
            if (maxWeight % weight[i] == 0){
                return maxWeight/weight[i];
            }
            return 10000000;
        }
        if (memArray[i][maxWeight] != -1){
            return memArray[i][maxWeight];
        }
        int notTake = solveMemoized(weight, value, n, i+1, maxWeight, memArray);
        int TakeandStay = 10000000;
        if (weight[i] <= maxWeight){
            TakeandStay = value[i] + solveMemoized(weight, value, n, i, maxWeight - weight[i], memArray);
        }
        return memArray[i][maxWeight] = Math.min(notTake, TakeandStay);
    }
    static int solveDP(int[] weight, int[] value, int n, int maxWeight){
        int[][] dp = new int[n][maxWeight+1];
        for (int i = 0; i <= maxWeight; i++){
            if (i % weight[0] == 0) {
                dp[0][i] = i / weight[0];
            }
            else{
                dp[0][i] = 10000000;
            }
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= maxWeight; j++){
                int notTake = dp[i-1][j];
                int Take = 10000000;
                if (weight[i] <= j){
                    Take = value[i] + dp[i][j-weight[i]];
                }
                dp[i][j] = Math.min(notTake, Take);
            }
        }
        return dp[n-1][maxWeight];
    }

}
