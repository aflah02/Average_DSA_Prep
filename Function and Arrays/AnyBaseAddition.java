import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int dec1 = 0;
        int i = 0;
        while (n1 != 0){
            dec1 += Math.pow(b, i) * (n1 % 10);
            n1 = n1/10;
            i++;
        }
        int dec2 = 0;
        int j = 0;
        while (n2 != 0){
            dec2 += Math.pow(b, j) * (n2 % 10);
            n2 = n2/10;
            j++;
        }
        int output = dec1 + dec2;
        String converted = "";
        while (output != 0){
            converted += output%b;
            output = output/b;
        }
        String ans = "";
        for (int k = converted.length()-1; k > -1; k--){
            ans += converted.substring(k, k+1);
        }
        System.out.println(ans);
    }
}
