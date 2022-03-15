import java.io.*;
import java.util.*;

public class Lec3PrintAllPaths {
    // https://nados.io/question/print-all-paths
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

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        Boolean[] visited = new Boolean[vtces];
        Arrays.fill(visited, false);
        String currPath = "";
        printAllPaths(graph, src, dest, visited, currPath+src);
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest,
                                     Boolean[] visited, String currPath){
        if (src == dest){
            System.out.println(currPath);
            return;
        }
        visited[src] = true;
        for (Edge E: graph[src]){
            if (!visited[E.nbr]){
                printAllPaths(graph, E.nbr, dest, visited, currPath + (E.nbr));
            }
        }
        visited[src] = false;
    }
}
