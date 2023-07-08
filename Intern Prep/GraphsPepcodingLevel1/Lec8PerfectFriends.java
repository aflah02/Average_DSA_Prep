import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Lec8PerfectFriends {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < k; i++){
            String[] parts = br.readLine().split(" ");
            int part1 = Integer.parseInt(parts[0]);
            int part2 = Integer.parseInt(parts[1]);
            graph[part1].add(new Edge(part1, part2));
            graph[part2].add(new Edge(part2, part1));
        }
        ArrayList<Integer> compSizes = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                ArrayList<Integer> store = new ArrayList<>();
                drawTree(visited, i, graph, store);
                compSizes.add(store.size());
            }
        }
        int val = 0;
        for (int i = 0; i < compSizes.size(); i++){
            for (int j = i+1; j < compSizes.size(); j++){
                val += compSizes.get(i)*compSizes.get(j);
            }
        }
        System.out.println(val);
    }

    static void drawTree(boolean[] visited, int src, ArrayList<Edge>[] graph, ArrayList<Integer> store){
        visited[src] = true;
        store.add(src);
        for (Edge E: graph[src]){
            if (!visited[E.nbr]){
                drawTree(visited, E.nbr, graph, store);
            }
        }
    }
}
