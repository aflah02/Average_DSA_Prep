import java.util.Arrays;

public class Lec23UnboundedKnapsack {
    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(3, 15, new int[]{7,2,4}, new int[]{5,10,20}));
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//        return solveRecursive(n, w, profit, weight, 0);
//        int[][] memArray = new int[n+1][w];
//        for (int[] ls: memArray){
//            Arrays.fill(ls, -1);
//        }
//        return solveMemoized(n, w, profit, weight, 0, memArray);
        return solveDP(n, w, profit, weight);
    }
    static int solveRecursive(int n, int w, int[] profit, int[] weight, int i){
        if (i == n-1){
            if (w > weight[i]){
                return (w-(w%weight[i]))*profit[i]/weight[i];
            }
            return 0;
        }
        int Take = Integer.MIN_VALUE;
        if (w >= weight[i]){
            Take = profit[i] + solveRecursive(n, w - weight[i], profit, weight, i);
        }
        return Math.max(Take, solveRecursive(n, w, profit, weight, i+1));
    }
    static int solveMemoized(int n, int w, int[] profit, int[] weight, int i, int[][] memArray){
        if (i == n-1){
            if (w > weight[i]){
                return (w-(w % weight[i]))*profit[i]/weight[i];
            }
            return 0;
        }
        if (memArray[i][w] != -1){
            return memArray[i][w];
        }
        int Take = Integer.MIN_VALUE;
        if (w >= weight[i]){
            Take = profit[i] + solveMemoized(n, w - weight[i], profit, weight, i, memArray);
        }
        return memArray[i][w] = Math.max(Take, solveMemoized(n, w, profit, weight, i+1, memArray));
    }
    static int solveDP(int n, int w, int[] profit, int[] weight){
        int[][] dp = new int[n][w+1];
        for (int i = 0; i < w+1; i++){
            dp[0][i] = (i-(i % weight[0]))*profit[0]/weight[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j < w+1; j++){
                int NotTake = dp[i-1][j];
                int Take = 0;
                if (j-weight[i]>=0){
                    Take = profit[i] + dp[i][j-weight[i]];
                }
                dp[i][j] = Math.max(Take, NotTake);
            }
        }
        for (int[] ls: dp){
            for (int i: ls){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < w+1; i++){
            max = Math.max(max, dp[n-1][i]);
        }
        return max;
    }
}
