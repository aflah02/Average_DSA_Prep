import java.util.Arrays;
import java.util.Random;

public class Lec5SelectAlgorithmForOrderStatistics {
    // https://www.youtube.com/playlist?list=PLxR_6l4pE6quoVjSj_ShLfIftUpd_e5yo (18-20)
    public static void main(String[] args) {
        System.out.println(Select(new int[]{4,2,3,5}, 0, 3, 1));
    }
    static int Select(int[] arr, int low, int high, int i){
        if (low == high){
            return arr[low];
        }
//        int pivot = partition(arr, low, high);
        int pivot = Randomizedpartition(arr, low, high);
        int k = pivot - low + 1;
        if (k == i){
            return arr[pivot];
        }
        else if (k > i){
            return Select(arr, low, pivot-1, i);
        }
        else{
            return Select(arr, pivot+1, high, i-k);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Last Element As Pivot
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    private static int Randomizedpartition(int[] arr, int low, int high) {
        random(arr, low, high);
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    static void random(int arr[],int low,int high)
    {
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
        int temp1=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp1;
    }

}
