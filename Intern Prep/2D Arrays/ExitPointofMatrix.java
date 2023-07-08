import java.util.Scanner;

public class ExitPointofMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int a = 0;
        int b = 0;
        boolean east = true;
        boolean west = false;
        boolean north = false;
        boolean south = false;
        while (a < n && b < m){
            if (matrix[a][b] == 1){
                if (east){
                    east = false;
                    south = true;
                    a++;
                }
                else if (south){
                    west = true;
                    south = false;
                    b--;
                }
                else if (west){
                    west = false;
                    north = true;
                    a--;
                }
                else if (north){
                    east = true;
                    north = false;
                    b++;
                }
            }
            else{
                if (east){
                    b++;
                }
                else if (west){
                    b--;
                }
                else if (north){
                    a--;
                }
                else if (south){
                    a++;
                }
            }
        }
        if (a >= n){
            System.out.println(a-1);
            System.out.println(b);
        }
        else{
            System.out.println(a);
            System.out.println(b-1);
        }
    }
}
