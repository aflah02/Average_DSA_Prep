import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lec12KahnsAlgorithmPepcodingCourseSchedule {
    // https://nados.io/question/pepcoding-course-schedule
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] prerequisites = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            prerequisites[i][0] = Integer.parseInt(st[0]);
            prerequisites[i][1] = Integer.parseInt(st[1]);
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
        }

        int[] ans = findOrder(n, graph);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

    public static int[] findOrder(int numCourses, ArrayList<ArrayList<Integer>> graph) {
        int[] indegree = new int[numCourses];
        int[] topoSort = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            for(int nbr: graph.get(i)){
                indegree[nbr]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.addLast(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()){
            int rem = queue.removeFirst();
            topoSort[idx] = rem;
            idx++;
            for (int nbr: graph.get(rem)){
                indegree[nbr]--;
                if (indegree[nbr] == 0){
                    queue.addLast(nbr);
                }
            }
        }
        if (idx == numCourses){
            return topoSort;
        }
        else{
            return new int[]{-1};
        }
    }
}
