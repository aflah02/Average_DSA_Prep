import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class Lec17SwimInRisingWater {
    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int maxwsf;

        public Pair(int row, int col, int maxwsf) {
            this.row = row;
            this.col = col;
            this.maxwsf = maxwsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.maxwsf - o.maxwsf;
        }
    }
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int swimInRisingWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        while (!pq.isEmpty()){
            Pair rem = pq.remove();
            if (rem.row == n-1 && rem.col == n-1){
                return rem.maxwsf;
            }
            if (visited[rem.row][rem.col]){
                continue;
            }
            visited[rem.row][rem.col] = true;
            for (int i = 0; i < 4; i++){
                int rowdash = rem.row + dirs[i][0];
                int coldash = rem.col + dirs[i][1];
                if (rowdash < 0 || coldash < 0 || rowdash >= n || coldash >= m || visited[rowdash][coldash]){
                    continue;
                }
                pq.add(new Pair(rowdash, coldash, Math.max(rem.maxwsf, grid[rowdash][coldash])));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int [][]grid=new int [n][m];
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j) grid[i][j]=scn.nextInt();
        System.out.println(swimInRisingWater(grid));
    }
}
