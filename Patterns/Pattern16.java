import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int spaces = 2*n-3;
        for (int i = 1; i <= n; i++){
            if (i == n){
                for (int j = 1; j <= i; j++){
                    System.out.print(j + "\t");
                }
                for (int j = i-1; j > 0; j--){
                    System.out.print(j + "\t");
                }
            }
            else{
                for (int j = 1; j <= i; j++){
                    System.out.print(j + "\t");
                }
                for (int j = 0; j < spaces; j++){
                    System.out.print("\t");
                }
                for (int j = i; j > 0; j--){
                    System.out.print(j + "\t");
                }
            }
            spaces-=2;
            System.out.println();
        }
    }
}
