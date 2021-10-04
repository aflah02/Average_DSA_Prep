import java.util.Scanner;

public class TwoSumIILeetCodeKKBinarySearchApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] output = twoSum(numbers, target);
        System.out.println(output[0] + " " + output[1]);
    }
    static int[] twoSum(int[] numbers, int target) {
        int ret = -1;
        int x = -1;
        int ret2 = -1;
        for (int i = 0; i < numbers.length; i++){
            int toFind = target - numbers[i];
            int[] subarray = new int[numbers.length - i - 1];
            int tr = 0;
            for (int j = i + 1; j < numbers.length; j++){
                subarray[tr] = numbers[j];
                tr++;
            }
            x = BinarySearch(subarray, toFind);
            if (x == -1){
                continue;
            }
            else{
                ret = i;
                ret2 = x + i;
                break;
            }
        }
        int[] toret = {ret+1, ret2+2};
        return toret;
    }
    static int BinarySearch(int[] arr, int toFind){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (-low + high)/2;
            if (arr[mid] == toFind){
                return mid;
            }
            else if (arr[mid] > toFind){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
