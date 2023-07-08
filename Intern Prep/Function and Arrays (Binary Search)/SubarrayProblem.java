import java.util.Scanner;

public class SubarrayProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int arrSize = arr.length;
        for (int startPoint = 0; startPoint < arrSize; startPoint++)
        {
            for (int grps = startPoint + 1; grps <= arrSize; grps++)
            {
                for (int j = startPoint; j < grps; j++)
                {
                    System.out.print(arr[j] + "	");
                }
                System.out.println();
            }
        }
    }
}
