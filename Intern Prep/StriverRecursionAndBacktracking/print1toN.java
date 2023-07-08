public class print1toN {
    public static void main(String[] args) {
        printer(1, 5);
    }
    public static void printer(int n, int N){
        if (n == N+1){
            return;
        }
        System.out.println(n);
        printer(n+1, N);
    }
}
