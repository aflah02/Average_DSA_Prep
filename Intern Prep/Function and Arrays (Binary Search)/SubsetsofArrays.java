import java.util.Scanner;

public class SubsetsofArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int count = (int) Math.pow(2, n);
        for (int i = 0; i < count; i++){
            String s = Integer.toBinaryString(i);
            char[] CharArr = s.toCharArray();
            int x = CharArr.length;
            char[] Ch = new char[n];
            for (int m = 0; m < n-x; m++){
                Ch[m] = '0';
            }
            int tr = 0;
            for (int m = n-x; m < n; m++){
                Ch[m] = CharArr[tr];
                tr++;
            }
            for (int j = 0; j < Ch.length; j++){
                if (Ch[j] == '0'){
                    System.out.print("_\t");
                }
                else{
                    System.out.print(arr[j] + "\t");
                }
            }
            System.out.println();
        }

    }
}
