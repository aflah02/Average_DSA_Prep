import java.util.Scanner;

public class SquareRootBinarySearchLeetCodeKK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(getSqrt(n));
    }
    static int getSqrt(long x){
        if (x == 0){
            return 0;
        }
        long low = 1;
        long high = x;
        long mid = 0;
        while (low <= high){
            mid = low + (high- low)/2;
            if (mid * mid < x){
                low = mid + 1;
            }
            else if (mid * mid > x){
                high = mid - 1;
            }
            else{
                return (int) mid;
            }
        }
        return (int) high;
    }
}
