import java.util.Scanner;

public class SumofTwoArraysBetterVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr = new int[n1];
        for (int i = 0; i < n1; i++){
            arr[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }
        int[] arr3 = new int[Math.max(n1, n2)];
        int i = n1 - 1;
        int j = n2 - 1;
        int k = Math.max(n1, n2) - 1;
        int c = 0;
        while (k >= 0){
            int d = c;
            if (i >= 0){
                d += arr[i];
            }
            if (j >= 0){
                d += arr2[j];
            }
            c = d/10;
            d = d % 10;
            arr3[k] = d;
            k--;
            i--;
            j--;
        }
        if (c != 0){
            System.out.println(c);
        }
        for (int val: arr3){
            System.out.println(val);
        }
    }
}
