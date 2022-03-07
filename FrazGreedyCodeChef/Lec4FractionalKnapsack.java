import java.util.Arrays;
import java.util.Comparator;

public class Lec4FractionalKnapsack {
    public static void main(String[] args) {
        int[] wt = new int[]{10,2,5};
        int[] profit = new int[]{50,30,100};
        int[] ppk = new int[3];
        for (int i = 0; i < 3; i++){
            ppk[i] = profit[i]/wt[i];
        }
        int[][] inp = new int[3][3];
        for (int i = 0; i < 3; i++){
            inp[i][0] = wt[i];
            inp[i][1] = profit[i];
            inp[i][2] = ppk[i];
        }
        int knapsackwt = 12;
        int netProfit = 0;
        Arrays.sort(inp, Comparator.comparing(o -> o[2]));
        for (int i = 2; i >= 0; i--){
            if (inp[i][0] <= knapsackwt){
                knapsackwt -= inp[i][0];
                netProfit += inp[i][1];
            }
            else{
                netProfit += inp[i][2]*knapsackwt;
                knapsackwt = 0;
                break;
            }
        }
        System.out.println(netProfit);
    }
}
