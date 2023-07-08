package Day_7_Greedy;

import java.util.Arrays;

public class Minimum_number_of_platforms_required_for_a_railway {
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platformsNeeded = 1;
        int currTrains = 1;
        int arrPointer = 1;
        int depPointer = 0;
        while (arrPointer < n && depPointer < n){
            if (dep[depPointer] < arr[arrPointer]){
                currTrains--;
                depPointer++;
            }
            else if (dep[depPointer] >= arr[arrPointer]){
                currTrains++;
                if (currTrains > platformsNeeded){
                    platformsNeeded = currTrains;
                }
                arrPointer++;
            }
        }
        return platformsNeeded;
    }
}
