import java.util.Arrays;

public class Lec2WaystoNthChair {
    //https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
    public static void main(String[] args) {
        int n = 64;
        long[] memArray = new long[n+1];
        Arrays.fill(memArray, -1);
        System.out.println(countDistinctWayToClimbStair(n, memArray));
    }
    public static int countDistinctWayToClimbStair(long nStairs, long[] memArray) {
        if (nStairs < 0){
            return 0;
        }
        if (nStairs == 0){
            return 1;
        }
        long nStairsOnePrev = 0, nStairsTwoPrev = 0;
        if (nStairs -1 >= 0){
            nStairsOnePrev = memArray[(int) (nStairs-1)];
            if (nStairsOnePrev == -1){
                nStairsOnePrev = countDistinctWayToClimbStair(nStairs-1, memArray);
                memArray[(int) (nStairs-1)] = nStairsOnePrev;
            }
        }
        if (nStairs -2 >= 0){
            nStairsTwoPrev = memArray[(int) (nStairs-2)];
            if (nStairsTwoPrev == -1){
                nStairsTwoPrev = countDistinctWayToClimbStair(nStairs-2, memArray);
                memArray[(int) (nStairs-2)] = nStairsTwoPrev;
            }
        }
        memArray[(int) nStairs] = nStairsOnePrev + nStairsTwoPrev;
        return (int) memArray[(int) nStairs];
    }
}
