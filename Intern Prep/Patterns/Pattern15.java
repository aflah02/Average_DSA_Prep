import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int spaces = n/2;
        int nos = 1;
        for (int i = 1; i <= n; i++){
                for (int j = 0; j < spaces; j++){
                    System.out.print("\t");
                }
                for (int j = 0; j < nos; j++){
                    System.out.print("*\t");
                }
                for (int j = 0; j < spaces; j++){
                    System.out.print("\t");
                }
                if (i <= n/2){
                    spaces--;
                    nos+=2;
                }
                else{
                    spaces++;
                    nos-=2;
                }
            System.out.println();
        }
    }
}
