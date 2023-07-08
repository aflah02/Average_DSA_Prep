import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lec7CountNumberofIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        Boolean[][] visited = new Boolean[m][n];
        for (Boolean[] b: visited){
            Arrays.fill(b, false);
        }
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 0 && !visited[i][j]){
                    count++;
                    getConnectedComponents(arr, visited, i, j);
                }
            }
        }
        System.out.println(count);
    }

    static void getConnectedComponents(int[][] arr, Boolean[][] visited, int i, int j){
        if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0 || arr[i][j] == 1 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        getConnectedComponents(arr, visited, i-1, j);
        getConnectedComponents(arr, visited, i+1, j);
        getConnectedComponents(arr, visited, i, j-1);
        getConnectedComponents(arr, visited, i, j+1);
    }
}
