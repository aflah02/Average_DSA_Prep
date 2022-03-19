import java.io.*;
import java.util.*;

public class Lec9SlidingPuzzle {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[2][3];

        for (int i = 0; i < 2; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(slidingPuzzle(arr));
    }
    public static int slidingPuzzle(int[][] board) {
        LinkedList<String> queue = new LinkedList<>();
        String tar = "123450";
        StringBuilder sb = new StringBuilder();
        for (int[] i: board){
            for (int j: i){
                sb.append(j);
            }
        }
        String initial = sb.toString();
        int[][] swapIdx = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        queue.addLast(initial);
        int level = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(initial);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                String rem = queue.removeFirst();
                if (rem.equals(tar)){
                    return level;
                }
                int idx = -1;
                for (int i = 0; i < rem.length(); i++){
                    if (rem.charAt(i) == '0'){
                        idx = i;
                        break;
                    }
                }
                int[] swap = swapIdx[idx];
                for (int possibility: swap){
                    String swapped = swapChar(rem, idx, possibility);
                    if (visited.contains(swapped)){
                        continue;
                    }
                    queue.addLast(swapped);
                    visited.add(swapped);
                }
            }
            level++;
        }
        return -1;
    }

    private static String swapChar(String rem, int p1, int p2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rem.length(); i++){
            if (i == p1){
                sb.append(rem.charAt(p2));
            }
            else if (i == p2){
                sb.append(rem.charAt(p1));
            }
            else{
                sb.append(rem.charAt(i));
            }
        }
        return sb.toString();
    }
}
