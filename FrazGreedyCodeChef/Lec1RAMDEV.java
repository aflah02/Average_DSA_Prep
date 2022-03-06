import java.util.Scanner;

public class Lec1RAMDEV {
    // https://www.codechef.com/problems/RAMDEV
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long b = sc.nextLong();
        long n = sc.nextLong();
        long mats = 0;
        for (int i = 0; i < n; i++){
            long li = sc.nextLong();
            long bi = sc.nextLong();
            if (li < l && li < b){
                continue;
            }
            if (bi < l && bi < b){
                continue;
            }
            long matsPlaced = Math.max((li/l)*(bi/b), (li/b)*(bi/l));
            mats += matsPlaced;
        }
        System.out.println(mats);
    }
}
