import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class cfmemx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            int[] inputs = new int[k];
            for (int j = 0; j < k; j++){
                inputs[j] = sc.nextInt();
            }
            Arrays.sort(inputs);
            ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();
            for (int x: inputs){
                if (map.containsKey(x)){
                    map.put(x,map.get(x)+1);
                }
                else{
                    map.put(x,1);
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                ans.add(entry.getKey());
                if (entry.getValue()>1) {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
                else{
                    map.remove(entry.getKey());
                }
            }
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                int x = entry.getValue();
                while (x >= 1) {
                    ans.add(entry.getKey());
                    x--;
                }
                map.remove(entry.getKey());
            }
            for (int t: ans){
                System.out.print(t + " ");
            }
        }
    }
}
