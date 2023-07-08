import java.util.List;

public class Lec16MColoring {
    public static void main(String[] args) {

    }
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m)
    {
        int n = G.length;
        if (solve(G, color, i, m, n)==true){
            return true;
        }
        return false;
    }
    public static boolean solve(List<Integer>[] G, int[] color, int i, int m, int n){
        if (i == n){
            return true;
        }
        for (int idx = 1; idx <= m; idx++){
            if (isSafe(G, color, i, idx)){
                color[i] = idx;
                if (solve(G, color, i+1, m, n)){
                    return true;
                }
                color[i] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(List<Integer>[] g, int[] color, int i, int idx) {
        for (int itr: g[i]){
            if (color[itr] == idx){
                return false;
            }
        }
        return true;
    }
}
