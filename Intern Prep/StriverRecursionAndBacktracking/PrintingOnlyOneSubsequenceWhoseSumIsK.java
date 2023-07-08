import java.util.ArrayList;

public class PrintingOnlyOneSubsequenceWhoseSumIsK {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,4,3};
        printer(new ArrayList<>(), 6, 0, 7, arr);
    }
    static Boolean printer(ArrayList<Integer> store, int n, int i, int k, int[] arr){
        if (i >= n){
            if (k==0){
                for (int elem: store) {
                    System.out.print(elem + " ");
                }
                System.out.println();
                return true;
            }
            return false;
        }
        if (k-arr[i] >= 0){
            store.add(arr[i]);
            if (printer(store,n,i+1,k-arr[i], arr)){
                return true;
            }
            store.remove(store.size()-1);
        }
        return printer(store, n, i + 1, k, arr);
    }
    static int sum(ArrayList<Integer> arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
}

