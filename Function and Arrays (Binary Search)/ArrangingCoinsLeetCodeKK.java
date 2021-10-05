import java.util.Scanner;

public class ArrangingCoinsLeetCodeKK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long l = 0;
        long r = n;
        long k, curr;
        while (l <= r){
            k = l + (r-l)/2;
            curr = k * (k+1)/2;
            if (curr == n) System.out.println((int) k);
            if (n < curr){
                r = k-1;
            }
            else{
                l = k+1;
            }
        }
        System.out.println((int) r);
    }
}
