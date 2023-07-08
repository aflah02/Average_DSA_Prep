import java.util.Arrays;

public class Lec24RodCuttingProblem {
    public static void main(String[] args) {
        System.out.println(cutRod(new int[]{2,5,7,8,10}, 5));
    }
    public static int cutRod(int[] price, int n) {
        int[] cut = new int[n];
        for (int i = 1; i < n+1; i++){
            cut[i-1] = i;
        }
//        return solveRecursive(price, cut, n, n, 0);
//        int[][] memArray = new int[n+1][n+1]; // First n+1 for prices array.size + 1, Second n+1 cos cuts are 1,2,3,till n
//        for (int[] ls: memArray){
//            Arrays.fill(ls, -1);
//        }
//        return solveMemoized(price, cut, n, n, 0, memArray);
        return solveDP(price, cut, n, n);
    }
    static int solveRecursive(int[] price, int[] cut, int n, int maxLen, int i){
        if (i == n-1){
            if (maxLen >= cut[i]){
                return (maxLen - (maxLen % cut[i]))*price[i]/cut[i];
            }
            return 0;
        }
        int Take = 0;
        if (maxLen >= cut[i]){
            Take = price[i] + solveRecursive(price, cut, n, maxLen-cut[i], i);
        }
        return Math.max(Take, solveRecursive(price,cut,n,maxLen,i+1));
    }

    static int solveMemoized(int[] price, int[] cut, int n, int maxLen, int i, int[][] memArray){
        if (i == n-1){
            if (maxLen >= cut[i]){
                return (maxLen - (maxLen % cut[i]))*price[i]/cut[i];
            }
            return 0;
        }
        if (memArray[i][maxLen] != -1){
            return memArray[i][maxLen];
        }
        int Take = 0;
        if (maxLen >= cut[i]){
            Take = price[i] + solveMemoized(price, cut, n, maxLen-cut[i], i, memArray);
        }
        return memArray[i][maxLen] = Math.max(Take, solveMemoized(price,cut,n,maxLen,i+1, memArray));
    }
    static int solveDP(int[] price, int[] cut, int n, int maxLen){
        int[][] dp = new int[n][n+1];
        for (int i = 0; i < n+1; i++){
            dp[0][i] = (i - (i % cut[0]))*price[0]/cut[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j < n+1; j++){
                int NotTake = dp[i-1][j];
                int Take = 0;
                if (j-cut[i]>=0){
                    Take = price[i] + dp[i][j-cut[i]];
                }
                dp[i][j] = Math.max(Take, NotTake);
            }
        }
        return dp[n-1][n];
    }
}
