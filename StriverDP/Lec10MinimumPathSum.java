import java.util.Arrays;
import java.util.Scanner;

public class Lec10MinimumPathSum {
    // Link - https://leetcode.com/problems/minimum-path-sum/
    // Sample Input
//              3 3
//            1 3 1
//            1 5 1
//            4 2 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int[][] memArray = new int[grid.length][grid[0].length];
        for (int[] ls: memArray){
            Arrays.fill(ls, -1);
        }
//        return (int) solveRecursive(grid, grid.length, grid[0].length);
//        return (int) solveMemoized(grid, grid.length, grid[0].length, memArray);
//        return solveDP(grid, grid.length, grid[0].length);
        return solveDPMemoryOptimal(grid, grid.length, grid[0].length);
    }
    public static long solveRecursive(int[][] grid, int m, int n){
        if (m <= 0 || n <= 0){
            return Integer.MAX_VALUE;
        }
        if (m == 1 && n == 1){
            return grid[m-1][n-1];
        }
        return Math.min(grid[m-1][n-1] + solveRecursive(grid, m-1, n), grid[m-1][n-1] + solveRecursive(grid, m, n-1));
    }
    public static int solveMemoized(int[][] grid, int m, int n, int[][] memArray){
        if (m <= 0 || n <= 0){
            return 50000;
        }
        if (m == 1 && n == 1){
            return grid[m-1][n-1];
        }
        if (memArray[m-1][n-1] != -1){
            return memArray[m-1][n-1];
        }
        return memArray[m-1][n-1] = Math.min(grid[m-1][n-1] + solveMemoized(grid, m-1, n, memArray),
                grid[m-1][n-1] + solveMemoized(grid, m, n-1, memArray));
    }
    public static int solveDP(int[][] grid, int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    dp[0][0] = grid[0][0];
                    continue;
                }
                int down = grid[i][j];
                int right = grid[i][j];
                if (i > 0){
                    down += dp[i-1][j];
                }
                else{
                    down += 40000;
                }
                if (j > 0){
                    right += dp[i][j-1];
                }
                else{
                    right += 40000;
                }
                dp[i][j] = Math.min(down, right);
            }
        }
        for (int[] ls: dp){
            for (int i: ls){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }
    public static int solveDPMemoryOptimal(int[][] grid, int m, int n){
        int[] prev = new int[n];
        System.out.println(n);
        for (int i: prev){
            System.out.print(i + " ");
        }
        for (int i = 0; i < m; i++){
            int[] temp = new int[n];
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    temp[0] = grid[0][0];
                    continue;
                }
                int down = grid[i][j];
                int right = grid[i][j];
                if (i > 0){
                    down += prev[j];
                }
                else{
                    down += 40000;
                }
                if (j > 0){
                    right += temp[j-1];
                }
                else{
                    right += 40000;
                }
                temp[j] = Math.min(down, right);
            }
            prev = temp;
        }
        System.out.println();
        for (int i: prev){
            System.out.print(i + " ");
        }
        System.out.println();
        return prev[n-1];
    }
}
