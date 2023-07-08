import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lec6HouseRobber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int k = 0; k < n; k++){
                arr[k] = sc.nextInt();
            }
            System.out.println(houseRobber(arr));
        }
    }
    public static long houseRobber(int[] valueInHouse) {
        if (valueInHouse.length == 1){
            return valueInHouse[0];
        }
        int[] memArray = new int[valueInHouse.length];
        for (int k = 0; k < memArray.length; k++){
            memArray[k] = -1;
        }
        int[] firstSkipped = new int[valueInHouse.length-1];
        for (int i = 1; i < valueInHouse.length; i++){
            firstSkipped[i-1] = valueInHouse[i];
        }
        int[] lastSkipped = new int[valueInHouse.length-1];
        for (int i = 0; i < valueInHouse.length-1; i++){
            lastSkipped[i] = valueInHouse[i];
        }
//        return Math.max(solveRecursive(lastSkipped, lastSkipped.length, 0),
//                solveRecursive(firstSkipped, firstSkipped.length, 0));
//        long lastSkip = solveMemoized(lastSkipped, lastSkipped.length, 0, memArray);
//        for (int k = 0; k < memArray.length; k++){
//            memArray[k] = -1;
//        }
//        long firstSkip = solveMemoized(firstSkipped, firstSkipped.length, 0, memArray);
//        return Math.max(lastSkip, firstSkip);
        return Math.max(dpSolveMemoryOptimal(firstSkipped, firstSkipped.length),
                dpSolveMemoryOptimal(lastSkipped, lastSkipped.length));
    }
    public static long solveRecursive(int[] valueInHouse, int n, int i){
        if (i >= n){
            return 0;
        }
        return Math.max(valueInHouse[i] + solveRecursive(valueInHouse, n, i+2),
                    solveRecursive(valueInHouse, n, i+1));
    }
    public static int solveMemoized(int[] valueInHouse, int n, int i, int[] memArray){
        if (i >= n){
            return 0;
        }
        if (memArray[i] != -1){
            return memArray[i];
        }
        return memArray[i] = Math.max(valueInHouse[i] + solveMemoized(valueInHouse, n, i+2, memArray),
                solveMemoized(valueInHouse, n, i+1, memArray));
    }
    public static int dpSolveMemoryOptimal(int[] nums, int n){
        int prev1, prev2;
        prev1 = nums[0];
        prev2 = 0;
        for (int i = 1; i < n; i++){
            int take = nums[i];
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
