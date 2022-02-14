import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetSumsGFG {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(3);
        ArrayList<Integer> subsetSum = subsetSums(input,2);
        Collections.sort(subsetSum);
        for (int elem: subsetSum){
            System.out.print(elem + " ");
        }
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> toReturn = new ArrayList<>();
        solve(toReturn, arr, N, 0, 0);
        return toReturn;
    }
    static void solve(ArrayList<Integer> store, ArrayList<Integer> arr, int N, int i, int sumSoFar){
        if (i >= N){
            store.add(sumSoFar);
            return;
        }
        solve(store,arr,N,i+1,sumSoFar);
        solve(store,arr,N,i+1,sumSoFar + arr.get(i));
    }
}
