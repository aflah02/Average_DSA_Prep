public class Lec15Sudoku {
    public static void main(String[] args) {
        int a = 1;
        char b = (char)(a + '0');
        System.out.println((char)(9 + '0'));
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public static Boolean solve(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    for (char c = '1'; c <= '9'; c++){
                        if (isValid(board, i, j, c)){
                            board[i][j] = c;
                            if (solve(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static Boolean isValid(char[][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++){
            if (board[i][col] == c){
                return false;
            }
        }
        for (int i = 0; i < 9; i++){
            if (board[row][i] == c){
                return false;
            }
        }
        for (int i = 0; i < 9; i++){
            if (board[3*(row/3)+i/3][3*(col/3)+i%3] == c){
                return false;
            }
        }
        return true;
    }
}
