import java.util.ArrayList;
import java.util.List;

public class Lec17PalindromePartitioningLC {
    public static void main(String[] args) {
        List<List<String>> sol = partition("abcbca");
        for (List<String> ls: sol){
            for (String s: ls){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> store = new ArrayList<>();
        PalindromePartitioning(store, s, new ArrayList<>(), s.length());
        return store;
    }

    private static void PalindromePartitioning(List<List<String>> store, String og, List<String> curr, int n) {
        if (og.length() == 0){
            store.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 1; i <= og.length(); i++){
            if (isPalindrome(og.substring(0,i))){
                String firstPart = og.substring(0,i);
                String lastPart = og.substring(i);
                curr.add(firstPart);
                PalindromePartitioning(store, lastPart, curr, n);
                curr.remove(curr.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String substring) {
        int i = 0;
        int j = substring.length()-1;
        while (j >= i){
            if (substring.charAt(i) != substring.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
