//import java.util.*;
//
//public class E {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t > 0){
//            int k = sc.nextInt();
//            int[] arr = new int[k];
//            for (int i = 1; i <= k; i++){
//                arr[i-1] = i;
//            }
//            Set<Integer> currentnums = new HashSet<>();
//            for (int i = 0; i < arr.length; i++) {
//                currentnums.add(arr[i]);
//            }
//            ArrayList permutations = new ArrayList();
//            recurse_nums(currentnums, "", permutations);
//            for (int i: permutations){
//                System.out.println(permutations.get(i));
//            }
//            t--;
//        }
//    }
//    public static ArrayList<Integer> recurse_nums(Set<Integer> currentnums,
//                                         String currentstring,
//                                         ArrayList<Integer> list_of_permutes) {
//        if (currentnums.size() == 1) {
//            int elem = currentnums.iterator().next();
//            list_of_permutes.add(currentstring + Integer.toString(elem));
//            return list_of_permutes;
//        }
//        for (int a : currentnums) {
//            String newstring = currentstring + a;
//            Set<Integer> newnums = new HashSet<>();
//            newnums.addAll(currentnums);
//            newnums.remove(a);
//            recurse_nums(newnums, newstring, list_of_permutes);
//        }
//        return list_of_permutes;
//    }
//    static int LongestIncreasingSubsequenceLength(int v[])
//    {
//        if (v.length == 0) // boundary case
//            return 0;
//
//        int[] tail = new int[v.length];
//        int length = 1; // always points empty slot in tail
//        tail[0] = v[0];
//
//        for (int i = 1; i < v.length; i++) {
//
//            if (v[i] > tail[length - 1]) {
//                // v[i] extends the largest subsequence
//                tail[length++] = v[i];
//            }
//            else {
//                // v[i] will extend a subsequence and
//                // discard older subsequence
//
//                // find the largest value just smaller than
//                // v[i] in tail
//
//                // to find that value do binary search for
//                // the v[i] in the range from begin to 0 +
//                // length
//                int idx = Arrays.binarySearch(
//                        tail, 0, length - 1, v[i]);
//
//                // binarySearch in java returns negative
//                // value if searched element is not found in
//                // array
//
//                // this negative value stores the
//                // appropriate place where the element is
//                // supposed to be stored
//                if (idx < 0)
//                    idx = -1 * idx - 1;
//
//                // replacing the existing subsequene with
//                // new end value
//                tail[idx] = v[i];
//            }
//        }
//        return length;
//    }
//}
