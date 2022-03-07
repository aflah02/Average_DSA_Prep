import java.util.Arrays;
import java.util.Scanner;

public class Lec6MAXDIFF {
    // https://www.codechef.com/problems/MAXDIFF
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            long n = sc.nextLong();
            long k = sc.nextLong();
            long[] itemWeights = new long[(int) n];
            long totalWeight = 0;
            for (int i = 0; i < n; i++){
                itemWeights[i] = sc.nextLong();
                totalWeight += itemWeights[i];
            }
            Arrays.sort(itemWeights);
            if (k <=  n/2){
                long kidHoldsifChosenFromStart = 0;
                for (int i = 0; i < k; i++){
                    kidHoldsifChosenFromStart += itemWeights[i];
                }
                System.out.println(Math.max(totalWeight-kidHoldsifChosenFromStart, kidHoldsifChosenFromStart) -  Math.min(totalWeight-kidHoldsifChosenFromStart,kidHoldsifChosenFromStart));
            }
            else{
                long kidHoldsifChosenFromEnd = 0;
                for (int i = (int) (n-1); i >= n-k; i--){
                    kidHoldsifChosenFromEnd += itemWeights[i];
                }
                System.out.println(Math.max(totalWeight-kidHoldsifChosenFromEnd, kidHoldsifChosenFromEnd) -  Math.min(totalWeight-kidHoldsifChosenFromEnd,kidHoldsifChosenFromEnd));
            }
            t--;
        }
    }
}
