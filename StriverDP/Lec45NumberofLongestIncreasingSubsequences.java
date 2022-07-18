import java.util.Arrays;

public class Lec45NumberofLongestIncreasingSubsequences {
    public static void main(String[] args) {

    }
    public int findNumberOfLIS(int[] elems) {
        int maxi = 0;
        int[] dpArray = new int[elems.length+1];
        Arrays.fill(dpArray, 1);
        int lastIndex = 0;
        int[] cut = new int[elems.length+1];
        for (int i = 0; i < elems.length; i++){
            for (int j = 0; j <= i-1; j++){
                if (elems[j] < elems[i] && 1 + dpArray[j] > dpArray[i]) {
                    dpArray[i] = 1 + dpArray[j];
                    cut[i] = cut[j];
                }
                else if (elems[j] < elems[i] && 1 + dpArray[j] == dpArray[i]){
                    dpArray[i] = 1 + dpArray[j];
                    cut[i] += cut[j];
                }

            }
            if (dpArray[i] > maxi){
                dpArray[i] = maxi;
            }
        }
        int numLis = 0;
        for (int i = 0; i < cut.length; i++){
            if (dpArray[i] == maxi){
                numLis += cut[i];
            }
        }
        return numLis;
    }
}
