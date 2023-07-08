import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

public class Lec3NumberOfDistinctIslands {
    // https://nados.io/question/number-of-distinct-island?zen=true
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(numDistinctIslands(arr));

    }

    public static StringBuilder psf = new StringBuilder();

    public static int numDistinctIslands(int[][] arr) {
        HashSet<String> islandStore = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (arr[i][j] != 0){
                    psf = new StringBuilder();
                    psf.append("x");
                    dfs(arr, i, j);
                    islandStore.add(psf.toString());
                }
            }
        }
        return islandStore.size();
    }

    public static void dfs(int[][] arr, int i, int j){
        arr[i][j] = 0;
        if (i-1>=0 && arr[i-1][j] == 1){
            psf.append("u");
            dfs(arr,i-1,j);
        }
        if (j+1<arr[0].length && arr[i][j+1] == 1){
            psf.append("r");
            dfs(arr,i,j+1);
        }
        if (i+1<arr.length && arr[i+1][j] == 1){
            psf.append("d");
            dfs(arr,i+1,j);
        }
        if (j-1>=0 && arr[i][j-1] == 1){
            psf.append("l");
            dfs(arr,i,j-1);
        }
        psf.append("z");
    }
}
