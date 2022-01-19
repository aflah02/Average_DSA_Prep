public class stringtest {
    public static void main(String[] args) {
        String x = "ABC";
        String y = new String("ABC");
        System.out.println(x==y);
        System.out.println(x.equals(y));
    }
}
