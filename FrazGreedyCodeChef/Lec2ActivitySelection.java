import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lec2ActivitySelection {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> times = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0){
            ArrayList<Integer> t = new ArrayList<>();
            t.add(sc.nextInt());
            t.add(sc.nextInt());
            times.add(t);
            n--;
        }
        times.sort(Comparator.comparing(o -> o.get(1)));
        int ans = 0;
        int freeAt = 0;
        for (ArrayList<Integer> time : times) {
            if (freeAt <= time.get(0)) {
                ans++;
                freeAt = time.get(1);
            }
        }
        System.out.println(ans);
    }
}
