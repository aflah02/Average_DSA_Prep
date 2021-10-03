import java.util.Arrays;
import java.util.Scanner;

public class PrintInvertedBarChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = -1;
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int j = 0; j < max; j++){
            for (int i = 0; i < arr.length; i++){
                if (arr[i] > 0){
                    System.out.print("*\t");
                    arr[i]--;
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }
}
