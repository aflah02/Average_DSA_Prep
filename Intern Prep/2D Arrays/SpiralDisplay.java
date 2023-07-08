import java.util.Scanner;

public class SpiralDisplay {
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
        int minr = 0;
        int minc = 0;
        int maxr = n-1;
        int maxc = m-1;
        int printCount = n*m;
        int count = 0;
        while (count < printCount){
            for (int i = minr, j = minc; i <= maxr && count < printCount; i++){
                System.out.println(matrix[i][j]);
                count++;
            }
            minc++;
            for (int i = minc, j = maxr; i <= maxc && count < printCount; i++){
                System.out.println(matrix[j][i]);
                count++;
            }
            maxr--;
            for (int i = maxr, j = maxc; i >= minr && count < printCount; i--){
                System.out.println(matrix[i][j]);
                count++;
            }
            maxc--;
            for (int i = maxc, j = minr; i >= minc && count < printCount; i--){
                System.out.println(matrix[j][i]);
                count++;
            }
            minr++;
        }
    }
}
