import java.util.Arrays;
import java.util.Scanner;

public class Lec4FrogJumpWithKDistance {
    //https://atcoder.jp/contests/dp/tasks/dp_b
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++){
            heights[i] = sc.nextInt();
        }
        int[] memArray = new int[N+1];
        Arrays.fill(memArray, Integer.MAX_VALUE);
//        System.out.println(solvePureRecursive(N-1, K, heights));
//        System.out.println(solveMemoize(N-1, K, heights, memArray));
        System.out.println(solveDP(N, K, heights));
    }

    public static int solvePureRecursive(int N, int K, int[] heights){
        if (N <= 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= K; i++){
            if (N-i >= 0){
                min = Math.min(min, solvePureRecursive(N-i, K, heights) + Math.abs(heights[N] - heights[N-i]));
            }
            else{
                break;
            }
        }
        return min;
    }
    public static int solveMemoize(int N, int K, int[] heights, int[] memArray){
        if (N <= 0){
            return 0;
        }
        if (memArray[N] != Integer.MAX_VALUE){
            return memArray[N];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= K; i++){
            if (N-i >= 0){
                min = Math.min(min, solveMemoize(N-i, K, heights, memArray) + Math.abs(heights[N] - heights[N-i]));
            }
            else{
                break;
            }
        }
        return memArray[N] = min;
    }
    public static int solveDP(int N, int K, int[] heights){
        if (N <= 0){
            return 0;
        }
        int[] dpArray = new int[N+1];
        dpArray[0] = 0;

        for (int t = 1; t < N; t++){
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= K; i++){
                if (t-i >= 0){
                    min = Math.min(min, dpArray[t-i] + Math.abs(heights[t] - heights[t-i]));
                }
                else{
                    break;
                }
            }
            dpArray[t] = min;
        }
        return dpArray[N-1];
    }
}
