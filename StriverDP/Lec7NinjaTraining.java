import java.util.Scanner;

public class Lec7NinjaTraining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int[][] inputs = new int[n][3];
            for (int i = 0; i < n; i++){
                inputs[i][0] = sc.nextInt();
                inputs[i][1] = sc.nextInt();
                inputs[i][2] = sc.nextInt();
            }
            System.out.println(solveDP(inputs, n));
            t--;
        }
    }
    public static int solveDP(int[][] inputs, int n){
        int[][] dpArray = new int[n+1][3];
        for (int i = 1; i <= n; i++){
            dpArray[i][0] = inputs[i-1][0] + Math.max(dpArray[i-1][1], dpArray[i-1][2]);
            dpArray[i][1] = inputs[i-1][1] + Math.max(dpArray[i-1][0], dpArray[i-1][2]);
            dpArray[i][2] = inputs[i-1][2] + Math.max(dpArray[i-1][1], dpArray[i-1][0]);
        }
        return Math.max(Math.max(dpArray[n][0], dpArray[n][1]), dpArray[n][2]);
    }
}
