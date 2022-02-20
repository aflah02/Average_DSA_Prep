import java.util.ArrayList;
import java.util.Collections;
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
        int n = triangle.size();
        List<List<Integer>> memArray = new ArrayList<>();
        for (int i = 0; i < n; i++){
            memArray.add(new ArrayList<>());
            for (int j = 0; j < i+1; j++){
                memArray.get(i).add(-1);
            }
        }
//        return solveMemoized(triangle, triangle.size(), 0, 0, memArray);
        return solveDP(triangle, triangle.size());
    }
    public static int solveRecursive(List<List<Integer>> triangle, int n, int i, int j){
        if (i == n-1){
            return triangle.get(n-1).get(j);
        }
        if (i > n-1 || j > i){
            return Integer.MAX_VALUE;
        }
        return triangle.get(i).get(j) + Math.min(solveRecursive(triangle, n, i+1, j),
                solveRecursive(triangle, n, i+1, j+1));
    }
    public static int solveMemoized(List<List<Integer>> triangle, int n, int i, int j, List<List<Integer>> memArray){
        if (i == n-1){
            return triangle.get(n-1).get(j);
        }
        if (i > n-1 || j > i){
            return Integer.MAX_VALUE;
        }
        if (memArray.get(i).get(j) != -1){
            return memArray.get(i).get(j);
        }
        memArray.get(i).set(j, triangle.get(i).get(j) +
                Math.min(solveMemoized(triangle, n, i+1, j, memArray),
                solveMemoized(triangle, n, i+1, j+1, memArray)));
        return memArray.get(i).get(j);
    }
    public static int solveDP(List<List<Integer>> triangle, int n){
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            dp.add(new ArrayList<>());
            for (int j = 0; j < i+1; j++){
                dp.get(i).add(Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i+1; j++){
                if (i == 0){
                    dp.get(i).set(j, triangle.get(i).get(j));
                    continue;
                }
                int justUp = triangle.get(i).get(j);
                int shiftedUp = triangle.get(i).get(j);
                if (i > j){
                    justUp += dp.get(i-1).get(j);
                }
                else{
                    justUp = Integer.MAX_VALUE;
                }
                if (j > 0){
                    shiftedUp += dp.get(i-1).get(j-1);
                }
                else{
                    shiftedUp = Integer.MAX_VALUE;
                }
                dp.get(i).set(j, Math.min(shiftedUp, justUp));
            }
        }
        for (List<Integer> ls: dp){
            for (int i: ls){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        int minFound = Integer.MAX_VALUE;
        for (int i: dp.get(n-1)){
            if (i < minFound){
                minFound = i;
            }
        }
        return minFound;
    }
}
