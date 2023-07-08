public class printZ {
    public static void main(String[] args) {
        System.out.println("*****");
        for (int i = 0; i < 3; i++){
            for (int j = 3-i; j > 0; j--){
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println(" ");
        }
        System.out.println("*****");
    }
}
