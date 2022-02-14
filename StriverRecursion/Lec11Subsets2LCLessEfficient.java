import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lec11Subsets2LCLessEfficient {
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
        List<List<Integer>> toReturn = new ArrayList<>();
        solve(toReturn, new ArrayList<>(), nums, nums.length, 0, new HashSet<ArrayList<Integer>>());
        return toReturn;
    }
    static void solve(List<List<Integer>> store, List<Integer> curr, int[] nums, int N, int i, HashSet<ArrayList<Integer>> set){
        if (i >= N){
            ArrayList<Integer> toAdd = new ArrayList<>(curr);
            Collections.sort(toAdd);
            if (set.contains(toAdd)){
                return;
            }
            store.add(toAdd);
            set.add(toAdd);
            return;
        }
        curr.add(nums[i]);
        solve(store,curr,nums,N,i+1, set);
        curr.remove(curr.size()-1);
        solve(store,curr,nums,N,i+1, set);
    }
}
