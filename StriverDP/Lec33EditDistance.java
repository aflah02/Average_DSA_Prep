import java.util.Arrays;

public class Lec33EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("a", "ab"));
    }
        public static int minDistance(String word1, String word2) {
//        return minDistanceRecursive(word1, word2, word1.length()-1, word2.length()-1);
//            if (word1.equals(word2)){
//                return 0;
//            }
//            int[][] memArray = new int[word1.length()+1][word2.length()+1];
//            for (int[] ls: memArray){
//                Arrays.fill(ls,-1);
//            }
//            return minDistanceMemoized(word1,word2,word1.length()-1,word2.length()-1,memArray);
            return minDistanceDP(word1, word2);
        }
        public static int minDistanceRecursive(String word1, String word2, int i, int j){
            if (j < 0){
                return i+1;
            }
            if (i < 0){
                return j+1;
            }
            if (word1.charAt(i) == word2.charAt(j)){
                return minDistanceRecursive(word1, word2, i-1, j-1);
            }
            else{
                return 1+Math.min(Math.min(minDistanceRecursive(word1, word2, i, j-1), minDistanceRecursive(word1, word2, i-1,j)), minDistanceRecursive(word1, word2, i-1, j-1));
            }
        }
        public static int minDistanceMemoized(String word1, String word2, int i, int j, int[][] memArray){
            if (j < 0){
                return i+1;
            }
            if (i < 0){
                return j+1;
            }

            if (memArray[i][j] != -1){
                return memArray[i][j];
            }
            if (word1.charAt(i) == word2.charAt(j)){
                return memArray[i][j] = minDistanceMemoized(word1, word2, i-1, j-1, memArray);
            }
            else{
                return memArray[i][j] = 1 + Math.min(Math.min(minDistanceMemoized(word1, word2, i, j-1,memArray), minDistanceMemoized(word1, word2, i-1,j, memArray)), minDistanceMemoized(word1, word2, i-1, j-1, memArray));
            }
        }
    public static int minDistanceDP(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length()+1; i++){
            for (int j = 0; j < word2.length()+1; j++){
                if (i == 0){
                    dp[i][j] = j;
                }
                if (j == 0){
                    dp[i][j] = i;
                }
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i < word1.length()+1; i++){
            for (int j = 1; j < word2.length()+1; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
