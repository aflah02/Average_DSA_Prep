import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Lec15DjikstrasAlgorithmShortestPathInWeights {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int wsf;
        String psf;
        int v;

        public Pair(int wsf, String psf, int v) {
            this.wsf = wsf;
            this.psf = psf;
            this.v = v;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, src + "", src));
        boolean[] visited = new boolean[vtces];
        while (!pq.isEmpty()){
            Pair rem = pq.remove();
            if (visited[rem.v]){
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
            for (Edge e: graph[rem.v]){
                if (!visited[e.nbr]){
                    pq.add(new Pair(rem.wsf + e.wt, rem.psf + e.nbr, e.nbr));
                }
            }
        }
    }
}
