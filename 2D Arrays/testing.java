//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class testing {
//    public static void main(String[] args) {
//        Point<Integer> x = new Point<>();
//
//    }
//}
//
//class Point<T>{
//    private T x;
//    public Point(T x) {
//            if (x.getClass()==Integer.class){
//                throw new InvalidTyeException("Integer Type Not Allowed");
//            }
//        this.x = x;
//    }
//
//}
//class InvalidTyeException extends RuntimeException{
//    public InvalidTyeException(String message){
//        super(message);
//    }
//}