import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = 0; i < n; i++){
            arr2[i] = max - arr[i];
        }

        for (int i = 0; i < max; i++){
            for (int j = 0; j < n; j++){
                if (arr2[j] > 0){
                    arr2[j] -= 1;
                    System.out.print("\t");
                }
                else if (arr[j] > 0){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
