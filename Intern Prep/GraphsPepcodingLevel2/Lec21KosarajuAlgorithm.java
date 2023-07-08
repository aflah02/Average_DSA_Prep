import java.io.*;
import java.util.*;

public class Lec21KosarajuAlgorithm {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(v);
        }

        System.out.println(kosaraju(graph, n));
    }

    public static int kosaraju(ArrayList<ArrayList<Integer>> graph, int N) {
        boolean[] vis = new boolean[N];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < N; i++){
            if (!vis[i]){
                dfs1(i, graph, stack, vis);
            }
        }
        // Transpose the Graph
        ArrayList<ArrayList<Integer>> newgraph = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.size(); i++){
            for (int nbr: graph.get(i)){
                newgraph.get(nbr).add(i);
            }
        }
        int ans = 0;
        vis = new boolean[N];
        while (stack.size()>0){
            int rem = stack.pop();
            if (!vis[rem]){
                dfs2(rem, newgraph, vis);
                ans++;
            }

        }
        return ans;


    }

    private static void dfs1(int src, ArrayList<ArrayList<Integer>> graph, LinkedList<Integer> stack, boolean[] vis) {
        vis[src] = true;
        for (int i: graph.get(src)){
            if (!vis[i]){
                dfs1(i, graph, stack, vis);
            }
        }
        stack.addFirst(src);
    }

    private static void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[src] = true;
        for (int i: graph.get(src)){
            if (!vis[i]){
                dfs2(i, graph, vis);
            }
        }
    }
}