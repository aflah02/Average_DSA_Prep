import java.util.ArrayList;

public class Lec1IntroToGraphs {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = new int[7][7];
        adjacencyMatrix[3][4] = 2;
        adjacencyMatrix[4][3] = 2;
        adjacencyMatrix[1][2] = 10;
        adjacencyMatrix[2][1] = 10;
        adjacencyMatrix[3][2] = 10;
        adjacencyMatrix[2][3] = 10;
        adjacencyMatrix[0][1] = 10;
        adjacencyMatrix[1][0] = 10;
        // And So On......
        // Remember use only when vertices < 10000
        ArrayList<ArrayList<Edge>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyList.get(2).add(new Edge(2,5,3));
    }

    public static class Edge{
        int From;
        int To;
        int Weight;

        public Edge(int from, int to, int weight) {
            From = from;
            To = to;
            Weight = weight;
        }
    }
}
