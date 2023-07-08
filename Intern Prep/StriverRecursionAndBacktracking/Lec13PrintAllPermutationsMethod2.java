import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec13PrintAllPermutationsMethod2 {
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
        solve(store, nums, 0, nums.length);
        return store;
    }
    public static void solve(List<List<Integer>> store, int[] nums, int i, int N){
        if (i == N){
            ArrayList<Integer> toAdd = new ArrayList<>();
            for (int t = 0; t < N; t++){
                toAdd.add(nums[t]);
            }
            store.add(toAdd);
            return;
        }
        for (int idx = i; idx < N; idx++){
            swap(nums, idx, i);
            solve(store, nums, i+1, N);
            swap(nums, i, idx);
        }
    }

    private static void swap(int[] nums, int idx, int i) {
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }
}
