import java.util.ArrayList;
import java.util.Collections;

public class Lec18PermutationSequenceLCMoreEfficient {
    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }
    public static String getPermutation(int n, int k) {
        k -= 1;
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        int t = 1;
        for (int i = 1; i < n; i++){
            t = (i)*t;
            nums.add(i+1);
        }
        int numfac = t;
        StringBuilder ans = new StringBuilder();
        while (true){
            ans.append(nums.get(k / numfac));
            nums.remove(k/numfac);
            if (nums.size() == 0){
                break;
            }
            k = k % numfac;
            n = n-1;
            numfac = numfac/n;
        }
        return ans.toString();
    }
}
