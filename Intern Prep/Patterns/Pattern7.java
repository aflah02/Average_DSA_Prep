import java.util.Scanner;

//        *   *   *   *       *   *   *   *
//        *   *   *               *   *   *
//        *   *                       *   *
//        *                               *
//        *   *                       *   *
//        *   *   *               *   *   *
//        *   *   *   *       *   *   *   *

public class Pattern7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int space_count = 1;
        int star_count = n/2+1;
        for (int i = 0; i < n; i++){
            if (i < n/2){
                for (int j = 0; j < star_count; j++){
                    System.out.print("*   ");
                }
                for (int j = 0; j < space_count; j++){
                    System.out.print("    ");
                }
                for (int j = 0; j < star_count; j++){
                    System.out.print("*   ");
                }
                star_count = star_count - 1;
                space_count = space_count + 2;
                System.out.println();
            }
            if (i >= n/2){
                for (int j = 0; j < star_count; j++){
                    System.out.print("*   ");
                }
                for (int j = 0; j < space_count; j++){
                    System.out.print("    ");
                }
                for (int j = 0; j < star_count; j++){
                    System.out.print("*   ");
                }
                star_count = star_count + 1;
                space_count = space_count - 2;
                System.out.println();
            }
        }
    }
}
