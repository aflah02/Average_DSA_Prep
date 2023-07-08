import java.util.Arrays;
import java.util.Scanner;

public class Lec14SubsetSumEqualsK {
//    Link - https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(subsetSumToK(n, k, arr));
            t--;
        }
    }
    public static boolean subsetSumToK(int n, int k, int[] arr){
//        return solveRecursive(n-1, k, arr);
//        int[][] memArray = new int[n][k+1];
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < k+1; j++){
//                memArray[i][j] = -1;
//            }
//        }
//        return solveMemoized(n-1, k, arr, memArray);
        return solveDP(n, k, arr);
    }

    private static boolean solveRecursive(int n, int k, int[] arr) {
        if (k == 0){
            return true;
        }
        if (n == 0){
            return arr[n] == k;
        }
        boolean notTake = solveRecursive(n-1, k, arr);
        boolean Take = false;
        if (arr[n] <= k){
            Take = solveRecursive(n-1, k-arr[n], arr);
        }
        return notTake || Take;
    }

    private static Boolean solveMemoized(int n, int k, int[] arr, int[][] memArray){
        if (k == 0){
            return true;
        }
        if (n == 0){
            return arr[n] == k;
        }
        if (memArray[n][k] != -1){
            if (memArray[n][k] == 0){
                return false;
            }
            else{
                return true;
            }
        }
        boolean notTake = solveMemoized(n-1, k, arr, memArray);
        boolean Take = false;
        if (arr[n] <= k){
            Take = solveMemoized(n-1, k-arr[n], arr, memArray);
        }
        boolean soln = notTake || Take;
        if (soln){
            memArray[n][k] = 1;
        }
        else{
            memArray[n][k] = 0;
        }
        return soln;
    }

    private static boolean solveDP(int n, int k, int[] arr){
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
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < k+1; j++){
                if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
}
