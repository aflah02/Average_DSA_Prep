import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
public class Lec2JobSchedulingWithProfit {
    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{1,2,3,4,6},
                new int[]{3,5,10,6,9},
                new int[]{20,20,100,70,60}));
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        int n = startTime.length;
        for (int i = 0; i < n; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(startTime[i]);
            arr.add(endTime[i]);
            arr.add(profit[i]);
            input.add(arr);
        }
        input.sort(Comparator.comparing(o -> o.get(1)));
        int i = 1;
        int[] store = new int[n];
        for (int p = 0; p < n; p++){
            store[p] = input.get(p).get(2);
        }
        while (i < n){
            for (int j = 0; j < i; j++){
                if (input.get(j).get(1) <= input.get(i).get(0)){
                    store[i] = Math.max(store[i], store[j] + input.get(i).get(2));
                }
            }
            i++;
        }
        int maxi = 0;
        for (int val: store){
            maxi = Math.max(maxi, val);
        }
        return maxi;
    }
}
