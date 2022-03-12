import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Lec6IsGraphConnected {
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

        Boolean[] visited = new Boolean[vtces];
        Arrays.fill(visited, false);
        traverseGraph(graph, visited, 0);
        for (Boolean b: visited){
            if (b){
                vtces--;
            }
        }
        System.out.println(vtces == 0);
    }

    static void traverseGraph(ArrayList<Edge>[] graph, Boolean[] visited, int src){
        visited[src] = true;
        for (Edge E: graph[src]){
            if (!visited[E.nbr]){
                traverseGraph(graph, visited, E.nbr);
            }
        }
    }
}
