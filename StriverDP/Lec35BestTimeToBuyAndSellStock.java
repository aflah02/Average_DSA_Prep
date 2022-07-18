import java.util.ArrayList;

public class Lec35BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }
    public static int maximumProfit(ArrayList<Integer> prices){
        int[] minPrev = new int[prices.size()];
        minPrev[0] = prices.get(0);
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.size(); i++){
            minPrev[i] = Math.min(minPrev[i-1], prices.get(i));
            maxProfit = Math.max(maxProfit, prices.get(i)- minPrev[i-1]);
        }
        if (maxProfit < 0) return 0;
        return maxProfit;
    }
}
