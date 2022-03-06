public class Lec28LongestPanlindromicSubsequence {
    public static void main(String[] args) {
        String s = "abababns";
        StringBuilder s2 = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--){
            s2.append(s.charAt(i));
        }
        System.out.println(solveDP(s, s2.toString()));
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
