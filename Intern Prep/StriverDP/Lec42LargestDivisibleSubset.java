import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec42LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] elems) {
        Arrays.sort(elems);
        int maxi = 0;
        int[] dpArray = new int[elems.length];
        Arrays.fill(dpArray, 1);
        int lastIndex = 0;
        int[] hash = new int[elems.length];
        for (int i = 0; i < elems.length; i++){
            hash[i] = i;
            for (int j = 0; j < i; j++){
                if ((elems[i] % elems[j] == 0) && 1 + dpArray[j] > dpArray[i]){
                    dpArray[i] = 1 + dpArray[j];
                    hash[i] = j;
                }
            }
            if (dpArray[i] > maxi){
                maxi = dpArray[i];
                lastIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(elems[lastIndex]);
        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list.add(elems[lastIndex]);
        }
        return list;
    }
}
