import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lec5MaxNonAdjacentSum {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int k = 0; k < n; k++){
                arr.add(sc.nextInt());
            }
            dp = new int[n+1];
            dp[1] = arr.get(0);
            int[] memArray = new int[n];
            for (int k = 0; k < memArray.length; k++){
                memArray[k] = -1;
            }
            System.out.println(maximumNonAdjacentSum(arr, memArray));
        }

    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums, int[] memArray) {
//        return solve(nums, nums.size(), 0);
//        return memoizedSolve(nums, nums.size(), 0, memArray);
//        return dpSolve(nums, nums.size());
        return dpSolveMemoryOptimal(nums, nums.size());
    }
    public static int solve(ArrayList<Integer> nums, int n, int i){
        if (i >= n){
            return 0;
        }
        return Math.max(nums.get(i) + solve(nums, n, i+2), solve(nums, n, i+1));
    }
    public static int memoizedSolve(ArrayList<Integer> nums, int n, int i, int[] memArray){
        if (i >= n){
            return 0;
        }
        if (memArray[i] != -1){
            return memArray[i];
        }
        return memArray[i] = Math.max(nums.get(i) + memoizedSolve(nums, n, i+2, memArray), memoizedSolve(nums, n, i+1, memArray));
    }
    public static int dpSolve(ArrayList<Integer> nums, int n){
        for (int i = 2; i <= n; i++){
            int p1 = dp[i-1];
            int p2 = Integer.MIN_VALUE;
            if (i > 1){
                p2 = dp[i-2] + nums.get(i-1);
            }
            dp[i] = Math.max(p1, p2);
        }
        return dp[n];
    }
    public static int dpSolveMemoryOptimal(ArrayList<Integer> nums, int n){
        int prev1, prev2;
        prev1 = nums.get(0);
        prev2 = 0;
        for (int i = 1; i < n; i++){
            int take = nums.get(i);
            if (i > 1){
                take += prev2;
            }
            int nottake = prev1;
            int curr = Math.max(take, nottake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
