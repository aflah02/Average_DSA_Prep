public class printNto1 {
    public static void main(String[] args) {
        printer(1, 10);
    }
    public static void printer(int n, int N){
        if (n > N){
            return;
        }
        printer(n+1,N);
        System.out.println(n);
    }
}
