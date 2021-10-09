import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] matrix1 = new int[n1][m1];
        for (int i = 0; i < n1; i++){
            for (int j = 0; j < m1; j++){
                matrix1[i][j] = sc.nextInt();
            }
        }
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        int[][] matrix2 = new int[n2][m2];
        for (int i = 0; i < n2; i++){
            for (int j = 0; j < m2; j++){
                matrix2[i][j] = sc.nextInt();
            }
        }
        if (m1 != n2){
            System.out.println("Invalid input");
        }
        else{
            int[][] output = new int[n1][m2];
            for (int i = 0; i < n1; i++){
                for (int j = 0; j < m2; j++){
                    for (int k = 0; k < m1; k++){
                        output[i][j] += matrix1[i][k]*matrix2[k][j];
                    }
                }
            }
            for (int i = 0; i < n1; i++){
                for (int j = 0; j < m2; j++){
                    System.out.print(output[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}
