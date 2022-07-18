import java.util.Arrays;

public class Lec44LongestBitonicSequence {
    public static void main(String[] args) {

    }
    public static int longestBitonicSequence(int[] elems, int n) {
        int[] dpArray1 = new int[elems.length];
        Arrays.fill(dpArray1, 1);
        for (int i = 0; i < elems.length; i++){
            for (int j = 0; j <= i-1; j++){
                if (elems[j] < elems[i] && 1 + dpArray1[j] > dpArray1[i])
                    dpArray1[i] = 1 + dpArray1[j];
            }
        }
        int[] dpArray2 = new int[elems.length];
        Arrays.fill(dpArray2, 1);
        for (int i = n-1; i >= 0; i--){
            for (int j = n-1; j > i; j--){
                if (elems[j] < elems[i] && 1 + dpArray2[j] > dpArray2[i])
                    dpArray2[i] = 1 + dpArray2[j];
            }
        }
        int max = -1;
        for (int i = 0; i < elems.length; i++){
            max = Math.max(max, dpArray1[i] +dpArray2[i] - 1);
        }
        return max;
    }
}
