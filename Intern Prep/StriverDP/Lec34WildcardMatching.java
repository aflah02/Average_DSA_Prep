import java.util.Arrays;

public class Lec34WildcardMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "*"));
    }
    public static boolean isMatch(String s, String p) {
//        return solveRecursive(p,s,p.length()-1,s.length()-1);
//        int[][] memArray = new int[p.length()+1][s.length()+1];
//        for (int[] ls: memArray){
//            Arrays.fill(ls, -1);
//        }
//        return solveMemoized(p,s,p.length()-1,s.length()-1,memArray);
        return solveDP(p,s);
    }
    static boolean solveRecursive(String p, String s, int i, int j){
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;
        if (j < 0 && i >= 0){
            for (int ii = 0; ii <= i; ii++){
                if (p.charAt(ii) != '*') return false;
            }
            return true;
        }
        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
            return solveRecursive(p,s,i-1,j-1);
        }
        if (p.charAt(i) == '*'){
            return solveRecursive(p,s,i-1,j) || solveRecursive(p,s,i,j-1);
        }
        return false;
    }
    static boolean solveMemoized(String p, String s, int i, int j, int[][] memArray){
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;
        if (j < 0 && i >= 0){
            for (int ii = 0; ii <= i; ii++){
                if (p.charAt(ii) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (memArray[i][j] != -1){
            if (memArray[i][j] == 1){
                return true;
            }
            return false;
        }
        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
            boolean sol = solveMemoized(p,s,i-1,j-1,memArray);
            if (sol){
                memArray[i][j] = 1;
            }
            else memArray[i][j] = 0;
            return sol;
        }
        if (p.charAt(i) == '*'){
            boolean sol =  solveMemoized(p,s,i-1,j,memArray) || solveMemoized(p,s,i,j-1,memArray);
            if (sol){
                memArray[i][j] = 1;
            }
            else memArray[i][j] = 0;
            return sol;
        }
        memArray[i][j] = 0;
        return false;
    }
    static boolean solveDP(String p, String s){
        boolean[][] dpArray = new boolean[p.length()+1][s.length()+1];
        for (int i = 0; i < p.length()+1; i++){
            for (int j = 0; j < s.length()+1; j++){
                if (i == 0 && j == 0){
                    dpArray[i][j] = true;
                }
                else if (j == 0 && i > 0){
                    dpArray[i][j] = true;
                    for (int ii = 0; ii <= i-1; ii++){
                        if (p.charAt(ii) != '*') {
                            dpArray[i][j] = false;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 1; i < p.length()+1; i++){
            for (int j = 1; j < s.length()+1; j++){
                if (p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
                    dpArray[i][j] = dpArray[i-1][j-1];
                }
                else if (p.charAt(i-1) == '*') {
                    dpArray[i][j] = dpArray[i - 1][j] || dpArray[i][j - 1];
                }
            }
        }
        return dpArray[dpArray.length-1][dpArray[0].length-1];
    }
}
