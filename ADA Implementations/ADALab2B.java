import java.util.*;

public class ADALab2B {

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

    static class Pair implements Comparable<Pair>{
        int weightsofar;
        int operationsdonesofar;
        int vertex;

        public Pair(int weightsofar, int operationsdonesofar, int vertex) {
            this.weightsofar = weightsofar;
            this.operationsdonesofar = operationsdonesofar;
            this.vertex = vertex;
        }

        public int compareTo(Pair o) {
            return this.weightsofar - o.weightsofar;
        }
    }
    
    static void buildSieve(int MaxWeight, int[] smallestFactor)
    {
        smallestFactor[1] = 1;
        for (int i=2; i<MaxWeight; i++)
        {
            smallestFactor[i] = i;
        }
        for (int i=4; i<MaxWeight; i+=2)
        {
            smallestFactor[i] = 2;
        }
        for (int i=3; i*i<MaxWeight; i++)
        {
            if (smallestFactor[i] == i)
            {
                for (int j=i*i; j<MaxWeight; j+=i){
                    if (smallestFactor[j]==j) {
                        smallestFactor[j] = i;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int MaxWeight = (int) 1E6+1;
        int[] smallestFactor = new int[(int) 1E6+1];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        ArrayList<Integer> memo = new ArrayList<>();
        Arrays.fill(smallestFactor, Integer.MAX_VALUE);
        buildSieve(MaxWeight, smallestFactor);
        memo.add(0);
        memo.add(1);
        for (int i = 2; i <= 1E6; i++) {
            int min = Integer.MAX_VALUE;
            int curr = i;
            int j = curr;
            while (curr != 1)
            {
                min = Math.min(min, (j/smallestFactor[curr]) + 2*smallestFactor[curr]);
                curr = curr / smallestFactor[curr];
            }
            memo.add(min);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, src));
        boolean[][] visited = new boolean[n+1][k+1];
        for (boolean[] ls: visited){
            Arrays.fill(ls, false);
        }
        int[][] dist = new int[n+1][k+1];
        for (int[] ls: dist){
            Arrays.fill(ls, Integer.MAX_VALUE);
        }
        for (int i = 0; i <= k; i++){
            dist[src][i] = 0;
            pq.add(new Pair(0, i, src));
        }
        while (!pq.isEmpty()){
            Pair rem = pq.remove();
            int weightsofar = rem.weightsofar;
            int operationsdonesofar = rem.operationsdonesofar;
            int currVertex = rem.vertex;
            if (dist[currVertex][operationsdonesofar] < weightsofar) continue;
            if (visited[currVertex][operationsdonesofar]) continue;
            visited[currVertex][operationsdonesofar] = true;
            for (Edge e: graph[currVertex]){
                int vertex = e.src;
                int neighbour = e.nbr;
                int edgeWeight = e.wt;
                if (dist[neighbour][operationsdonesofar] > dist[currVertex][operationsdonesofar] + edgeWeight){
                    dist[neighbour][operationsdonesofar] = dist[currVertex][operationsdonesofar] + edgeWeight;
                    pq.add(new Pair(dist[neighbour][operationsdonesofar], operationsdonesofar, neighbour));
                }
                if (operationsdonesofar < k){
//                    System.out.println(memo.get(edgeWeight));
                    if (dist[neighbour][operationsdonesofar+1] > dist[currVertex][operationsdonesofar] + memo.get(edgeWeight)){
                        dist[neighbour][operationsdonesofar+1] = dist[currVertex][operationsdonesofar] + memo.get(edgeWeight);
                        pq.add(new Pair(dist[neighbour][operationsdonesofar+1], operationsdonesofar+1, neighbour));
                    }
                }
            }
        }
        for (int[] ls: dist){
            System.out.println(Arrays.toString(ls));
        }
        System.out.println(dist[dest][k]);
    }


}

