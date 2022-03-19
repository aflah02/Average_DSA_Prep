import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lec8BusRoutes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));

    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, ArrayList<Integer>> BusOnEachStation = new HashMap<>();
        int m = routes.length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < routes[i].length; j++){
                int busStopNo = routes[i][j];
                if (!BusOnEachStation.containsKey(busStopNo)) {
                    BusOnEachStation.put(busStopNo, new ArrayList<>());
                }
                BusOnEachStation.get(busStopNo).add(i);
            }
        }
        HashSet<Integer> visitedBus = new HashSet<>();
        HashSet<Integer> visitedStation = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(S);
        visitedStation.add(S);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int rem = queue.removeFirst();
                if (rem == T){
                    return level;
                }
                for (int busNo: BusOnEachStation.get(rem)){
                    if (visitedBus.contains(busNo)){
                        continue;
                    }
                    for (int station: routes[busNo]){
                        if (!visitedStation.contains(station)){
                            queue.addLast(station);
                            visitedStation.add(station);
                        }
                    }
                    visitedBus.add(busNo);
                }
            }
            level++;
        }
        return -1;
    }
}
