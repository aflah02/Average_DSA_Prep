import java.util.Scanner;

public class RotateanArrayBetterVersion {
    public static void reverse(int[] arr, int i, int j){
        int left = i;
        int right = j;
        while (left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        k = k % n;
        if (k < 0){
            k = k + n;
        }
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-1);

        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);
    }
}
