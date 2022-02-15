public class Lec1Fibonnaci {
    public static void main(String[] args) {
        // 0 Based Indexing
        System.out.println(Fib(10));
    }
    public static int Fib(int n){
        if (n <= 1){
            return n;
        }
        return Fib(n-1)+Fib(n-2);
    }
}
