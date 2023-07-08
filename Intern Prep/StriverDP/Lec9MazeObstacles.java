import java.util.Arrays;
import java.util.Scanner;

public class Lec9MazeObstacles {
    // Submit Here https://leetcode.com/problems/unique-paths-ii
    // Test Input -
//            1
//            3
//            3
//            0 0 0
//            0 1 0
//            0 0 0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println(uniquePathsWithObstacles(matrix));
            t--;
        }
    }
    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length ==1 && obstacleGrid[0].length == 1){
            if (obstacleGrid[0][0]==1){
                return 0;
            }
            else{
                return 1;
            }
        }
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] memArray = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] ls: memArray){
            Arrays.fill(ls, -1);
        }
//        return solveRecursive(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
//        return solveMemoized(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length, memArray);
//        return solveDP(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
//        return solveDPMemoryOptimal(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
        return solveDPMemoryOptimalHardCore(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
    }
    static int solveRecursive(int[][] matrix, int n, int m){
        if (n <= 0 || m <= 0){
            return 0;
        }
        if (n == 1 && m == 1){
            return 1;
        }
        if (matrix[n-1][m-1] == 1){
            return 0;
        }
        return solveRecursive(matrix, n-1, m) + solveRecursive(matrix, n, m-1);
    }
    static int solveMemoized(int[][] matrix, int n, int m, int[][] memArray){
        if (n <= 0 || m <= 0){
            return 0;
        }
        if (n == 1 && m == 1){
            return 1;
        }
        if (matrix[n-1][m-1] == 1){
            return 0;
        }
        if (memArray[n-1][m-1] != -1){
            return memArray[n-1][m-1];
        }
        return memArray[n-1][m-1] = solveMemoized(matrix, n-1, m, memArray) + solveMemoized(matrix, n, m-1, memArray);
    }
    static int solveDP(int[][] matrix, int n, int m){
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                int down = 0;
                int right = 0;
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                if (j > 0){
                    right = dp[i][j-1];
                }
                if (i > 0){
                    down = dp[i-1][j];
                }
                dp[i][j] = right + down;
            }
        }
        return dp[n-1][m-1];
    }
    static int solveDPMemoryOptimal(int[][] matrix, int n, int m){
        int[] prev = new int[m];
        for (int i = 0; i < n; i++){
            int[] curr = new int[m];
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == 1){
                    curr[j] = 0;
                    continue;
                }
                int down = 0;
                int right = 0;
                if (i == 0 && j == 0){
                    curr[j] = 1;
                    continue;
                }
                if (j > 0){
                    right = curr[j-1];
                }
                if (i > 0){
                    down = prev[j];
                }
                curr[j] = right + down;
            }
            prev = curr;
        }
        return prev[m-1];
    }
    static int solveDPMemoryOptimalHardCore(int[][] matrix, int n, int m){
        int[] prev = new int[m];
        for (int i = 0; i < n; i++){
            int currTrack = 0;
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == 1){
                    prev[j] = 0;
                    continue;
                }
                int down = 0;
                int right = 0;
                if (i == 0 && j == 0){
                    prev[j] = 1;
                    continue;
                }
                if (j > 0){
                    right = currTrack;
                }
                if (i > 0){
                    down = prev[j];
                }
                prev[j] = right + down;
                currTrack = right+down;
            }
        }
        return prev[m-1];
    }
}
