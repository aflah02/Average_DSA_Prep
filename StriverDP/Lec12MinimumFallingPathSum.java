import java.util.Arrays;
import java.util.Scanner;

public class Lec12MinimumFallingPathSum {
    //Link - https://leetcode.com/problems/minimum-falling-path-sum/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int minVal = Integer.MAX_VALUE;
        int[][] memArray = new int[matrix.length][matrix.length];
        for (int[] ls: memArray){
            Arrays.fill(ls, -1);
        }
//        for (int i = 0; i < matrix.length; i++){
//            minVal = Math.min(minVal, solveRecursive(matrix, matrix.length, matrix.length-1, i));
//        }
//        for (int i = 0; i < matrix.length; i++){
//            minVal = Math.min(minVal, solveMemoized(matrix, matrix.length, matrix.length-1, i, memArray));
//        }
//        return minVal;
//        return solveDP(matrix, matrix.length);
        return solveDPMemoryOptimal(matrix, matrix.length);
    }

    private static int solveRecursive(int[][] matrix, int length, int i, int j) {
        if (j < 0 || j >= matrix.length){
            return 100*100;
        }
        if (i == 0){
            return matrix[i][j];
        }
        int up = matrix[i][j] + solveRecursive(matrix, length, i-1, j);
        int ld = matrix[i][j] + solveRecursive(matrix, length, i-1, j-1);
        int rd = matrix[i][j] + solveRecursive(matrix, length, i-1, j+1);
        return Math.min(Math.min(up, ld), rd);
    }
    private static int solveMemoized(int[][] matrix, int length, int i, int j, int[][] memArray) {
        if (j < 0 || j >= matrix.length){
            return 100*100;
        }
        if (i == 0){
            return matrix[i][j];
        }
        if (memArray[i][j] != -1){
            return memArray[i][j];
        }
        int up = matrix[i][j] + solveMemoized(matrix, length, i-1, j, memArray);
        int ld = matrix[i][j] + solveMemoized(matrix, length, i-1, j-1, memArray);
        int rd = matrix[i][j] + solveMemoized(matrix, length, i-1, j+1, memArray);
        return memArray[i][j] = Math.min(Math.min(up, ld), rd);
    }

    private static int solveDP(int[][] matrix, int length){
        int[][] dp = new int[length][length];
        dp[0] = matrix[0];
        for (int i = 1; i < length; i++){
            for (int j = 0; j < length; j++){
                int up = matrix[i][j];
                int ld = matrix[i][j];
                int rd = matrix[i][j];
                if (j > 0){
                    ld += dp[i-1][j-1];
                }
                else{
                    ld = Integer.MAX_VALUE;
                }
                if (j < length-1){
                    rd += dp[i-1][j+1];
                }
                else{
                    rd = Integer.MAX_VALUE;
                }
                up += dp[i-1][j];
                dp[i][j] = Math.min(Math.min(up, ld),rd);
            }
        }
        int minFound = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++){
            int val = dp[length-1][i];
            if (val < minFound){
                minFound = val;
            }
        }
        return minFound;
    }

    private static int solveDPMemoryOptimal(int[][] matrix, int length){
        int[] prev;
        prev = matrix[0];
        for (int i = 1; i < length; i++){
            int[] curr = new int[length];
            for (int j = 0; j < length; j++){
                int up = matrix[i][j];
                int ld = matrix[i][j];
                int rd = matrix[i][j];
                if (j > 0){
                    ld += prev[j-1];
                }
                else{
                    ld = Integer.MAX_VALUE;
                }
                if (j < length-1){
                    rd += prev[j+1];
                }
                else{
                    rd = Integer.MAX_VALUE;
                }
                up += prev[j];
                curr[j] = Math.min(Math.min(up, ld),rd);
            }
            prev = curr;
        }
        int minFound = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++){
            int val = prev[i];
            if (val < minFound){
                minFound = val;
            }
        }
        return minFound;
    }
}