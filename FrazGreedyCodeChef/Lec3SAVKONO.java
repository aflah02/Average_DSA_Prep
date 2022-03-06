import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Lec3SAVKONO {
    // https://www.codechef.com/problems/SAVKONO
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int z = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
            for (int i = 0; i < n; i++){
                pq.add(sc.nextInt());
            }
            int attackCount = 0;
            while (z > 0 && !pq.isEmpty()){
                attackCount++;
                int max = pq.poll();
                z -= max;
                if (max / 2 > 0){
                    pq.add(max/2);
                }
            }
            if (z <= 0) System.out.println(attackCount);
            else System.out.println("Evacuate");
            t--;
        }
    }
}
