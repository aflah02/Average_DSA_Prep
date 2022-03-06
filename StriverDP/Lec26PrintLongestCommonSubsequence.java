import java.util.ArrayList;

public class Lec26PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(solveDP("cabac", "abac"));
    }
    static String solveDP(String text1, String text2){
        int[][] dp = new int[text1.length()+1][text2.length()+1];
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
//        return dp[dp.length-1][dp[0].length-1];
        int n = dp.length-1;
        int m = dp[0].length-1;
        StringBuilder s = new StringBuilder();
        while (n > 0 && m > 0){
            if (text1.charAt(n-1) == text2.charAt(m-1)){
                s.append(text1.charAt(n-1));
                n--;
                m--;
            }
            else{
                if (dp[n-1][m] > dp[n][m-1]){
//                    s.append(text1.charAt(n));
                    n--;
                }
                else{
//                    s.append(text2.charAt(m));
                    m--;
                }
            }
        }
        String rev = s.toString();
        String ret = "";
        for (int i = rev.length()-1; i >= 0; i--){
            ret += rev.charAt(i);
        }
        return ret;

    }
}
