public class Lec19ZeroOneKnapsack {
    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{1,2,4,5}, new int[]{5,4,8,6}, 4, 5));
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//        return solveRecursive(weight, value, n, 0, maxWeight);
//        int[][] memArray = new int[n][maxWeight+1];
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < maxWeight+1; j++){
//                memArray[i][j] = -1;
//            }
//        }
//        return solveMemoized(weight, value, n, 0, maxWeight, memArray);
        return solveDP(weight, value, n, maxWeight);
    }
    static int solveRecursive(int[] weight, int[] value, int n, int i, int maxWeight){
        if (i == n-1){
            if (weight[i] <= maxWeight){
                return value[i];
            }
            return 0;
        }
        int notTake = solveRecursive(weight, value, n, i+1, maxWeight);
        int Take = -100000;
        if (weight[i] <= maxWeight){
            Take = value[i] + solveRecursive(weight, value, n, i+1, maxWeight - weight[i]);
        }
        return Math.max(Take, notTake);
    }
    static int solveMemoized(int[] weight, int[] value, int n, int i, int maxWeight, int[][] memArray){
        if (i == n-1){
            if (weight[i] <= maxWeight){
                return value[i];
            }
            return 0;
        }
        if (memArray[i][maxWeight] != -1){
            return memArray[i][maxWeight];
        }
        int notTake = solveMemoized(weight, value, n, i+1, maxWeight, memArray);
        int Take = -100000;
        if (weight[i] <= maxWeight){
            Take = value[i] + solveMemoized(weight, value, n, i+1, maxWeight - weight[i], memArray);
        }
        return memArray[i][maxWeight] = Math.max(Take, notTake);
    }
    static int solveDP(int[] weight, int[] value, int n, int maxWeight){
        int[][] dp = new int[n][maxWeight+1];
        for (int i = weight[0]; i <= maxWeight; i++){
            dp[0][i] = value[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= maxWeight; j++){
                int notTake = dp[i-1][j];
                int Take = Integer.MIN_VALUE;
                if (weight[i] <= j){
                    Take = value[i] + dp[i-1][j-weight[i]];
                }
                dp[i][j] = Math.max(notTake, Take);
            }
        }
        return dp[n-1][maxWeight];
    }
}
