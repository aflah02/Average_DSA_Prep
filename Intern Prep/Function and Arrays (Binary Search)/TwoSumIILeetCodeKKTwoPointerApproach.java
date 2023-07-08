import java.util.Scanner;

public class TwoSumIILeetCodeKKTwoPointerApproach {
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
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high){
            if (numbers[low] + numbers[high] > target){
                high--;
            }
            else if (numbers[low] + numbers[high] < target){
                low++;
            }
            else{
                break;
            }
        }
        int[] toRet = {low + 1, high + 1};
        return toRet;
    }
}
