import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lec41LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
//        return solveRecursive(nums, 0, -1);
//        int[][] memArray = new int[nums.length][nums.length+1];
//        for (int[] ls: memArray){
//            Arrays.fill(ls, -1);
//        }
//        return solveMemoized(nums, 0, -1, memArray);
        return solveDP(nums);
    }
    static int solveRecursive(int[] elems, int idx, int prev_idx){
        if (idx == elems.length){
            return 0;
        }
        if (elems[idx] > prev_idx || prev_idx == -1){
            return Math.max(1 + solveRecursive(elems, idx+1, elems[idx]),
                    solveRecursive(elems, idx+1, prev_idx));
        }
        else{
            return solveRecursive(elems, idx+1, prev_idx);
        }
    }
    static int solveMemoized(int[] elems, int idx, int prev_idx, int[][] memArray){
        if (idx == elems.length){
            return 0;
        }
        if (memArray[idx][prev_idx+1] != -1){
            return memArray[idx][prev_idx+1] ;
        }
        if (prev_idx == -1 || elems[idx] > elems[prev_idx]){
            return memArray[idx][prev_idx+1]  = Math.max(1 + solveMemoized(elems, idx+1, idx, memArray),
                    solveMemoized(elems, idx+1, prev_idx, memArray));
        }
        else{
            return memArray[idx][prev_idx+1]  = solveMemoized(elems, idx+1, prev_idx, memArray);
        }
    }
    static int solveDP(int[] elems){
        int[][] dpArray = new int[elems.length+1][elems.length+1];
        for (int idx = elems.length-1; idx >= 0; idx--){
            for (int prev = idx-1; prev >=-1; prev--){
                int len = dpArray[idx+1][prev+1];
                if (prev == -1 || elems[idx] > elems[prev]){
                    len = Math.max(len, 1 + dpArray[idx+1][idx+1]);
                }
                dpArray[idx][prev+1] = len;
            }
        }
        return dpArray[0][0];
    }
    static int solveDP1DSimple(int[] elems){
        int maxi = 0;
        int[] dpArray = new int[elems.length+1];
        Arrays.fill(dpArray, 1);
        int lastIndex = 0;
        int[] hash = new int[elems.length+1];
        for (int i = 0; i < elems.length; i++){
            hash[i] = i;
            for (int j = 0; j <= i-1; j++){
                if (elems[j] < elems[i] && 1 + dpArray[j] > dpArray[i])
                    dpArray[i] = 1 + dpArray[j];
                    hash[i] = j;
            }
            if (dpArray[i] > maxi){
                dpArray[i] = maxi;
                lastIndex = i;
            }
        }
        System.out.println(Arrays.toString(hash));
        int[] lis = new int[maxi];
        lis[0] = elems[lastIndex];
        int ind = 1;
        while (hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            lis[ind++] = elems[lastIndex];
        }
        // Reversed
        return maxi;
    }
    static int lower_bound(ArrayList<Integer> array, int key)
    {
        int index = Collections.binarySearch(array, key);
        if (index < 0) {
            return Math.abs(index) - 1;
        }
        else {
            while (index > 0) {
                if (array.get(index-1) == key)
                    index--;
                else
                    return index;
            }
            return index;
        }
    }
    static int optimized(int[] elems){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(elems[0]);
        for (int i = 0; i < elems.length; i++){
            if (elems[i] > temp.get(temp.size()-1)){
                temp.add(elems[i]);
            }
            else{
                int ind = lower_bound(temp, elems[i]);
                temp.set(ind, elems[i]);
            }
        }
        return temp.size();
    }
}
