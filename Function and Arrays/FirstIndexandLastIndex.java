import java.util.Scanner;

public class FirstIndexandLastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int low = 0;
        int high = n-1;
        int loc = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] < num){
                low = mid + 1;
            }
            else if (arr[mid] > num){
                high = mid - 1;
            }
            else{
                loc = mid;
                low = mid + 1;
            }
        }
        int low1 = 0;
        int high1 = n-1;
        int loc1 = -1;
        while (low1 <= high1){
            int mid1 = (low1 + high1)/2;
            if (arr[mid1] < num){
                low1 = mid1 + 1;
            }
            else if (arr[mid1] > num){
                high1 = mid1 - 1;
            }
            else{
                loc1 = mid1;
                high1 = mid1 - 1;
            }
        }
        System.out.println(loc1);
        System.out.println(loc);
    }
}
