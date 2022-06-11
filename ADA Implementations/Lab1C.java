import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lab1C {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] inputX = new Point[n];
        Point[] inputY = new Point[n];
        for (int i = 0; i < n; i++){
            double xCoordinate = sc.nextDouble();
            double yCoordinate = sc.nextDouble();
            Point p = new Point(xCoordinate, yCoordinate);
            inputX[i] = p;
            inputY[i] = p;
        }
        Arrays.sort(inputX, new X());
        Arrays.sort(inputY, new Y());
        System.out.println(solveDnC(inputX, inputY, 0, n, n, n));
    }
    static double solve(Point[] inputX, Point[] inputY, int lowerBound, int upperBound){
        return solveDnC(inputX, inputY, lowerBound, upperBound, upperBound, upperBound);
    }
    private static double solveDnC(Point[] inputX, Point[] inputY, int lowerBound, int upperBound, int inputXlen, int inputYlen) {
        if (lowerBound == upperBound - 3){
            return Point.Perimeter(inputX[lowerBound], inputX[lowerBound+1], inputX[lowerBound+2]);
        }
        if (lowerBound > upperBound - 3){
            return Double.MAX_VALUE;
        }
        int HalfWayLocation = (lowerBound) + (upperBound-lowerBound)/2;
        Point HalfWayPoint = inputX[HalfWayLocation];
        Point[] beforeHalfWayPoint = new Point[HalfWayLocation - lowerBound];
        Point[] afterHalfWayPoint = new Point[upperBound - HalfWayLocation];
        double HalfWayPointX = HalfWayPoint.x;
        double HalfWayPointY = HalfWayPoint.y;
        int beforeHalfWayPointCounter = 0;
        int afterHalfWayPointCounter = 0;
        for (Point point: inputY){
            double pointX = point.x;
            double pointY = point.y;
            if (pointX < HalfWayPointX || (pointX == HalfWayPointX && pointY < HalfWayPointY)){
                beforeHalfWayPoint[beforeHalfWayPointCounter++] = point;
            }
            else{
                afterHalfWayPoint[afterHalfWayPointCounter++] = point;
            }
        }
        double minPerimeterFound = Math.min(solveDnC(inputX, beforeHalfWayPoint, lowerBound, HalfWayLocation, inputXlen, inputYlen),
                solveDnC(inputX, afterHalfWayPoint, HalfWayLocation, upperBound, inputXlen, inputYlen));
        return Math.min(minPerimeterFound, solveForCrossTriangle(inputY, HalfWayPointX, HalfWayPointY, minPerimeterFound, inputY.length));
    }

    private static double solveForCrossTriangle(Point[] inputY, double midPointX, double midPointY, double minPerimeterFound, int arrayLength) {
        double minPerimeterForCrossTriangle = Double.MAX_VALUE;
        int LastAddedPointIndex  = 0;
        double rangeOfStripToCheck;
        ArrayList<Point> pointStripToCheck = new ArrayList<>();
        if (minPerimeterFound == Double.MAX_VALUE){
            rangeOfStripToCheck = 2 * 1E9;
        }
        else{
            rangeOfStripToCheck = minPerimeterFound/2;
        }
        System.out.println(rangeOfStripToCheck);
        for (int FirstPointIterator = 0; FirstPointIterator < arrayLength; FirstPointIterator++){
            System.out.println("i " + FirstPointIterator + " len " + pointStripToCheck.size());
            Point Firstpoint = inputY[FirstPointIterator];
            double FirstPointX = Firstpoint.x;
            double FirstPointY = Firstpoint.y;
            if(Math.abs(FirstPointX - midPointX) > rangeOfStripToCheck) continue;
            while(LastAddedPointIndex < pointStripToCheck.size() && FirstPointY - pointStripToCheck.get(LastAddedPointIndex).y > rangeOfStripToCheck) {
                LastAddedPointIndex += 1;
            }
            for (int SecondPointIterator = LastAddedPointIndex; SecondPointIterator < pointStripToCheck.size(); SecondPointIterator++){
                for (int ThirdPointIterator = SecondPointIterator + 1; ThirdPointIterator < pointStripToCheck.size(); ThirdPointIterator++){
                    System.out.println(" j " + SecondPointIterator + " k " + ThirdPointIterator);
                    Point SecondPoint = pointStripToCheck.get(SecondPointIterator);
                    Point ThirdPoint = pointStripToCheck.get(ThirdPointIterator);
                    double t = Point.Perimeter(Firstpoint, SecondPoint, ThirdPoint);
                    System.out.println(t);
                    minPerimeterForCrossTriangle = Math.min(minPerimeterForCrossTriangle, t);
                }
            }
            pointStripToCheck.add(Firstpoint);
        }
        return minPerimeterForCrossTriangle;
    }
}
class Point{
    double x;
    double y;
    Point(double x, double y){
        this.x = x;
        this.y =y;
    }
    static double DistanceBetweenPoints(Point P1, Point P2){
        return Math.sqrt((P1.x-P2.x)*(P1.x-P2.x) + (P1.y-P2.y)*(P1.y-P2.y));
    }
    static double Perimeter(Point A, Point B, Point C){
        return DistanceBetweenPoints(A, B) + DistanceBetweenPoints(B, C) + DistanceBetweenPoints(C, A);
    }
}
class Y implements Comparator<Point>{
    @Override
    public int compare(Point P1, Point P2) {
        return Double.compare(P1.y, P2.y);
    }
}
class X implements Comparator<Point>{
    @Override
    public int compare(Point P1, Point P2) {
        if (P1.x > P2.x) return  1;
        if (P1.x < P2.x) return -1;
        return Double.compare(P1.y, P2.y);
    }
}
