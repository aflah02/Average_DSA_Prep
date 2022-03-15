import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Lec14SpreadofInfection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    static class Pair {
        int v;
        int t;
        Pair(int v, int t){
            this.v = v;
            this.t = t;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int[] visited = new int[vtces];
        Arrays.fill(visited, 0);
        int count = findInfected(graph, visited, t, src);
        System.out.println(count);
    }
    static int findInfected(ArrayList<Edge>[] graph, int[] visited, int t, int src){
        int count = 0;
        ArrayDeque<Pair> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(new Pair(src, 1));
        while (!bfsQueue.isEmpty()){
            Pair rem = bfsQueue.removeFirst();
            if (visited[rem.v] > 0){
                continue;
            }
            visited[rem.v] = rem.t;
            if (rem.t > t){
                break;
            }
            count++;
            for (Edge e: graph[rem.v]){
                if (visited[e.nbr] == 0) {
                    bfsQueue.add(new Pair(e.nbr, rem.t + 1));
                }
            }
        }
        return count;
    }

}
