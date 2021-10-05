import java.util.Scanner;

public class FirstBadVersionLeetCodeKK {
    static int ver1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ver1 = sc.nextInt();
        System.out.println(firstBadVersion(n));
    }
    static boolean isBadVersion(int version){
        if (version >= ver1){
            return true;
        }
        return false;
    }
    static int firstBadVersion(int n) {
        long low = 1;
        long high = n;
        long mid = 0;
        long ans = -1;
        while (low <= high){
            mid = (low + high)/2;
            boolean x = isBadVersion((int) mid);
            if (x){
                high = mid - 1;
                ans = mid;
            }
            else if (!x){
                low = mid + 1;
            }
        }
        return (int) ans;
    }
}
