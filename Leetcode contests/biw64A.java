import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class biw64A {
    public static void main(String[] args) {
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
    }
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int c = k;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == 1 && c != 0){
                c--;
            }
            if (c == 0){
                return key;
            }
        }
        return "";
    }
}
