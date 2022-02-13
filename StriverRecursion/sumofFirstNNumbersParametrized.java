public class sumofFirstNNumbersParametrized {
    public static void main(String[] args) {
        System.out.println(adder(10,0));
    }
    static int adder(int n, int sum){
        if (n == 0){
            return sum;
        }
        return adder(n-1, sum+n);
    }
}
