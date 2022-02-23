import java.util.Arrays;
import java.util.Scanner;

public class Lec13CherryPickII {
//    Link - https://leetcode.com/problems/cherry-pickup-ii/
//            4 3
//            3 1 1
//            2 5 1
//            1 5 5
//            2 1 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(cherryPickup(grid));
    }
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
//        return solveRecursive(grid, n, m, 0, 0, m-1);
//        int[][][] memArray = new int[n][m][m];
//        for (int[][] ls2D: memArray){
//            for (int[] ls: ls2D){
//                Arrays.fill(ls, -1);
//            }
//        }
//        return solveMemoized(grid, n, m, 0, 0, m-1, memArray);
        return solveDP(grid, n, m);
    }

    private static int solveRecursive(int[][] grid, int n, int m, int i, int j1, int j2) {
        System.out.println(i + " " + j1 + " " + j2);
        if (j1 >= m || j2 >= m || j2 < 0 || j1 < 0){
            return Integer.MIN_VALUE;
        }
        if (i == n-1){
            if (j1 == j2){
                return grid[i][j1];
            }
            return grid[i][j1] + grid[i][j2];
        }
        if (j1 == j2){
            return grid[i][j1] +
                    Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(
                    solveRecursive(grid, n, m, i+1, j1+1, j2+1),
                    solveRecursive(grid, n, m, i+1, j1+1, j2-1)),
                    solveRecursive(grid, n, m, i+1, j1, j2)),
                    solveRecursive(grid, n, m, i+1, j1, j2+1)),
                    solveRecursive(grid, n, m, i+1, j1, j2-1)),
                    solveRecursive(grid, n, m, i+1, j1+1, j2)),
                    solveRecursive(grid, n, m, i+1, j1-1, j2)),
                    solveRecursive(grid, n, m, i+1, j1-1, j2-1)),
                    solveRecursive(grid, n, m, i+1, j1-1, j2+1));
        }
        else{
            return grid[i][j1] + grid[i][j2] +
                    Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(
                    solveRecursive(grid, n, m, i+1, j1+1, j2+1),
                    solveRecursive(grid, n, m, i+1, j1+1, j2-1)),
                    solveRecursive(grid, n, m, i+1, j1, j2)),
                    solveRecursive(grid, n, m, i+1, j1, j2+1)),
                    solveRecursive(grid, n, m, i+1, j1, j2-1)),
                    solveRecursive(grid, n, m, i+1, j1+1, j2)),
                    solveRecursive(grid, n, m, i+1, j1-1, j2)),
                    solveRecursive(grid, n, m, i+1, j1-1, j2-1)),
                    solveRecursive(grid, n, m, i+1, j1-1, j2+1));
        }
    }

    public static int solveMemoized(int[][] grid, int n, int m, int i, int j1, int j2, int[][][] memArray){
        if (j1 >= m || j2 >= m || j2 < 0 || j1 < 0){
            return Integer.MIN_VALUE;
        }
        if (i == n-1){
            if (j1 == j2){
                return grid[i][j1];
            }
            return grid[i][j1] + grid[i][j2];
        }
        if (memArray[i][j1][j2] != -1) {
            return memArray[i][j1][j2];
        }
        if (j1 == j2){
            int maxSoFar = Integer.MIN_VALUE;
            for (int dj1 = -1; dj1 <= 1; dj1++){
                for (int dj2 = -1; dj2 <=1; dj2++){
                    maxSoFar = Math.max(maxSoFar, solveMemoized(grid, n, m, i+1, j1+dj1, j2+dj2, memArray));
                }
            }
            return memArray[i][j1][j2] = maxSoFar + grid[i][j1];
        }
        else{
            int maxSoFar = Integer.MIN_VALUE;
            for (int dj1 = -1; dj1 <= 1; dj1++){
                for (int dj2 = -1; dj2 <=1; dj2++){
                    maxSoFar = Math.max(maxSoFar, solveMemoized(grid, n, m, i+1, j1+dj1, j2+dj2, memArray));
                }
            }
            return memArray[i][j1][j2] = maxSoFar + grid[i][j1] + grid[i][j2];
        }
    }

    public static int solveDP(int[][] grid, int n, int m){
        int[][][] dp = new int[n][m][m];
        for (int j1 = 0; j1 < m; j1++){
            for (int j2 = 0; j2 < m; j2++){
                if (j1 == j2){
                    dp[n-1][j1][j2] = grid[n-1][j1];
                }
                else{
                    dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
                }
            }
        }
        for (int i = n-2; i >= 0; i--){
            for (int j1 = 0; j1 < m; j1++){
                for (int j2 = 0; j2 < m; j2++){
                    int max = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <=1; dj1++){
                        for (int dj2 = -1; dj2 <=1; dj2++){
                            int ans;
                            if (j1 == j2){
                                ans = grid[i][j1];
                            }
                            else{
                                ans = grid[i][j1] + grid[i][j2];
                            }
                            if (j1 + dj1 < 0 || j1 + dj1 >= m || j2 + dj2 < 0 || j2 + dj2 >= m){
                                ans = Integer.MIN_VALUE;
                            }
                            else{
                                ans += dp[i+1][j1+dj1][j2+dj2];
                            }
                            max = Math.max(max, ans);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m-1];
    }
}
