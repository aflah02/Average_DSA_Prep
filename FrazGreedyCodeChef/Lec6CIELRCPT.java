import java.util.Scanner;

public class Lec6CIELRCPT {
    // https://www.codechef.com/problems/CIELRCPT
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] prices = new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048};
        while (t > 0) {
            long p = sc.nextLong();
            int menus = 0;
            while (p != 0){
                menus++;
                int index = findJustLessThanOrEqualTo(prices, p);
                p -= prices[index];
            }
            System.out.println(menus);
            t--;
        }
    }
    static int findJustLessThanOrEqualTo(int[] arr, long val){
        int low = 0;
        int high = arr.length-1;
        if (val >= arr[high]){
            return high;
        }
        int mid;
        while (low <= high){
            mid = (low + high)/2;
            if (arr[mid] < val){
                if (arr[mid+1] > val){
                    return mid;
                }
                low = mid + 1;
            }
            else if (arr[mid] > val){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        return high;
    }
}
