import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edge_stars = n/2+1;
        for (int i = 1; i <= n; i++){
            if (i == 1){
                for (int j = 0; j < edge_stars; j++){
                    System.out.print("*\t");
                }
                for (int j = 0; j < edge_stars-2; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
            }
            else if (i == n){
                System.out.print("*\t");
                for (int j = 0; j < edge_stars-2; j++){
                    System.out.print("\t");
                }
                for (int j = 0; j < edge_stars; j++){
                    System.out.print("*\t");
                }
            }
            else if (i == n/2 + 1){
                for (int j = 0; j < n; j++){
                    System.out.print("*\t");
                }
            }
            else if (i < n/2 + 1){
                for (int j = 0; j < edge_stars-1; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int j = 0; j < edge_stars-2; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
            }
            else{
                System.out.print("*\t");
                for (int j = 0; j < edge_stars-2; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int j = 0; j < edge_stars-1; j++){
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
