public class Lec30MinimumInsertionsAndDeletionsToConvertOneStringToAnother {
    public static void main(String[] args) {
        System.out.println(minInsertionAndDeletions("abcd", "abe"));
    }
    public static int minInsertionAndDeletions(String s, String target) {
        int common = solveDP(s, target);
        int extraAdded = target.length() - common;
        int extraRemoved = s.length() - common;
        return extraAdded + extraRemoved;
    }
    static int solveDP(String text1, String text2){
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
        return dp[dp.length-1][dp[0].length-1];
    }
}
