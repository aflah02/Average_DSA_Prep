import java.io.*;
import java.util.*;

public class Lec9HamiltonianPathAndCycle {
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

        HashSet<Integer> visited = new HashSet<>();
        hamiltonianPaths(graph, src, src+ "", visited, src);
    }
    public static void hamiltonianPaths(ArrayList<Edge>[] graph, int src, String currPath, HashSet<Integer> visited, int osrc){
        if (visited.size() == graph.length-1){
            System.out.print(currPath);
            Boolean found = false;
            for (Edge E: graph[src]){
                if (E.nbr == osrc){
                    found = true;
                    System.out.println("*");
                }
            }
            if (!found){
                System.out.println(".");
            }
            return;
        }
        visited.add(src);
        for (Edge E: graph[src]){
            if (!visited.contains(E.nbr)){
                hamiltonianPaths(graph, E.nbr, currPath + (E.nbr), visited, osrc);
            }
        }
        visited.remove(src);
    }
}
