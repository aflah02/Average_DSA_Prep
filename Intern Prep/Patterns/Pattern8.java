import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int space_count = n-1;
        int star_count = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < space_count; j++){
                System.out.print("\t");
            }
            for (int j = 0; j < star_count; j++){
                System.out.print("*");
            }
            space_count--;
            System.out.println();
        }
    }
}
