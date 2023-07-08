import java.util.Scanner;

public class ValidPerfectSquareLeetCodeKK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPerfectSquare(n));
    }
    static boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;
        while (low <= high){
            long mid = (low + high)/2;
            if (mid * mid > num){
                high = mid - 1;
            }
            else if (mid * mid < num){
                low = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}