import java.util.Scanner;

public class Pattern18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int outer_space = 1;
        int inner_space = n-4;
        int stars = 1;
        for (int i = 1; i <= n; i++){
            if (i == 1 || i == n){
                for (int j = 0; j < n; j++){
                    System.out.print("*\t");
                }
            }
            else if (i <= n/2){
                for (int j = 0; j < outer_space; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int j = 0; j < inner_space; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int j = 0; j < outer_space; j++){
                    System.out.print("\t");
                }
                outer_space++;
                inner_space-=2;
            }
            else{
                for (int j = 0; j < outer_space; j++){
                    System.out.print("\t");
                }
                for (int j = 0; j < stars; j++){
                    System.out.print("*\t");
                }
                for (int j = 0; j < outer_space; j++){
                    System.out.print("\t");
                }
                outer_space--;
                stars+=2;
            }
            System.out.println();
        }

    }
}
