import java.util.*;
import java.io.*;

public class Lec1ColoringABorder {
    static int[][] dirs = {{0,1},{1,0},{0,-1}, {-1, 0}};
    // https://nados.io/question/coloring-a-border?zen=true
    public static void coloring_border(int [][] arr, int row, int col, int color){
        dfs(arr, row, col, arr[row][col]);
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (arr[i][j] < 0){
                    arr[i][j] = color;
                }
            }
        }
    }

    public static void dfs(int[][] arr, int row, int col, int clr){
        int count = 0;
        arr[row][col] = -1 * clr;
        for (int i = 0; i < 4; i++){
            int rowdash = row + dirs[i][0];
            int coldash = col + dirs[i][1];
            if (rowdash < 0 || rowdash >= arr.length ||
                    coldash < 0 || coldash >= arr[0].length ||
                    Math.abs(arr[rowdash][coldash]) != clr){
                continue;
            }
            count++;
            if (arr[rowdash][coldash] == clr){
                dfs(arr, rowdash, coldash, clr);
            }
        }
        if (count == 4){
            arr[row][col] = clr;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }
        st = br.readLine().split(" ");
        int row = Integer.parseInt(st[0]);
        int col = Integer.parseInt(st[1]);
        int color = Integer.parseInt(st[2]);

        coloring_border(arr,row,col,color);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
