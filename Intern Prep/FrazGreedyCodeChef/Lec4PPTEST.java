import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lec4PPTEST {
    // https://www.codechef.com/problems/PPTEST
    // DP Not Greedy!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[][] input = new int[n][3];
            for (int i = 0; i < n; i++){
                input[i][0] = sc.nextInt();
                input[i][1] = sc.nextInt();
                input[i][2] = sc.nextInt();
            }
            int[][] memArray = new int[n][w+1];
            for (int[] ls: memArray){
                Arrays.fill(ls, -1);
            }
            System.out.println(solve(input, n, w, 0, memArray));
            t--;
        }
    }

    private static int solve(int[][] input, int n, int w, int i, int[][] memArray) {
        if (w <= 0){
            return 0;
        }
        if (i == n-1){
            if (w >= input[i][2]){
                return input[i][0]*input[i][1];
            }
            else{
                return 0;
            }
        }
        if (memArray[i][w] != -1){
            return memArray[i][w];
        }
        int Take = 0;
        if (w-input[i][2] >= 0){
            Take = input[i][0] * input[i][1] + solve(input, n, w-input[i][2], i+1, memArray);
        }
        return memArray[i][w] = Math.max(solve(input, n, w, i+1, memArray), Take);
    }
}
