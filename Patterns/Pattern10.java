import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int os = n/2;
        int is = -1;
        for (int i = 0; i < n; i++){
            if (i == 0 || i == n-1){
                for (int j = 0; j < os; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int j = 0; j < os; j++){
                    System.out.print("\t");
                }
            }
            else{
                for (int j = 0; j < os; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int j = 0; j < is; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int j = 0; j < os; j++){
                    System.out.print("\t");
                }
            }
            if (i < n/2){
                os--;
                is += 2;
            }
            else{
                os++;
                is -= 2;
            }
            System.out.println();
        }
    }
}
