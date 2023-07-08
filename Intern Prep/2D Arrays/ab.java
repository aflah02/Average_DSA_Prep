public class ab {
    public static void main(String[] args) {
        try{
            Float f1 = new Float("3.0");
            int x = f1.intValue();
            byte y = f1.byteValue();
            double z = f1.doubleValue();
            System.out.println(x+y+z);
        }
        catch (NumberFormatException e){
            System.out.println("h");
        }
    }
}
