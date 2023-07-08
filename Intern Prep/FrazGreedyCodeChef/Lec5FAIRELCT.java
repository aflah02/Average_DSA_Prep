import java.util.Arrays;
import java.util.Scanner;

public class Lec5FAIRELCT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            long n = sc.nextLong();
            long m = sc.nextLong();
            long[] johnjackson = new long[(int) n];
            long[] jackjohnson = new long[(int) m];
            long johnjacksonvotes = 0;
            long jackjohnsonvotes = 0;
            for (int i = 0; i < n; i++){
                johnjackson[i] = sc.nextLong();
                johnjacksonvotes += johnjackson[i];
            }
            for (int i = 0; i < m; i++){
                jackjohnson[i] = sc.nextLong();
                jackjohnsonvotes += jackjohnson[i];
            }
            long swaps = 0;
            while (johnjacksonvotes < jackjohnsonvotes){
                long johnPointer = 0;
                long jackPointer = 0;
                long johnMin = Integer.MAX_VALUE;
                long jackMax = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++){
                    if (johnjackson[i] < johnMin){
                        johnMin = johnjackson[i];
                        johnPointer = i;
                    }
                }
                for (int i = 0; i < m; i++){
                    if (jackjohnson[i] > jackMax){
                        jackMax = jackjohnson[i];
                        jackPointer = i;
                    }
                }
                if (johnMin >= jackMax){
                    break;
                }
                johnjacksonvotes -= johnMin;
                jackjohnsonvotes -= jackMax;
                johnjacksonvotes += jackMax;
                jackjohnsonvotes += johnMin;
                johnjackson[(int) johnPointer] = jackMax;
                jackjohnson[(int) jackPointer] = johnMin;
                swaps++;
            }
            if (johnjacksonvotes > jackjohnsonvotes){
                System.out.println(swaps);
            }
            else{
                System.out.println(-1);
            }
            t--;
        }
    }
}
