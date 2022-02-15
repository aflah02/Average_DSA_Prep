public class printNto1withBackTrack {
    public static void main(String[] args) {
        printer(10, 1);
    }
    static void printer(int n , int N){
        if (n < N){
            return;
        }
        System.out.println(n);
        printer(n-1, N);
    }

}
