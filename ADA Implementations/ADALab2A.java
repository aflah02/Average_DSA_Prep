import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class ADALab2A {
    static class Pair{
        int x1;
        int y1;
        int x2;
        int y2;
        Pair(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        int zereosininput = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(String.valueOf(s.charAt(j)));
                if (val == 0){
                    zereosininput++;
                }
                grid[i][j] = val;
            }
        }
        int[][] indegrees = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        indegrees[i][j]++;
                    }
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        indegrees[i][j]++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        indegrees[i][j]++;
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        indegrees[i][j]++;
                    }
                }
            }
        }
        int zeroCount = 0;
        boolean flag = false;
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (indegrees[i][j] == 0) {
                    zeroCount++;
                    continue;
                }
                if (indegrees[i][j] > 0) {
                    int indegreeRight = 0;
                    if (j+1 < n && grid[i][j+1] == 1) {
                        indegreeRight = indegrees[i][j + 1];
                    }
                    int indegreeDown = 0;
                    if (i+1 < n && grid[i+1][j] == 1) {
                        indegreeDown = indegrees[i + 1][j];
                    }
                    if (indegreeRight == 0 && indegreeDown == 0) {
                        flag = true;
                        break;
                    }
                    else if ((indegreeRight >= indegreeDown && indegreeDown != 0) || (indegreeRight == 0 && indegreeDown != 0)) {
                        pairs.add(new Pair(i, j, i+1, j));
                        indegrees[i][j] = 0;
                        indegrees[i + 1][j] = 0;
                        if (j-1 >= 0 && indegrees[i][j-1] > 0) {
                            indegrees[i][j-1]--;
                        }
                        if (j-1 >= 0 && indegrees[i+1][j-1] > 0) {
                            indegrees[i+1][j-1] --;
                        }
                        if (j+1 < n && indegrees[i][j+1] > 0) {
                            indegrees[i][j+1]--;
                        }
                        if (j+1 < n && indegrees[i+1][j+1] > 0) {
                            indegrees[i+1][j+1]--;
                        }
                        if (i-1 >= 0 && indegrees[i-1][j] > 0) {
                            indegrees[i-1][j]--;
                        }
                        if (i+2 < n && indegrees[i+2][j] > 0) {
                            indegrees[i+2][j]--;
                        }
                    }
                    else {
                        pairs.add(new Pair(i, j, i, j+1));
                        indegrees[i][j] = 0;
                        indegrees[i][j + 1] = 0;
                        if (i-1 >= 0 && indegrees[i-1][j] > 0) {
                            indegrees[i-1][j]--;
                        }
                        if (i-1 >= 0 && indegrees[i-1][j+1] > 0) {
                            indegrees[i-1][j+1]--;
                        }
                        if (i+1 < n && indegrees[i+1][j] > 0) {
                            indegrees[i+1][j]--;
                        }
                        if (i+1 < n && indegrees[i+1][j+1] > 0) {
                            indegrees[i+1][j+1]--;
                        }
                        if (j-1 >= 0 && indegrees[i][j-1] > 0) {
                            indegrees[i][j-1]--;
                        }
                        if (j+2 < n && indegrees[i][j+2] > 0) {
                            indegrees[i][j+2]--;
                        }
                    }
                }
            }
        }
        if (flag || zeroCount == n*n || zeroCount != ((n*n)-zereosininput)/2 + zereosininput) {
            System.out.println(0);
        }
        else {
            System.out.println(1);
            System.out.println(pairs.size());
            for (Pair p : pairs) {
                System.out.println((p.x1+1) + " " + (p.y1+1) + " " + (p.x2+1) + " " + (p.y2+1));
            }
        }
    }
}