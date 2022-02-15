import java.util.ArrayList;

public class Lec17RatInAMaze {
    public static void main(String[] args) {

    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> store = new ArrayList<>();
        int[][] vis = new int[m.length][m[0].length];
        solve(store, m, n, 0, 0, "", vis);
        return store;
    }

    private static void solve(ArrayList<String> store, int[][] m, int n, int i, int j, String currPath, int[][] vis) {
        if (i == n-1 && j == n-1){
            store.add(currPath);
            return;
        }
        if (i+1 < n && vis[i+1][j] == 0 && m[i+1][j] != 0){
            vis[i][j] = 1;
            // currPath += "D";
            solve(store, m, n, i + 1, j, currPath + "D", vis);
            vis[i][j] = 0;
        }
        if (j+1 < n && vis[i][j+1] == 0 && m[i][j+1] != 0){
            vis[i][j] = 1;
            // currPath += "R";
            solve(store, m, n, i, j+1, currPath + "R", vis);
            vis[i][j] = 0;
        }
        if (i-1 >= 0 && vis[i-1][j] == 0 && m[i-1][j] != 0){
            vis[i][j] = 1;
            // currPath += "U";
            solve(store, m, n, i-1, j, currPath + "U", vis);
            vis[i][j] = 0;
        }
        if (j-1 >= 0 && vis[i][j-1] == 0 && m[i][j-1] != 0){
            vis[i][j] = 1;
            // currPath += "L";
            solve(store, m, n, i, j-1, currPath + "L", vis);
            vis[i][j] = 0;
        }
    }
}
