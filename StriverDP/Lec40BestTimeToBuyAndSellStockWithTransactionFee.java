import java.util.ArrayList;
import java.util.Arrays;

public class Lec40BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices, int fee) {
//        return (int) solveRecursive(prices, 0, 1);
        long[][] memArray = new long[prices.length+1][2];
        for (long[] ls: memArray){
            Arrays.fill(ls, -1);
        }
        return (int) solveMemoized(prices, 0, 1, memArray, fee);
    }
    static long solveMemoized(int[] prices, int ind, int buy, long[][] memArray, int fee){
        ArrayList<Integer> x = new ArrayList<>();
        if (ind >= prices.length){
            return 0;
        }
        if (memArray[ind][buy] != -1){
            return memArray[ind][buy];
        }
        long profit = 0;
        if (buy == 1){
            profit = Math.max(-1*prices[ind]+solveMemoized(prices, ind+1,0, memArray,fee)-fee,
                    solveMemoized(prices, ind+1,1, memArray,fee));
        }
        else{
            profit = Math.max(prices[ind]+solveMemoized(prices, ind+1,1, memArray,fee),
                    solveMemoized(prices, ind+1,0, memArray,fee));
        }
        return memArray[ind][buy] = profit;
    }
}
