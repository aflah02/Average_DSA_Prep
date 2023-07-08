import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec43LongestStringChain {
    public static void main(String[] args) {

    }
    public int longestStrChain(String[] elems) {
        Arrays.sort(elems);
        System.out.println(Arrays.toString(elems));
        int maxi = 0;
        int[] dpArray = new int[elems.length];
        Arrays.fill(dpArray, 1);
        for (int i = 0; i < elems.length; i++){
            for (int j = 0; j < i; j++){
                if (comp(elems[i], elems[j]) && 1 + dpArray[j] > dpArray[i]){
                    dpArray[i] = 1 + dpArray[j];
                }
            }
            if (dpArray[i] > maxi){
                maxi = dpArray[i];
            }
        }
        return maxi;
    }

    private boolean comp(String larger, String smaller) {
        if (smaller.length() != larger.length()-1){
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < larger.length()){
            if (larger.charAt(i) == smaller.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return (i == larger.length() && j == smaller.length());
    }
}
