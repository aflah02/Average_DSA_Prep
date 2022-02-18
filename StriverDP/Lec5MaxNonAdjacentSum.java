import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lec5MaxNonAdjacentSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int k = 0; k < n; k++){
                arr.add(sc.nextInt());
            }
            int[] memArray = new int[n];
            for (int k = 0; k < memArray.length; k++){
                memArray[k] = -1;
            }
            System.out.println(maximumNonAdjacentSum(arr, memArray));
        }

    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums, int[] memArray) {
//        return solve(nums, nums.size(), 0);
        return memoizedSolve(nums, nums.size(), 0, memArray);
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
}
