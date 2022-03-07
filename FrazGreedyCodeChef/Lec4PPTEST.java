import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lec4PPTEST {
    // https://www.codechef.com/problems/PPTEST
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int w = sc.nextInt();
            float[][] input = new float[n][4];
            for (int i = 0; i < n; i++){
                input[i][0] = sc.nextFloat();
                input[i][1] = sc.nextFloat();
                input[i][2] = sc.nextFloat();
                input[i][3] = (input[i][0] * input[i][1])/(input[i][2]);
            }
            for (int i = 0; i < n; i++){
                System.out.println(input[i][0] + " " + input[i][1] + " " + input[i][2] + " " + input[i][3]);
            }
            Arrays.sort(input, Comparator.comparing(o -> o[3]));
            int points = 0;
            for (int i = n-1; i >= 0; i--){
                if (w >= input[i][2]){
                    w -= input[i][2];
                    points += input[i][0] * input[i][1];
                }
            }
            System.out.println(points);
            t--;
        }
    }
}
