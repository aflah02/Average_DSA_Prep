public class Lec1Karatsuba {
    public static void main(String[] args) {
        System.out.println(Karatsuba(34,167));
    }
    static long Karatsuba(long x, long y){
        if (x < 10 && y < 10){
            return x *y;
        }
        long xLen = Long.toString(x).length();
        long yLen = Long.toString(y).length();
        long maxLen = Math.max(xLen,yLen);
        long halfMaxLen = maxLen/2 + maxLen%2;
        long halfMaxLenPower = (long) Math.pow(10, halfMaxLen);
        long a = x/halfMaxLenPower;
        long b = x%halfMaxLenPower;
        long c = y/halfMaxLenPower;
        long d = y%halfMaxLenPower;
        long AtimesC = Karatsuba(a, c);
        long BtimesD = Karatsuba(b, d);
        long AplusBtimesCplusD = Karatsuba(a+b, c+d);
        long AtimesDplusBtimesC = AplusBtimesCplusD - AtimesC - BtimesD;
        return (long) (Math.pow(10, maxLen) * AtimesC + Math.pow(10, halfMaxLen) * (AtimesDplusBtimesC) + BtimesD);
    }
}
