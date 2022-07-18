//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
//
//class B
//{
//    public long countPairs(int V, int[][] edges) {
//        ArrayList<Edge>[] graph = new ArrayList[V];
//        for (int i = 0; i < V; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        int vtces = V;
//        for (int i = 0; i < vtces; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        int edgeLength = edges.length;
//        for (int i = 0; i < edgeLength; i++) {
//            int v2 = edges[i][1];
//            int wt = 0;
//            graph[v1].add(new Edge(v1, v2, wt));
//            graph[v2].add(new Edge(v2, v1, wt));
//        }
//        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
//        Boolean[] visited = new Boolean[vtces];
//        Arrays.fill(visited, false);
//        for (int v = 0; v < vtces; v++){
//            if (!visited[v]){
//                ArrayList<Integer> comp = new ArrayList<>();
//                drawTree(comp, visited, graph, v);
//                comps.add(comp);
//            }
//        }
//    }
//
//    static class Edge {
//        int src;
//        int nbr;
//        int wt;
//
//        Edge(int src, int nbr, int wt) {
//            this.src = src;
//            this.nbr = nbr;
//            this.wt = wt;
//        }
//    }
//
//
//    static void drawTree(ArrayList<Integer> comp, Boolean[] visited, ArrayList<Edge>[] graph, int src){
//        visited[src] = true;
//        comp.add(src);
//        for (Edge E: graph[src]){
//            if (!visited[E.nbr]){
//                drawTree(comp, visited, graph, E.nbr);
//            }
//        }
//    }
//}
//
