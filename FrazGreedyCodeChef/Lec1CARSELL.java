import java.util.Arrays;
import java.util.Scanner;

public class Lec1CARSELL {
    // https://www.codechef.com/problems/CARSELL
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t > 0){
            long n = sc.nextLong();
            long[] arr = new long[(int) n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextLong();
            }
            Arrays.sort(arr);
            long[] revarr = new long[(int) n];
            for (int i = 0; i < n ; i++){
                revarr[i] = arr[(int) (n-i-1)];
            }
            long cost = 0;
            for (int i = 0; i < n; i++){
                if (revarr[i] - i >= 0){
                    cost += revarr[i] - i;
                }
            }
            System.out.println(cost % (Math.pow(10,9) + 7));
            t--;
        }
    }
}
