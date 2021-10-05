import java.util.Scanner;

public class BrokenEconomywithBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int floor = 0;
        int ceil = n-1;
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] > num){
                high = mid-1;
                ceil = arr[mid];
            }
            else if (arr[mid] < num){
                low = mid +1;
                floor = arr[mid];
            }
            else{
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }
        if (ceil == floor){
            System.out.println(ceil);
        }
        else{
            System.out.println(floor);
            System.out.println(ceil);
        }
    }
}
