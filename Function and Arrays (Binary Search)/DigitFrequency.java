import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int count = 0;
        while (n > 1){
            if (n % 10 == d){
                count++;
                n = n/10;
            }
            else{
                n=n/10;
            }
        }
        System.out.println(count);
    }
}
