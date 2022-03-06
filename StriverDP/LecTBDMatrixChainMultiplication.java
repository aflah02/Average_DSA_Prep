public class LecTBDMatrixChainMultiplication {
    // https://www.codingninjas.com/codestudio/problems/matrix-chain-multiplication_975344?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
    public static void main(String[] args) {

    }
//    public static int matrixMultiplication(int[] arr , int N) {
//        // Write your code here
//    }
    static int solveDP(int[] arr , int N){
        int[][] dp = new int[N][N];
        for (int i = 1; i < N; i++){
            dp[i][i] = 0;
        }
        for (int i = N-1; i >= 1; i--){
            for (int j = i+1; j <= N-1; j++){
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        for (int[] ls: dp){
            for (int i: ls){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return dp[1][N-1];
    }
}
