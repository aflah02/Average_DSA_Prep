import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

public class Lec2NumberOfEnclaves {
    // https://nados.io/question/number-of-enclaves?zen=true
    // https://leetcode.com/problems/number-of-enclaves/
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
        Boolean[][] visited = new Boolean[arr.length][arr[0].length];
        for (Boolean[] b: visited){
            Arrays.fill(b, false);
        }
        System.out.println(numEnclaves(arr, visited));

    }

    public static int numEnclaves(int[][] arr, Boolean[][] visited){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (i == 0 || i == arr.length-1 || j == 0 || j == arr[0].length-1){
                    if (arr[i][j] == 1 && !visited[i][j]){
                        explore(arr, visited, i, j);
                    }
                }
            }
        }
        int count = 0;
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                if (ints[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void explore(int[][] arr, Boolean[][] visited, int i, int j) {
        if (i >= arr.length || i < 0 || j >= arr[0].length || j < 0 || arr[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        arr[i][j] = -arr[i][j];
        explore(arr, visited, i+1, j);
        explore(arr, visited, i-1, j);
        explore(arr, visited, i, j+1);
        explore(arr, visited, i, j-1);
    }
}
