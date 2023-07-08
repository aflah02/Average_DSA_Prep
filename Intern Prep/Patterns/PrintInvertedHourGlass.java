import java.util.Scanner;

public class PrintInvertedHourGlass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int outer_space = 1;
        int inner_space = 1;
        int star_count = n-2;
        for (int i = 1; i <= n; i++){
            if (i == 1 || i == n){
                for (int j = 0; j < n; j++){
                    System.out.print("*\t");
                }
            }
            else if (i <= n/2 + 1){
                for (int j = 0; j < outer_space; j++){
                    System.out.print("\t");
                }
                for (int j = 0; j < star_count; j++){
                    System.out.print("*\t");
                }
                for (int j = 0; j < outer_space; j++){
                    System.out.print("\t");
                }
                if (i != n/2 + 1){
                    outer_space += 1;
                    star_count -= 2;
                }

            }
            else{
                outer_space -= 1;
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
                inner_space += 2;

            }
            System.out.println();
        }
    }
}
