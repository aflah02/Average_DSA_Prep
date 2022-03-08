public class Lec3CountingInversions {
    public static void main(String[] args) {
        System.out.println(CountInversions(new int[]{3,1,4,0}, new int[4], 0, 3));
    }
    static int CountInversions(int[] arr, int[] temp, int low, int high){
        int mid, inversionCount = 0;
        if (high > low){
            mid = (low + high)/2;
            int leftInversions = CountInversions(arr, temp, low, mid);
            int rightInversions = CountInversions(arr, temp, mid+1, high);
            int crossInversions = merge(arr, temp, low, mid+1, high);
            inversionCount = leftInversions + rightInversions + crossInversions;
        }
        return inversionCount;
    }

    private static int merge(int[] arr, int[] temp, int low, int mid, int high) {
        int i = low,j = mid,k = low;
        int inversionCount = 0;
        while (i <= mid - 1 && j <= high){
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
                inversionCount += (mid-i);
            }
        }
        while (i <= mid-1){
            temp[k++] = arr[i++];
        }
        while (j <= high-1){
            temp[k++] = arr[j++];
        }
        for (i = low; i < high; i++){
            arr[i] = temp[i];
        }
        return inversionCount;
    }
}
