import java.util.Scanner;

public class DecimaltoAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        String converted = "";
        while (n != 0){
            converted += n%d;
            n = n/d;
        }
        String output = "";
        for (int i = converted.length()-1; i > -1; i--){
            output += converted.substring(i, i+1);
        }
        System.out.println(output);
    }
}
