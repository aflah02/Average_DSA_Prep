public class DSU {
    static void MakeSet(int[] Parent, int[] Rank, int n){
        for (int i = 1; i <= n; i++){
            Parent[i] = i;
            Rank[i] = 0;
        }
    }
    static int findParent(int node, int[] Parent){
        if (node == Parent[node]){
            return node;
        }
        return findParent(Parent[node], Parent);
    }
    static void union(int u, int v, int[] Parent, int[] Rank){
        u = findParent(u, Parent);
        v = findParent(v, Parent);
        if (Rank[u] < Rank[v]){
            Parent[u] = v;
        }
        else if (Rank[v] < Rank[u]){
            Parent[v] = u;
        }
        else{
            Parent[v] = u;
            Rank[v]++;
        }
    }

    public static void main(String[] args) {
        int[] Parent = new int[5];
        int[] Rank = new int[5];
        MakeSet(Parent, Rank, 5);

    }
}
