import java.util.*;

public class CombinationSum2LC {
    public static void main(String[] args) {
        List<List<Integer>> sol = combinationSum(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> ls: sol){
            for (int i: ls){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> toReturn = new ArrayList<>();
        solve(toReturn, new ArrayList<>(), candidates, target, 0, candidates.length);
        return toReturn;
    }
    public static void solve(List<List<Integer>> store, List<Integer> curr, int[] candidates, int target, int i, int N){
        if (target == 0){
            store.add(new ArrayList<>(curr));
        }
        if (i >= N){
            return;
        }
        for (int ind = i; ind < candidates.length; ind++){
            if (ind >= i+1 && candidates[ind-1] == candidates[ind]){
                continue;
            }
            if (candidates[ind] > target){
                break;
            }
            curr.add(candidates[ind]);
            solve(store, curr, candidates, target-candidates[ind],ind+1,N);
            curr.remove(curr.size()-1);
        }
    }
}
