import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                System.out.print(nCr(i-1, j) + "\t");
            }
            System.out.println();
        }
    }
    static int nCr(int n, int r){
        return factorial(n)/(factorial(r)*factorial(n-r));
    }
    static int factorial(int x){
        if (x == 0){
            return 1;
        }
        if (x == 1){
            return 1;
        }
        return x * factorial(x-1);
    }
}
