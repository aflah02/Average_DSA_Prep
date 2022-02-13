public class printNames {
    public static void main(String[] args) {
        printer(3, "Aflah");
    }
    public static void printer(int n, String x){
        if (n == 0){
            return;
        }
        System.out.println(x);
        printer(n-1, x);

    }
}
