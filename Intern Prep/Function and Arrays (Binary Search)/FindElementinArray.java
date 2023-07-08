import java.util.Scanner;

public class FindElementinArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        int index = -1;
        for (int i = 0; i < n; i++){
            if (arr[i] == d){
                index = i;
            }
        }
        System.out.println(index);
    }
}
