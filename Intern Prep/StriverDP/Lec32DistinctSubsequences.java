import java.util.Arrays;

public class Lec32DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
    public static int numDistinct(String s, String t) {
//        return numDistinctRecursive(s,t,s.length()-1,t.length()-1);
//        int[][] memArray = new int[s.length()][t.length()];
//        for (int[] ls: memArray){
//            Arrays.fill(ls, -1);
//        }
//        return numDistinctRecursiveMemoized(s,t,s.length(),t.length(),memArray);
        return numDistinctDP(s,t);
    }
    public static int numDistinctRecursive(String s, String t, int i, int j){
        if (j < 0){
            return 1;
        }
        if (i < 0){
            return 0;
        }
        if (s.charAt(i) == t.charAt(j)){
            return numDistinctRecursive(s,t,i-1,j-1) + numDistinctRecursive(s,t,i-1,j);
        }
        else{
            return numDistinctRecursive(s,t,i-1,j);
        }
    }
    public static int numDistinctRecursiveMemoized(String s, String t, int i, int j, int[][] memArray){
        if (j < 0){
            return 1;
        }
        if (i < 0){
            return 0;
        }
        if (memArray[i][j] != -1){
            return memArray[i][j];
        }
        if (s.charAt(i) == t.charAt(j)){
            return memArray[i][j] = numDistinctRecursiveMemoized(s,t,i-1,j-1, memArray) + numDistinctRecursiveMemoized(s,t,i-1,j, memArray);
        }
        else{
            return memArray[i][j] = numDistinctRecursiveMemoized(s,t,i-1,j, memArray);
        }
    }
    public static int numDistinctDP(String s, String t){
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length()+1; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length()+1; i++){
            for (int j = 1; j < t.length()+1; j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
