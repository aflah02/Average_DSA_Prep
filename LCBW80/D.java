public class D {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,4,3,5};
        long k = 10;
        System.out.println(solve(nums, k, 0, 0, nums.length, 0));
    }
    static int solve(int[] nums, long k, int idx, long sum, int n, long elemsChosen){
        if (idx >= n){

            if (sum * elemsChosen < k){
                System.out.println(elemsChosen + " " + sum);
                return 1;
            }
            return 0;
        }
        return solve(nums, k, idx+1, sum + nums[idx], n, elemsChosen+1) + solve(nums, k, idx+1,sum,n,elemsChosen);
    }
}
