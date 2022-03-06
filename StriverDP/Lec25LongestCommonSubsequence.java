import java.util.Arrays;

public class Lec25LongestCommonSubsequence {
    // https://leetcode.com/problems/longest-common-subsequence/
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ap", "defg"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
//        int[][] memArray = new int[text1.length()][text2.length()];
//        for (int[] ls: memArray){
//            Arrays.fill(ls, -1);
//        }
//        return solveMemoized(text1, text2, text1.length()-1, text2.length()-1, memArray);
//        return solveRecursive(text1, text2, text1.length()-1, text2.length()-1);
        return solveDP(text1, text2);
    }
    static int solveRecursive(String text1, String text2, int i, int j){
        if (i < 0 || j < 0){
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)){
            return 1 + solveRecursive(text1, text2, i-1, j-1);
        }
        else{
            return Math.max(solveRecursive(text1, text2, i-1, j),
                    solveRecursive(text1, text2, i, j-1));
        }
    }
    static int solveMemoized(String text1, String text2, int i, int j, int[][] memArray){
        if (i < 0 || j < 0){
            return 0;
        }
        if (memArray[i][j] != -1) {
            return memArray[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)){
            return memArray[i][j] = 1 + solveMemoized(text1, text2, i-1, j-1, memArray);
        }
        else{
            return memArray[i][j] = Math.max(solveMemoized(text1, text2, i-1, j, memArray),
                    solveMemoized(text1, text2, i, j-1, memArray));
        }
    }
    static int solveDP(String text1, String text2){
        int[][] dp = new int[text1.length()+1][text2.length()+1];
//        for (int i = 0; i < text1.length(); i++){
//            if (text1.charAt(i) == text2.charAt(0)){
//                dp[i][0] = 1;
//            }
//        }
//        for (int i = 0; i < text2.length(); i++){
//            if (text2.charAt(i) == text1.charAt(0)){
//                dp[0][i] = 1;
//            }
//        }
        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        for (int[] ls: dp){
            for (int i: ls){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
