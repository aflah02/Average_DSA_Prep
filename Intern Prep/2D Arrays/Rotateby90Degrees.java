import java.util.Scanner;

public class Rotateby90Degrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = i; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++){
            int li = 0;
            int ri = m-1;
            while (li<ri){
                int temp = matrix[i][li];
                matrix[i][li] = matrix[i][ri];
                matrix[i][ri] = temp;
                li++;
                ri--;
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
