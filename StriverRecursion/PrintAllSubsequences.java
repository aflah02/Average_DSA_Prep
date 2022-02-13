public class PrintAllSubsequences {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        printer(arr,0,"",3);
    }
    static void printer(int[] arr, int i, String s, int N){
        if (i >= N){
            if (!s.equals("")) {
                System.out.println(s);
            }
            return;
        }
        printer(arr, i+1, s + arr[i], N);
        printer(arr, i+1, s, N);
    }
}
