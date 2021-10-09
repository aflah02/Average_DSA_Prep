import java.util.Scanner;

public class TheStateofWakandaOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int a = 0;
        int b = 0;
        while (a != n && b != m){
            if (a < n){
                a++;
            }
            if (a == n){
                b++;
            }
        }
    }
}
