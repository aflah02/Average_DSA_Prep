import java.util.ArrayList;

public class PrintingCountOfSubsequenceWhoseSumIsK {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,4,3};
        System.out.println(printer(new ArrayList<>(), 6, 0, 7, arr));
    }
    static int printer(ArrayList<Integer> store, int n, int i, int k, int[] arr){
        if (i >= n){
            if (k==0){
                return 1;
            }
            return 0;
        }
        int l = 0;
        int r = 0;
        if (k-arr[i] >= 0){
            store.add(arr[i]);
            l = printer(store,n,i+1,k-arr[i], arr);
            store.remove(store.size()-1);
        }
        r = printer(store, n, i + 1, k, arr);
        return l+r;
    }
    static int sum(ArrayList<Integer> arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
}

