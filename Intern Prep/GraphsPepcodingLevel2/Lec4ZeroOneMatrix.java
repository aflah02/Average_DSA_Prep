import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lec4ZeroOneMatrix {
    // https://leetcode.com/problems/01-matrix/
    // https://nados.io/question/zero-one-matrix?zen=true
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
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

        int[][] ans = updateMatrix(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] updateMatrix(int[][] matrix) {
        LinkedList<Pair> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    queue.addLast(new Pair(i, j));
                }
                else{
                    matrix[i][j] = -matrix[i][j];
                }
            }
        }
        while (!queue.isEmpty()){
            Pair rem = queue.removeFirst();
            for (int i = 0; i < 4; i++){
                int idash = rem.x + dirs[i][0];
                int jdash = rem.y + dirs[i][1];
                if (idash < 0 || idash >= m || jdash < 0 || jdash >= n || matrix[idash][jdash] >= 0){
                    continue;
                }
                queue.addLast(new Pair(idash, jdash));
                matrix[idash][jdash] = matrix[rem.x][rem.y] + 1;
            }
        }
        return matrix;
    }
}
