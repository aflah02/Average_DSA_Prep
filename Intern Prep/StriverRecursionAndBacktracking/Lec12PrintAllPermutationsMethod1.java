import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec12PrintAllPermutationsMethod1 {
    public static void main(String[] args) {
        List<List<Integer>> sub = permute(new int[]{4,1,0});
        for (List<Integer> ls: sub){
            for (int elem: ls){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> store = new ArrayList<>();
        Boolean[] freq = new Boolean[nums.length];
        Arrays.fill(freq, false);
        solve(store, new ArrayList<>(), nums, nums.length, freq);
        return store;
    }
    public static void solve(List<List<Integer>> store, List<Integer> curr, int[] nums, int N, Boolean[] freq){
        if (curr.size() == N){
            store.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < N; i++){
            if (!freq[i]){
                freq[i] = true;
                curr.add(nums[i]);
                solve(store, curr, nums, N, freq);
                curr.remove(curr.size()-1);
                freq[i] = false;
            }
        }
    }
}
