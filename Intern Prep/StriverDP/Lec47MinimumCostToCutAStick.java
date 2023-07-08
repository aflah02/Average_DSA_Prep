import java.util.Arrays;

public class Lec47MinimumCostToCutAStick {
    public static void main(String[] args) {

    }
    public int minCost(int n, int[] cuts) {
        int[] betterCuts = new int[cuts.length+2];
        betterCuts[0] = 0;
        betterCuts[betterCuts.length-1] = n;
        for (int i = 1; i < betterCuts.length-1; i++){
            betterCuts[i] = cuts[i-1];
        }
        System.out.println(Arrays.toString(betterCuts));
        Arrays.sort(betterCuts);
        // int[][] memArray = new int[betterCuts.length][betterCuts.length];
        // for (int[] ls: memArray){
        //     Arrays.fill(ls, -1);
        // }
//        return solveRecursive(betterCuts, 1, cuts.length);
//        return solveMemoized(betterCuts, 1, cuts.length, memArray);
        return solveDP(cuts.length,betterCuts);
    }
    static int solveRecursive(int[] cuts, int i, int j){
        if (i > j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++){
            int cost = cuts[j+1] - cuts[i-1] + solveRecursive(cuts, i, ind-1) + solveRecursive(cuts, ind+1, j);
            min = Math.min(cost, min);
        }
        return min;
    }
    static int solveMemoized(int[] cuts, int i, int j, int[][] memArray){
        if (i > j){
            return 0;
        }
        if (memArray[i][j] != -1){
            return memArray[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++){
            int cost = cuts[j+1] - cuts[i-1] + solveMemoized(cuts, i, ind-1, memArray) + solveMemoized(cuts, ind+1, j, memArray);
            min = Math.min(cost, min);
        }
        return memArray[i][j] = min;
    }
    static int solveDP(int c, int[] cuts){
        int N = cuts.length;
        int[][] dp = new int[c+3][c+3];
        for (int i = c; i >= 1; i--){
            for (int j = 1; j <= c; j++){
                if (i > j){
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++){
                    int cost = cuts[j+1] - cuts[i-1] + dp[i][k-1] + dp[k+1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }
}
