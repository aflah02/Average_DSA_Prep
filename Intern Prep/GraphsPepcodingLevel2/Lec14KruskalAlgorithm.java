import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lec14KruskalAlgorithm {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(st[0]);
            edges[i][1] = Integer.parseInt(st[1]);
            edges[i][2] = Integer.parseInt(st[2]);
        }

        System.out.println(minCostToSupplyWater(v, edges));
    }

    static int[] parent;
    static int[] rank;

    public static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static int minCostToSupplyWater(int n, int[][] pipes) {
        Pair[] arr = new Pair[pipes.length];
        for (int i = 0; i < pipes.length; i++){
            arr[i] = new Pair(pipes[i][0], pipes[i][1], pipes[i][2]);
        }
        Arrays.sort(arr);
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        int ans = 0;
        for (Pair pair : arr) {
            boolean flag = union(pair.u, pair.v);
            if (flag) {
                ans += pair.wt;
            }
        }
        return ans;
    }

    public static int find(int x){
        if (parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    public static boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        if (lx != ly){
            if (rank[lx] > rank[ly]){
                parent[ly] = lx;
            }
            else if (rank[lx] < rank[ly]){
                parent[lx] = ly;
            }
            else{
                parent[lx] = ly;
                rank[ly]++;
            }
        }
        else{
            return false;
        }
        return true;
    }
}
