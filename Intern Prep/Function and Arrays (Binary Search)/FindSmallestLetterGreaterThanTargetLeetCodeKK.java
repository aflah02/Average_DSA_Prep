import java.util.Scanner;

public class FindSmallestLetterGreaterThanTargetLeetCodeKK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] letters = new String[n];
        for (int i = 0; i < n; i++){
            letters[i] = sc.next();
        }
        String target = sc.next();
        if ((int) target.charAt(0) >= (int)letters[letters.length-1].charAt(0)){
            String toFind = "a";
            if (letters[0].equals("a")){
                System.out.println("a");
            }
            else{
                System.out.println(letters[BinarySearch(letters, toFind)]);
            }
        }
        else{
            System.out.println(letters[BinarySearch(letters, target)]);
        }
    }
    static int BinarySearch(String[] letters, String toFind){
        int low = 0;
        int high = letters.length-1;
        int ans = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if ((int) letters[mid].charAt(0) > (int) toFind.charAt(0)){
                high = mid-1;
                ans = mid;
            }
            else if ((int) letters[mid].charAt(0) <= (int) toFind.charAt(0)){
                low = mid + 1;
            }
        }
        return ans;
    }
}
