public class print1toNwithBackTrack {
    public static void main(String[] args) {
        printer(5,1);
    }
    static void printer(int n, int N){
        if (n < N){
            return;
        }
        printer(n-1,N);
        System.out.println(n);
    }
}
