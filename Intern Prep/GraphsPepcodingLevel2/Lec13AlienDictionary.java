import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lec13AlienDictionary {
    // https://www.lintcode.com/problem/892/
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = br.readLine().split(" ");

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        for (String word: words){
            for (Character ch: word.toCharArray()){
                inDegree.put(ch, 0);
            }
        }
        boolean flag = false;
        for (int i = 0; i < words.length-1; i++){
            String curr = words[i];
            String next = words[i+1];
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++){
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                if (ch1 != ch2){
                    HashSet<Character> set = new HashSet<>();
                    if (graph.containsKey(ch1)){
                        set = graph.get(ch1);
                        if (!set.contains(ch2)){
                            set.add(ch2);
                            inDegree.put(ch2, inDegree.get(ch2)+1);
                            graph.put(ch1, set);
                        }
                    }
                    else{
                        set.add(ch2);
                        inDegree.put(ch2, inDegree.get(ch2)+1);
                        graph.put(ch1, set);
                    }
                    flag = true;
                    break;
                }
                if (!flag && curr.length()>next.length()){
                    return "";
                }
            }
        }
        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (Character ch: inDegree.keySet()){
            if (inDegree.get(ch) == 0){
                queue.addLast(ch);
                System.out.println(ch);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            char rem = queue.removeFirst();
            ans.append(rem);
            count++;
            if (graph.containsKey(rem)){
                HashSet<Character> neighbours = graph.get(rem);
                for (Character neigh: neighbours){
                    inDegree.put(neigh, inDegree.get(neigh)-1);
                    if (inDegree.get(neigh) == 0){
                        queue.addLast(neigh);
                    }
                }
            }
        }
        if (count == inDegree.size()){
            return ans.toString();
        }
        else{
            return "";
        }
    }
}
