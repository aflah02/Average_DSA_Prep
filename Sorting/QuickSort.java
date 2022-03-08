public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,3,2,65,4};
        quicksort(arr, 0, arr.length-1);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }
    static void quicksort(int[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quicksort(arr, 0, pi-1);
            quicksort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
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
}
