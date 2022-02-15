import java.util.ArrayList;
import java.util.Collections;

public class Lec18PermutationSequenceLCLessEfficient {
    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }
    public static String getPermutation(int n, int k) {
        ArrayList<String> store = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++){
            nums[i-1] = i;
        }
        solve(store, nums, 0, "", n);
        return store.get(k-1);
    }
    public static void solve(ArrayList<String> store, int[] nums, int i, String curr, int n){
        if (i == n){
            StringBuilder currBuilder = new StringBuilder(curr);
            for (int t = 0; t < n; t++){
                currBuilder.append(nums[t]);
            }
            curr = currBuilder.toString();
            store.add(curr);
            return;
        }
        for (int t = i; t < n; t++){
            swap(nums, i, t);
            solve(store, nums, i+1, curr, n);
            swap(nums, t, i);
        }
    }

    private static void swap(int[] nums, int t, int i) {
        int temp = nums[i];
        nums[i] = nums[t];
        nums[t] = temp;
    }
}
