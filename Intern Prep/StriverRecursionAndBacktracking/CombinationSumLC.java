import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationSumLC {
    public static void main(String[] args) {
        List<List<Integer>> sol = combinationSum(new int[]{1,2,3,4,5}, 10);
        for (List<Integer> ls: sol){
            for (int i: ls){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> toReturn = new ArrayList<>();
        solve(toReturn, new ArrayList<>(), candidates, target, 0, candidates.length, new HashSet<>());
        return toReturn;
    }
    public static void solve(List<List<Integer>> store, List<Integer> curr, int[] candidates, int target, int i, int N, HashSet<List<Integer>> set){
        if (i >= N){
            if (target == 0){
                List<Integer> toAdd = new ArrayList<>();
                for (int elem: curr){
                    toAdd.add(elem);
                }
                if (!set.contains(toAdd)){
                    store.add(toAdd);
                    set.add(toAdd);
                }
            }
            return;
        }
        if (target - candidates[i] >= 0){
            curr.add(candidates[i]);
            solve(store, curr, candidates, target - candidates[i], i, N, set);
            solve(store, curr, candidates, target - candidates[i], i+1, N, set);
            curr.remove(curr.size()-1);
        }
        solve(store, curr, candidates, target, i+1, N, set);
    }
}
