import java.util.ArrayList;
import java.util.List;

public class Lec14NQueensLessOptimized {
    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(4);
        for (List<String> ls: solutions){
            for (String s: ls){
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println(solutions.size());
    }
    public static List<List<String>> solveNQueens(int n) {
        StringBuilder dottedString = new StringBuilder();
        dottedString.append(".".repeat(Math.max(0, n)));
        List<List<String>> store = new ArrayList<>();
        List<String> baseBoard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            baseBoard.add(dottedString.toString());
        }
        solve(store, baseBoard, 0, n);
        return store;
    }
    public static void solve(List<List<String>> store, List<String> baseBoard, int col, int n){
        if (col == n){
            store.add(new ArrayList<>(baseBoard));
            return;
        }
        for (int row = 0; row < n; row++){
            if (isSafe(baseBoard, row, col, n)){
                baseBoard.set(row, baseBoard.get(row).substring(0, col) + "Q" + baseBoard.get(row).substring(col+1));
                solve(store, baseBoard, col+1, n);
                baseBoard.set(row, baseBoard.get(row).substring(0, col) + "." + baseBoard.get(row).substring(col+1));
            }
        }
    }

    private static boolean isSafe(List<String> baseBoard, int row, int col, int n) {
        int row_og = row;
        int col_og = col;
        while (col >= 0){
            if (baseBoard.get(row).charAt(col) == 'Q'){
                return false;
            }
            col--;
        }
        col = col_og;
        while (row >= 0 && col >= 0){
            if (baseBoard.get(row).charAt(col) == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        row = row_og;
        col = col_og;
        while (row < n && col >= 0){
            if (baseBoard.get(row).charAt(col) == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
}
