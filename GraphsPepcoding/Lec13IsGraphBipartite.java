import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Lec13IsGraphBipartite {
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
    static class Pair{
        int v;
        String psf;
        int level;
        public Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
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
        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);
        for (int i = 0; i < vtces; i++){
            if (visited[i] == -1){
                Boolean isCompBipartite = checkComponentforBiPartiteness(graph, visited, i);
                if (!isCompBipartite){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
        // write your code here
    }

    private static Boolean checkComponentforBiPartiteness(ArrayList<Edge>[] graph, int[] visited, int src) {
        ArrayDeque<Pair> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(new Pair(src, src + "", 0));
        while (!bfsQueue.isEmpty()){
            Pair rem = bfsQueue.removeFirst();
            if (visited[rem.v] != -1){
                if (visited[rem.v] != rem.level){
                    return false;
                }
            }
            else{
                visited[rem.v] = rem.level;
            }
            for (Edge E: graph[rem.v]){
                if (visited[E.nbr] == -1){
                    bfsQueue.add(new Pair(E.nbr, rem.psf + E.nbr, rem.level+1));
                }
            }
        }
        return true;
    }
}
