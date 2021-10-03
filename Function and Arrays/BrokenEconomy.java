import java.util.Scanner;

public class BrokenEconomy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int tr = 0;
        while (tr < n){
            if (arr[tr] > num){
                break;
            }
            tr++;
        }
        System.out.println(arr[tr]);
        System.out.println(arr[tr-1]);
    }
}
