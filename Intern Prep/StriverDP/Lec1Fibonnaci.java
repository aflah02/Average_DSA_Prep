public class Lec1Fibonnaci {
    public static void main(String[] args) {
        int fibOf = 3;
        // 0 Based Indexing
        final long startTime1 = System.nanoTime();
        System.out.println(Fib(fibOf));
        final long endTime1 = System.nanoTime();
        System.out.println(endTime1-startTime1);
        final long startTime2 = System.nanoTime();
        int[] memArray = new int[fibOf+1];
        memArray[1] = 0;
        memArray[2] = 1;
        System.out.println(FibMemoized(fibOf, memArray));
        final long endTime2 = System.nanoTime();
        System.out.println(endTime2-startTime2);
        System.out.println("Speed Up " + (endTime1-startTime1)/(endTime2-startTime2));
        System.out.println(FibWithLoopandVars(fibOf));
    }
    public static int Fib(int n){
        if (n <= 1){
            return n;
        }
        return Fib(n-1)+Fib(n-2);
    }

    public static int FibMemoized(int n, int[] memArray){
        if (n <= 1){
            return n;
        }
        int num1 = memArray[n-1];
        int num2 = memArray[n-2];
        if (num1 == 0){
            num1 = Fib(n-1);
        }
        if (num2 == 0){
            num2 = Fib(n-2);
        }
        memArray[n-1] = num1+num2;
        return memArray[n-1];
    }

    public static int FibWithLoopandVars(int n){
        int num1 = 0;
        int num2 = 1;
        int res = 1;
        for (int i = 2; i <= n; i++){
            res = num1+num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }
}
