import java.util.Scanner;

public class Lec8TotalUniquePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t >  0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] memArray = new int[m+1][n+1];
            for (int i = 0; i < m+1; i++){
                for (int j = 0; j < n+1; j++){
                    memArray[i][j] = -1;
                }
            }
//            System.out.println(solveRecursive(m,n));
//            System.out.println(solveMemoized(m, n, memArray));
//            System.out.println(solveDP(m, n));
            System.out.println(solveDPMemoryEfficient(m, n));
            t--;
        }
    }
    static int solveRecursive(int m, int n){
        if (m <= 0 || n <= 0){
            return 0;
        }
        if (m == 1 && n == 1){
            return 1;
        }
        return solveRecursive(m-1,n) + solveRecursive(m,n-1);
    }
    static int solveMemoized(int m, int n, int[][] memArray){
        if (m <= 0 || n <= 0){
            return 0;
        }
        if (memArray[m][n] != -1){
            return memArray[m][n];
        }
        if (m == 1 && n == 1){
            return 1;
        }
        return memArray[m][n] = solveMemoized(m-1,n,memArray) + solveMemoized(m,n-1,memArray);
    }
    static int solveDP(int m , int n){
        int[][] dpArray = new int[m][n];
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    dpArray[i][j] = 1;
                }
                else{
                    int up = 0, left = 0;
                    if (i > 0){
                        up = dpArray[i-1][j];
                    }
                    if (j > 0){
                        left = dpArray[i][j-1];
                    }
                    dpArray[i][j] = up+left;
                }
            }
        }
        return dpArray[m-1][n-1];
    }
    static int solveDPMemoryEfficient(int m , int n){
        int[] dpArray = new int[n];
        for (int i = 0; i < m ; i++){
            int[] temp = new int[n];
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    temp[j] = 1;
                }
                else{
                    int up = 0, left = 0;
                    if (i > 0){
                        up = dpArray[j];
                    }
                    if (j > 0){
                        left = temp[j-1];
                    }
                    temp[j] = up+left;
                }
            }
            dpArray = temp;
        }
        return dpArray[n-1];
    }
}
