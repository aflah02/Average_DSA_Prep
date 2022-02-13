public class sumofFirstNNumbersFunctional {
    public static void main(String[] args) {
        System.out.println(adder(10));
    }
    static int adder(int n){
        if (n == 0){
            return 0;
        }
        return n + adder(n-1);
    }
}
