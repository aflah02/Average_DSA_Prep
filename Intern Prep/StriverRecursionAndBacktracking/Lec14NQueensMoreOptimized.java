import java.util.ArrayList;
import java.util.List;

public class Lec14NQueensMoreOptimized {
    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(8);
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
        int[] leftDiag = new int[2*n-1];
        int[] rightDiag = new int[2*n-1];
        int[] row = new int[n];
        List<List<String>> store = new ArrayList<>();
        List<String> baseBoard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            baseBoard.add(dottedString.toString());
        }
        solve(store, baseBoard, 0, n, leftDiag, rightDiag, row);
        return store;
    }
    public static void solve(List<List<String>> store, List<String> baseBoard, int col, int n, int[] leftDiag, int[] rightDiag, int[] rowList){
        if (col == n){
            store.add(new ArrayList<>(baseBoard));
            return;
        }
        for (int row = 0; row < n; row++){
            if (leftDiag[(n-1)-(row-col)] == 0 && rightDiag[row+col] == 0 && rowList[row] == 0){
                baseBoard.set(row, baseBoard.get(row).substring(0, col) + "Q" + baseBoard.get(row).substring(col+1));
                leftDiag[(n-1)-(row-col)] = 1;
                rightDiag[row+col] = 1;
                rowList[row] = 1;
                solve(store, baseBoard, col+1, n, leftDiag, rightDiag, rowList);
                baseBoard.set(row, baseBoard.get(row).substring(0, col) + "." + baseBoard.get(row).substring(col+1));
                leftDiag[(n-1)-(row-col)] = 0;
                rightDiag[row+col] = 0;
                rowList[row] = 0;
            }
        }
    }
}
