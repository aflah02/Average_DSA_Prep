public class Lec27LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(lcs("abc", "a"));
    }
    public static int lcs(String str1, String str2) {
        // Write your code here.
        return solveDP(str1, str2);
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
                    dp[i][j] = 0;
                }
            }
        }
        for (int[] ls: dp){
            for (int i: ls){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < text1.length()+1; i++){
            for (int j = 0; j < text2.length()+1; j++){
                maxi = Math.max(maxi, dp[i][j]);
            }
        }
        return maxi;
    }
}
