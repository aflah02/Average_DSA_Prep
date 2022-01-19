public class test {
    public static void main(String[] args) {
        String s = shortestCommonSupersequence("abab", "abab");
        System.out.println(s);
    }
    static String shortestCommonSupersequence(String str1, String str2) {
        String toRet = "";
        int n = str1.length();
        int m = str2.length();
        int[][] t = new int[n+1][m+1];
        for (int i = 1; i < n+1;i++){
            for (int j = 1; j < m+1; j++){
                if (str1.charAt(i-1)==str2.charAt(j-1)&& i!=j){
                    t[i][j] = t[i-1][j-1]+1;
                }
                else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        int i = n;
        int j = m;
        while (i > 0 && j > 0){
            if (t[i][j] == t[i-1][j-1]+1){
                toRet+=str1.charAt(i-1);
                i--;
                j--;
            }
            else {
                if (t[i][j-1]>t[i-1][j]){
//                    toRet+=str2.charAt(j-1);
                    j--;
                }
                else {
//                    toRet+=str1.charAt(i-1);
                    i--;
                }
            }
        }
//        while (i > 0){
//            toRet+=str1.charAt(i-1);
//            i--;
//        }
//        while (j > 0){
//            toRet+=str2.charAt(j-1);
//            j--;
//        }
        String fin = "";
        for (int k = toRet.length()-1; k >= 0; k--){
            fin+=toRet.charAt(k);
        }
        return fin;
    }
}
