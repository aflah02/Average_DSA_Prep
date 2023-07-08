import java.util.Scanner;

public class Frog1 {
    int[][] t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }

        System.out.println(jump(arr, 0, 0));
    }
    static int jump(int[] arr, int cost, int pos){
        if (pos == arr.length - 1){
            return cost;
        }
        else if (pos > arr.length- 1){
            return Integer.MAX_VALUE;
        }
        if (pos+1>arr.length-1){
            return Integer.MAX_VALUE;
        }
        else if (pos+2> arr.length-1){
            return jump(arr, cost+Math.abs(arr[pos]-arr[pos+1]), pos+1);
        }
        return Math.min(jump(arr, cost+Math.abs(arr[pos]-arr[pos+1]), pos+1),
                jump(arr, cost+Math.abs(arr[pos]-arr[pos+2]), pos+2));
    }
}
