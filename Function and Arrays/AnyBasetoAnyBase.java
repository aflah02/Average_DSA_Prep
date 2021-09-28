import java.util.Scanner;

public class AnyBasetoAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int output = 0;
        int i = 0;
        while (n != 0){
            output += Math.pow(b1, i) * (n % 10);
            n = n/10;
            i++;
        }
        String converted = "";
        while (output != 0){
            converted += output%b2;
            output = output/b2;
        }
        String ans = "";
        for (int j = converted.length()-1; j > -1; j--){
            ans += converted.substring(j, j+1);
        }
        System.out.println(ans);
    }
}
