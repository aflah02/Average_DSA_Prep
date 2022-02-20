import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lec11Triangle {
//    Input -
//            4
//            2
//            3 4
//            6 5 7
//            4 1 8 3
//    Link - https://leetcode.com/problems/triangle/
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            triangle.add(new ArrayList<>());
            for (int j = 0; j < i+1; j++){
                triangle.get(i).add(sc.nextInt());
            }
        }
        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        return solveRecursive(triangle, triangle.size(), 0, 0);
    }
    public static int solveRecursive(List<List<Integer>> triangle, int n, int i, int j){
        if (i == n-1 || j == n-1){
            return 0;
        }
        return Math.max(triangle.get(i).get(j) + solveRecursive(triangle, n, i+1, j),
                triangle.get(i).get(j+1) + solveRecursive(triangle, n, i+1, j+1));
    }
}
