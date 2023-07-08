import java.util.Scanner;

public class CountingRooms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] squares = new char[n][m];
        for (int i = 0; i < n; i++){
            String s = sc.next();
            for (int j = 0; j < m; j++){
                squares[i][j] = s.charAt(j);
            }
        }
        int roomCount = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visited[i][j]){
                    if (squares[i][j] == '.'){
                        roomCount++;
                        visitedAllConnectedViaDFS(squares, visited, i, j);
                    }
                }
            }
        }
        System.out.println(roomCount);
    }
    static void visitedAllConnectedViaDFS(char[][] squares, boolean[][] visited, int i, int j){
        if (i < 0 || i >= squares.length || j < 0 || j >= squares[0].length){
            return;
        }
        if (visited[i][j]){
            return;
        }
        if (squares[i][j] == '#'){
            return;
        }
        visited[i][j] = true;
        visitedAllConnectedViaDFS(squares, visited, i+1, j);
        visitedAllConnectedViaDFS(squares, visited, i-1, j);
        visitedAllConnectedViaDFS(squares, visited, i, j+1);
        visitedAllConnectedViaDFS(squares, visited, i, j-1);
    }
}
