//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Lab1B {
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        ArrayList<Point> input = new ArrayList<>();
//        for (int i = 0; i < n; i++){
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            input.add(new Point(x, y));
//        }
//        double minPerimeter = Double.MAX_VALUE;
//        int iter1, iter2, iter3;
//        for (iter1 = 0; iter1 < n; iter1++){
//            for (iter2 = iter1+1; iter2 < n; iter2++){
//                for (iter3 = iter2+1; iter3 < n; iter3++){
//                    minPerimeter = Math.min(minPerimeter, Point.Perimeter(input.get(iter1),input.get(iter2),input.get(iter3)));
//                }
//            }
//        }
//        System.out.println(minPerimeter);
//    }
//}
//class Point{
//    int x;
//    int y;
//    Point(int x, int y){
//        this.x = x;
//        this.y =y;
//    }
//    static double DistanceBetweenPoints(Point P1, Point P2){
//        return Math.sqrt((P1.x-P2.x)*(P1.x-P2.x) + (P1.y-P2.y)*(P1.y-P2.y));
//    }
//    static double Perimeter(Point A, Point B, Point C){
//        return DistanceBetweenPoints(A, B) + DistanceBetweenPoints(B, C) + DistanceBetweenPoints(C, A);
//    }
//}
//
