import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lec5RottingOranges {
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

        System.out.println(orangesRotting(arr));

    }

    public static class Pair {
        int row;
        int col;
        int time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

    }
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int orangesRotting(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    queue.addLast(new Pair(i,j,0));
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()){
            Pair rem = queue.removeFirst();
            int row = rem.row;
            int col = rem.col;
            if (grid[row][col] <= 0){
                continue;
            }
            time = Math.max(time,rem.time);
            grid[row][col] = -2;
            if (row-1 >= 0 && grid[row-1][col] == 1){
                queue.addLast(new Pair(row-1, col, rem.time+1));
            }
            if (col-1 >= 0 && grid[row][col-1] == 1){
                queue.addLast(new Pair(row, col-1,rem.time+1));
            }
            if (col+1 < n && grid[row][col+1] == 1){
                queue.addLast(new Pair(row, col+1,rem.time+1));
            }
            if (row+1 < m && grid[row+1][col] == 1){
                queue.addLast(new Pair(row+1, col,rem.time+1));
            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

}
