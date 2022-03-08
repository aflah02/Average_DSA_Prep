import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lec4ClosestPointsin2DPlane {
    // Reference - https://www.youtube.com/watch?v=6u_hWxbOc7E
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] points = new double[n][2];
        for (int i = 0; i < n; i++){
            points[i][0] = sc.nextDouble();
            points[i][1] = sc.nextDouble();
        }
        Arrays.sort(points, Comparator.comparing(o->o[0]));
        double[] xCoordinates = new double[n];
        double[] yCoordinates = new double[n];
        for (int i = 0; i < n; i++){
            xCoordinates[i] = points[i][0];
            yCoordinates[i] = points[i][1];
        }
        System.out.println(closestPair(xCoordinates, yCoordinates));
    }

    private static double closestPair(double[] xCoordinates, double[] yCoordinates) {
        int n = xCoordinates.length;
        if (n == 2){
            return dist(xCoordinates[0], xCoordinates[1], yCoordinates[0], yCoordinates[1]);
        }
        if (n == 3){
            return Math.min(Math.min(dist(xCoordinates[0], xCoordinates[1], yCoordinates[0], yCoordinates[1]),
                    dist(xCoordinates[0], xCoordinates[2], yCoordinates[0], yCoordinates[2])),
                    dist(xCoordinates[1], xCoordinates[2], yCoordinates[1], yCoordinates[2]));
        }
        double[] startingHalfX = new double[n/2];
        for (int i = 0; i < n/2; i++){
            startingHalfX[i] = xCoordinates[i];
        }
        double[] endingHalfX = new double[n-n/2];
        for (int i = 0; i < n-n/2; i++){
            endingHalfX[i] = xCoordinates[n/2+i];
        }
        double[] startingHalfY = new double[n/2];
        for (int i = 0; i < n/2; i++){
            startingHalfY[i] = yCoordinates[i];
        }
        double[] endingHalfY = new double[n-n/2];
        for (int i = 0; i < n-n/2; i++){
            endingHalfY[i] = yCoordinates[n/2+i];
        }
        System.out.println(Arrays.toString(startingHalfX));
        System.out.println(Arrays.toString(endingHalfX));
        System.out.println(Arrays.toString(startingHalfY));
        System.out.println(Arrays.toString(endingHalfY));
        double dl = closestPair(startingHalfX, startingHalfY);
        double dr = closestPair(endingHalfX, endingHalfY);
        double d = Math.max(dl, dr);
        double mid = xCoordinates[n/2];
        double lowerBound = mid - d/2, upperBound = mid + d/2;
        ArrayList<double[]> pointsBetweenBounds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (xCoordinates[i] >= lowerBound && xCoordinates[i] <= upperBound){
                pointsBetweenBounds.add(new double[]{xCoordinates[i], yCoordinates[i]});
            }
        }
        for (int i = 0; i < pointsBetweenBounds.size(); i++){
            double[] ithPoint = pointsBetweenBounds.get(i);
            for (int j = 1; j <= 7; j++){
                if (i+j >= pointsBetweenBounds.size()){
                    break;
                }
                double[] jthPoint = pointsBetweenBounds.get(i+j);
                d = Math.min(d, dist(ithPoint[0], jthPoint[0], ithPoint[1], jthPoint[1]));
            }
        }
        return d;
    }

    private static double dist(double x1, double x2, double y1, double y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

}
