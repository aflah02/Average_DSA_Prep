import java.util.Scanner;

import static java.lang.Math.abs;

public class RotateanArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        boolean right = false;
        boolean left = false;
        int k = sc.nextInt();
        k = k % n;
        if (k > 0){
             right = true;
        }
        else if (k < 0) {
             left = true;
        }
        k = abs(k);
        if (!right && !left){
            for (int i = 0; i < n; i++){
                System.out.println(arr[i]);
            }
        }
        else if (right){
            int[] temp = new int[k];
            int[] temp2 = new int[n-k];
            int tr = 0;
            int i = 0;
            int j = 0;
            while (tr < n-k){
                temp2[i] = arr[tr];
                i++;
                tr++;
            }
            while (tr < n){
                temp[j] = arr[tr];
                j++;
                tr++;
            }
            int m = 0;
            int x = 0;
            while (m < temp.length){
                System.out.println(temp[m]);
                m++;
            }
            while (x < temp2.length){
                System.out.println(temp2[x]);
                x++;
            }
        }
        else{
            int[] temp = new int[k];
            int[] temp2 = new int[n-k];
            int tr = 0;
            int i = 0;
            int j = 0;
            while (tr < k){
                temp[i] = arr[tr];
                i++;
                tr++;
            }
            while (tr < n){
                temp2[j] = arr[tr];
                j++;
                tr++;
            }
            int m = 0;
            int x = 0;
            while (m < temp2.length){
                System.out.println(temp2[m]);
                m++;
            }
            while (x < temp.length){
                System.out.println(temp[x]);
                x++;
            }
        }


    }
}
