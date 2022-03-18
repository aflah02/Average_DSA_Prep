import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lec7ShortestBridge {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(shortestBridge(arr));

    }

    public static class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int shortestBridge(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        LinkedList<Pair> queue = new LinkedList<>();
        Boolean[][] visited = new Boolean[m][n];
        for (Boolean[] b: visited){
            Arrays.fill(b, false);
        }
        boolean flag = false;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 1){
                    dfs(i,j,queue,visited,arr);
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                size--;
                Pair rem = queue.removeFirst();
                for (int dir = 0; dir < 4; dir++){
                    int idash = rem.row + dirs[dir][0];
                    int jdash = rem.col + dirs[dir][1];
                    if (idash < 0 || idash >= arr.length || jdash < 0 || jdash >= arr[0].length || visited[idash][jdash]){
                        continue;
                    }
                    if (arr[idash][jdash] == 1){
                        return level;
                    }
                    visited[idash][jdash] = true;
                    queue.addLast(new Pair(idash, jdash));
                }
            }
            level++;
        }
        return -1;
    }
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private static void dfs(int i, int j, LinkedList<Pair> queue, Boolean[][] visited, int[][] arr) {
        visited[i][j] = true;
        queue.addLast(new Pair(i,j));
        for (int dir = 0; dir < 4; dir++){
            int idash = i + dirs[dir][0];
            int jdash = j + dirs[dir][1];
            if (idash < 0 || idash >= arr.length || jdash < 0 || jdash >= arr[0].length || visited[idash][jdash] || arr[idash][jdash] == 0){
                continue;
            }
            dfs(idash, jdash, queue, visited, arr);
        }
    }
}
