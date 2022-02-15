import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec11Subsets2LCMoreEfficient {
    public static void main(String[] args) {
        List<List<Integer>> sub = subsetsWithDup(new int[]{4,1,0});
        for (List<Integer> ls: sub){
            for (int elem: ls){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> toReturn = new ArrayList<>();
        solve(toReturn, new ArrayList<>(), nums, nums.length, 0);
        return toReturn;
    }
    static void solve(List<List<Integer>> store, List<Integer> curr, int[] nums, int N, int i){
        ArrayList<Integer> toAdd = new ArrayList<>(curr);
        store.add(toAdd);
        for (int idx = i; idx < N; idx++){
            if (idx > i && nums[idx] == nums[idx-1]) continue;
            curr.add(nums[idx]);
            solve(store,curr,nums,N,idx+1);
            curr.remove(curr.size()-1);
        }
    }
}
