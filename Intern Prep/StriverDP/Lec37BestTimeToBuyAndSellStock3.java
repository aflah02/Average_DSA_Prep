import java.util.Arrays;

public class Lec37BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        long[][][] memArray = new long[prices.length+1][2][3];
        for (long[][] ls: memArray){
            for (long[] ls2: ls){
                Arrays.fill(ls2, -1);
            }

        }
        return (int) solveMemoized(prices, 0, 1, memArray, 2);
    }
    static long solveMemoized(int[] prices, int ind, int buy, long[][][] memArray, int transactions){
        if (ind == prices.length || transactions == 0){
            return 0;
        }
        if (memArray[ind][buy][transactions] != -1){
            return memArray[ind][buy][transactions];
        }
        long profit = 0;
        if (buy == 1){
            profit = Math.max(-1*prices[ind]+solveMemoized(prices, ind+1,0, memArray, transactions),
                    solveMemoized(prices, ind+1,1, memArray, transactions));
        }
        else{
            profit = Math.max(prices[ind]+solveMemoized(prices, ind+1,1, memArray, transactions-1),
                    solveMemoized(prices, ind+1,0, memArray, transactions));
        }
        return memArray[ind][buy][transactions] = profit;
    }
}
