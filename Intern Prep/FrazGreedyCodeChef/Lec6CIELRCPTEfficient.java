import java.util.Scanner;

public class Lec6CIELRCPTEfficient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long p = sc.nextLong();
            t--;
            long ans = p / 2048;
            long rem = p % 2048;
            while (rem != 0){
                ans += rem % 2;
                rem = rem / 2;
            }
            System.out.println(ans);
        }
    }
}
