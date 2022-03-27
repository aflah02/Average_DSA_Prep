import java.io.*;
import java.util.*;

public class Lec16OptimizeWaterDistribution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        int[] wells = new int[v];
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < wells.length; i++) {
            wells[i] = Integer.parseInt(words[i]);
        }

        int[][] pipes = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st1 = br.readLine().split(" ");
            pipes[i][0] = Integer.parseInt(st1[0]);
            pipes[i][1] = Integer.parseInt(st1[1]);
            pipes[i][2] = Integer.parseInt(st1[2]);
        }

        System.out.println(minCostToSupplyWater(v, wells, pipes));

    }

    static class Pair implements Comparable<Pair>{
        int vtx;
        int wt;
        Pair(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] pipe : pipes) {
            int u = pipe[0];
            int v = pipe[1];
            int wt = pipe[2];
            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }
        for (int i = 1; i <= n; i++){
            graph.get(i).add(new Pair(0, wells[i-1]));
            graph.get(0).add(new Pair(i, wells[i-1]));
        }
        int ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        boolean[] visited = new boolean[n+1];
        while (!pq.isEmpty()){
            Pair rem = pq.remove();
            if (visited[rem.vtx]){
                continue;
            }
            ans += rem.wt;
            visited[rem.vtx] = true;
            ArrayList<Pair> nbrs = graph.get(rem.vtx);
            for (Pair nbr: nbrs){
                if (!visited[nbr.vtx]){
                    pq.add(nbr);
                }
            }
        }
        return ans;
    }
}
