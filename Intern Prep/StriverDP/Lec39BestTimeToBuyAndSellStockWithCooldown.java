import java.util.Arrays;

public class Lec39BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
//        return (int) solveRecursive(prices, 0, 1);
        long[][] memArray = new long[prices.length+1][2];
        for (long[] ls: memArray){
            Arrays.fill(ls, -1);
        }
        return (int) solveMemoized(prices, 0, 1, memArray);
    }
    static long solveRecursive(int[] prices, int ind, int buy){
        if (ind >= prices.length){
            return 0;
        }
        long profit = 0;
        if (buy == 1){
            profit = Math.max(-1*prices[ind]+solveRecursive(prices, ind+1,0),
                    solveRecursive(prices, ind+1,1));
        }
        else{
            profit = Math.max(prices[ind]+solveRecursive(prices, ind+2,1),
                    solveRecursive(prices, ind+1,0));
        }
        return profit;
    }
    static long solveMemoized(int[] prices, int ind, int buy, long[][] memArray){
        if (ind >= prices.length){
            return 0;
        }
        if (memArray[ind][buy] != -1){
            return memArray[ind][buy];
        }
        long profit = 0;
        if (buy == 1){
            profit = Math.max(-1*prices[ind]+solveMemoized(prices, ind+1,0, memArray),
                    solveMemoized(prices, ind+1,1, memArray));
        }
        else{
            profit = Math.max(prices[ind]+solveMemoized(prices, ind+2,1, memArray),
                    solveMemoized(prices, ind+1,0, memArray));
        }
        return memArray[ind][buy] = profit;
    }
}
