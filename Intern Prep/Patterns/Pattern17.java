import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int const_space = n/2;
        int space = n/2;
        int stars = 1;
        for (int i = 1; i <= n; i++){
            if (i == n/2+1){
                for (int j = 0; j < n; j++){
                    System.out.print("*\t");
                }
                System.out.println();
                continue;
            }
            for (int j = 0; j < const_space; j++){
                System.out.print("\t");
            }
            for (int j = 0; j < stars; j++){
                System.out.print("*\t");
            }
            if (i < n/2){
                stars++;
            }
            else if (i > n/2){
                stars--;
            }
            System.out.println();
        }
    }
}
