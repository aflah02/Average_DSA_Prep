import java.util.Arrays;
import java.util.Scanner;

public class Lec9MazeObstacles {
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
        return solveMemoized(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length, memArray);
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
}
