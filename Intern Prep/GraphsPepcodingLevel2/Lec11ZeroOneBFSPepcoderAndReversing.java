import java.io.*;
import java.util.*;

public class Lec11ZeroOneBFSPepcoderAndReversing{
    public static class Pair{
        int v;
        int wt;

        Pair(int v,int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++){
            st = br.readLine().split(" ");
            int from = Integer.parseInt(st[0])-1;
            int to = Integer.parseInt(st[1])-1;
            graph.get(from).add(new Pair(to, 0));
            graph.get(to).add(new Pair(from, 1));
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(0, 0));
        boolean[] visited = new boolean[n];
        while(!queue.isEmpty()){
            Pair rem = queue.removeFirst();
            if (rem.v == n-1){
                System.out.println(rem.wt);
                return;
            }
            visited[rem.v] = true;
            for(Pair p: graph.get(rem.v)){
                if (visited[p.v]){
                    continue;
                }
                if (p.wt == 0){
                    queue.addFirst(new Pair(p.v, rem.wt));
                }
                else{
                    queue.addLast(new Pair(p.v, rem.wt + 1));
                }
            }
        }
        System.out.println(-1);
    }
}
