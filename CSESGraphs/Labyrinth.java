import java.util.Scanner;

public class Labyrinth {
    static String pathFound;
    public static void main(String[] args) {
        pathFound = "";
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] labyrinth = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < n; i++){
            String s = sc.next();
            for (int j = 0; j < m; j++){
                char ij = s.charAt(j);
                if (ij == 'A'){
                    startX = i;
                    startY = j;
                }
                labyrinth[i][j] = ij;
            }
        }
        findPath(labyrinth, visited, startX, startY, "");
        if (pathFound.length() > 0){
            System.out.println("YES");
            System.out.println(pathFound.length());
            System.out.println(pathFound);
        }
        else {
            System.out.println("NO");
        }

    }
    static void findPath(char[][] labyrinth, boolean[][] visited, int i, int j, String path){
        if (i < 0 || i >= labyrinth.length || j < 0 || j >= labyrinth[0].length){
            return;
        }
        if (visited[i][j]){
            return;
        }
        if (labyrinth[i][j] == 'B'){
            pathFound = path;
        }
        if (labyrinth[i][j] == '#'){
            return;
        }
        visited[i][j] = true;
        findPath(labyrinth, visited, i+1, j, path + "D");
        findPath(labyrinth, visited, i-1, j, path + "U");
        findPath(labyrinth, visited, i, j+1, path + "R");
        findPath(labyrinth, visited, i, j-1, path + "L");
    }
}
