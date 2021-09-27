import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i ; j++){
                System.out.print(fib(f) + "\t");
                f++;
            }
            System.out.println();
        }
    }
    static int fib(int n){
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }
}
