//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class HW3Q3 {
//    static class Edge{
//        int dest;
//        int weight;
//        Edge(int dest, int weight){
//            this.dest = dest;
//            this.weight = weight;
//        }
//    }
//    static int n;
//    static ArrayList<ArrayList<Edge>> graph;
//    public static void main(String[] args) {
//        n <-- Input;
//        graph <-- Input;
//        modifiedPrims();
//    }
//    static void modifiedPrims() {
//        Boolean[] inMST = new Boolean[n];
//        Arrays.fill(inMST, false);
//        int[] weights = new int[n];
//        Arrays.fill(weights, Integer.MAX_VALUE);
//        int[] parent = new int[n];
//        Arrays.fill(parent, -1);
//        parent[0] = 0;
//        weights[0] = 0;
//        Queue<Edge> twos = new LinkedList<>();
//        Queue<Edge> fives = new LinkedList<>();
//        Queue<Edge> sevens = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            int minWeightVertex = minWeightVertex(twos, fives, sevens, inMST);
//            inMST[minWeightVertex] = true;
//            for (Edge e : graph.get(minWeightVertex)) {
//                if (!inMST[e.dest] && e.weight < weights[e.dest]) {
//                    parent[e.dest] = minWeightVertex;
//                    weights[e.dest] = e.weight;
//                    if (e.weight == 2) {
//                        twos.add(e);
//                    } else if (e.weight == 5) {
//                        fives.add(e);
//                    } else {
//                        sevens.add(e);
//                    }
//                }
//            }
//        }
//        for (int i = 1; i <= n; i++){
//            System.out.println(parent[i] + " " + weights[i]);
//        }
//
//    }
//    static int minWeightVertex(Queue<Edge> twos, Queue<Edge> fives, Queue<Edge> sevens, Boolean[] inMST){
//        for (Edge twoEdge: twos){
//            if (!inMST[twoEdge.dest]){
//                return twoEdge.dest;
//            }
//        }
//        for (Edge fiveEdge: fives){
//            if (!inMST[fiveEdge.dest]){
//                return fiveEdge.dest;
//            }
//        }
//        for (Edge sevenEdge: sevens){
//            if (!inMST[sevenEdge.dest]){
//                return sevenEdge.dest;
//            }
//        }
//        return 0;
//    }
//}
