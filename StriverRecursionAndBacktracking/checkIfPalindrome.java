public class checkIfPalindrome {
    public static void main(String[] args) {
        System.out.println(checker("abcca", 0, 5));
    }
    static Boolean checker(String s, int i, int n){
        if (i >= n/2){
            return true;
        }
        return (s.charAt(i) == s.charAt(n-i-1)) && checker(s, i+1, n);
    }
}
