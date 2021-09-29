import java.util.Scanner;

public class SumofTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        int n1 = sc.nextInt();
        int[] arr = new int[n1];
        for (int i = 0; i < n1; i++){
            arr[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr3 = new int[Math.max(n1, n2)];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }
        int c = 0;
        if (n1 > n2){
            for (int i = 0; i < n1-n2; i++){
                arr3[i] = 0;
            }
            int x = 0;
            for (int i = n1-n2; i < n1; i++){
                arr3[i] = arr2[x];
                x++;
            }
            for (int i = n1-1; i >=0; i--){
                arr3[i] = arr3[i] + arr[i];
                if (c == 1){
                    arr3[i] += 1;
                }
                if (arr3[i] > 9){
                    arr3[i] = arr3[i] - 10;
                    c = 1;
                }
                else{
                    c = 0;
                }
            }
        }
        else if (n1 < n2){
            for (int i = 0; i < n2-n1; i++){
                arr3[i] = 0;
            }
            int x = 0;
            for (int i = n2-n1; i < n2; i++){
                arr3[i] = arr[x];
                x++;
            }
            for (int i = n2-1; i >=0; i--){
                arr3[i] = arr3[i] + arr2[i];
                if (c == 1){
                    arr3[i] += 1;
                }
                if (arr3[i] > 9){
                    arr3[i] = arr3[i] - 10;
                    c = 1;
                }
                else{
                    c = 0;
                }
            }
        }
        else {
            check = true;
            for (int i = n1-1; i >=0; i--){
                arr[i] = arr[i] + arr2[i];
                if (c == 1){
                    arr[i] += 1;
                }
                if (arr[i] > 9){
                    arr[i] = arr[i] - 10;
                    c = 1;
                }
                else{
                    c = 0;
                }
            }
        }
        if (check){
            if (c == 1){
                System.out.println(1);
            }
            for (int i = 0; i < arr.length; i++){
                System.out.println(arr[i]);
            }
        }
        else{
            if (c == 1){
                System.out.println(1);
            }
            for (int i = 0; i < arr3.length; i++){
                System.out.println(arr3[i]);
            }
        }

    }
}
