import java.util.Scanner;

public class GuessNumberHigherorLowerLeetCodeKK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int toGuess = sc.nextInt();
        int n = sc.nextInt();
        int low = 1;
        int high = n;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low)/2;
            if (mid < toGuess){
                high = mid - 1;
            }
            else if (mid > toGuess){
                low = mid + 1;
            }
            else {
                break;
            }
        }
        System.out.println(mid);
    }

}
