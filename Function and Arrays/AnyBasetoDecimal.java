import java.util.Scanner;

public class AnyBasetoDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int output = 0;
        int i = 0;
        while (n != 0){
            output += Math.pow(b, i) * (n % 10);
            n = n/10;
            i++;
        }
        System.out.println(output);
    }
}
