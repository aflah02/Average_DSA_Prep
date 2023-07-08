public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        revArr(arr, 0, arr.length-1);
        for (int i: arr){
            System.out.println(i);
        }
    }
    static void revArr(int[] arr, int i, int j){
        if (i == j){
            return;
        }
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        revArr(arr, i+1, j-1);
    }
}
