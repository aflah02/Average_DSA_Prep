import java.util.Scanner;

public class PatternM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int spaces1 = 0;
        int spaces2 = n-4;
        for (int i = 1; i <= n; i++){

            if (i > n/2 + 1){
                System.out.print("*\t");
                for (int j = 0; j < n-2; j++){
                    System.out.print("\t");
                }
                System.out.print("*\t");
            }

            else{
                if (i == n/2 + 1){
                    System.out.print("*\t");
                    for (int j = 0; j < spaces1; j++){
                        System.out.print("\t");
                    }
                    System.out.print("*\t");
                    for (int j = 0; j < spaces1; j++){
                        System.out.print("\t");
                    }
                    System.out.print("*\t");
                }
                else if (i == 1){
                    System.out.print("*\t");
                    for (int j = 0; j < n-2; j++){
                        System.out.print("\t");
                    }
                    System.out.print("*\t");
                }
                else{
                    System.out.print("*\t");
                    for (int j = 0; j < spaces1; j++){
                        System.out.print("\t");
                    }
                    System.out.print("*\t");
                    for (int j = 0; j < spaces2; j++){
                        System.out.print("\t");
                    }
                    System.out.print("*\t");
                    for (int j = 0; j < spaces1; j++){
                        System.out.print("\t");
                    }
                    System.out.print("*\t");
                    spaces2-=2;
                    spaces1++;
                }

            }
            System.out.println();
        }
    }
}
