import java.util.Scanner;

public class DifferenceofTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n1];
        for (int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }
        int i = n1 - 1;
        int j = n2 - 1;
        int k = Math.max(n1, n2) - 1;
        int[] diff = new int[Math.max(n1, n2)];
        while (k >= 0){
            int d = 0;
            if (i >= 0){
                d += arr1[i];
            }
            if (j >= 0){
                d -= arr2[j];
            }
            if (d < 0){
                d += 10;
                int x = i-1;
                while (arr1[x] < 0){
                    arr1[x] ;
                }

            }
        }

    }
}
