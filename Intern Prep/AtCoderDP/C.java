import java.util.Arrays;
import java.util.Scanner;

public class C {
    static int[][] memArray;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memArray = new int[n+1][3];
        for (int i = 0; i < n; i++){
            Arrays.fill(memArray[i], 0);
        }
        int[][] input = new int[n][3];
        for (int i = 0; i < n; i++){
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            input[i][2] = sc.nextInt();
        }
        System.out.println(solve(input, n));
    }
    static int solve(int[][] input, int n){
        for (int i = 1; i <= n; i++){
            memArray[i][0] = Math.max(input[i-1][0] + memArray[i-1][1], input[i-1][0] + memArray[i-1][2]);
            memArray[i][1] = Math.max(input[i-1][1] + memArray[i-1][0], input[i-1][1] + memArray[i-1][2]);
            memArray[i][2] = Math.max(input[i-1][2] + memArray[i-1][0], input[i-1][2] + memArray[i-1][1]);
        }
        return Math.max(Math.max(memArray[n][0], memArray[n][1]), memArray[n][2]);
    }
}
