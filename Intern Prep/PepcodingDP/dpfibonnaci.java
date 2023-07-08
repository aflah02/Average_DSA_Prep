import java.util.Scanner;

public class dpfibonnaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibdp = new int[n+1];
        fibdp[0] = 0;
        fibdp[1] = 1;
        for (int i = 2; i < n+1; i++){
            fibdp[i] = fibdp[i-1]+fibdp[i-2];

        }
        System.out.println(fibdp[n]);
    }
}
