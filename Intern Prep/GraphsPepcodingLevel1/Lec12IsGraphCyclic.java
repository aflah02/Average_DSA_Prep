import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Lec12IsGraphCyclic {
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
        Pair(int v, String psf){
            this.v = v;
            this.psf = psf;
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
        Boolean cycleFound = false;
        Boolean[] visited = new Boolean[vtces];
        Arrays.fill(visited, false);
        for (int i = 0; i < vtces; i++){
            if (!visited[i]){
                ArrayDeque<Pair> bfsQueue = new ArrayDeque<>();
                bfsQueue.add(new Pair(i, i + ""));
                while (!bfsQueue.isEmpty()){
                    Pair rem = bfsQueue.removeFirst();
                    if (visited[rem.v]){
                        cycleFound = true;
                        break;
                    }
                    visited[rem.v] = true;
                    for (Edge e: graph[rem.v]){
                        if (visited[e.nbr]){
                            continue;
                        }
                        bfsQueue.add(new Pair(e.nbr, rem.psf + e.nbr));
                    }
                }
            }
            if (cycleFound){
                break;
            }
        }
        if (cycleFound){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
