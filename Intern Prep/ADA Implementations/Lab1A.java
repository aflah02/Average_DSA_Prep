import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Lab1A {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        String[] inputLine = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            input[i] = Integer.parseInt(inputLine[i]);
        }
        int charsRemaining = solveDP(input, n);
        System.out.println(n - charsRemaining);
    }
    static int solveDP(int[] input, int n){
        int[][] dp = new int[n][200];
        int[] visitedTracker = new int[200];
        for (int[] ls: dp){
            Arrays.fill(ls, 0);
        }
        Arrays.fill(visitedTracker, -1);
        int[] helper = new int[200];
        Arrays.fill(helper, 0);
        int MSS = 0; // Max Subsequence Sum
        for (int i = 0; i < 200; i++){
            for (int j = 0; j < n; j++){
                int SecondElementToCompleteChunkWithGivenSum = i - input[j];
                if (SecondElementToCompleteChunkWithGivenSum <= 0){
                    // Can't Ever Find an Element Which Satisfies
                    continue;
                }
                int ElementLoc = -1; // Dummy Location
                int temp = helper[SecondElementToCompleteChunkWithGivenSum-1];
                if (temp != 0){
                    if (temp < j&& temp>visitedTracker[i]){
                        ElementLoc = temp;
                    }
                    else{
                        "".isEmpty();
                    }
                }
                else if (input[0] == SecondElementToCompleteChunkWithGivenSum){
                    // First Element Matches Handling
                    if (visitedTracker[i] < 0){
                        if (j > 0){
                            ElementLoc = 0;
                        }
                        else{
                            // Debug Lines To PrintOutputs Here Incase Fails
                            "".isEmpty();
                        }
                    }
                    else{
                        "".isEmpty();
                    }
                }
                if (ElementLoc != -1){
                    int visI = visitedTracker[i];
                    if(visI == -1){
                        dp[j][i] = 2;
                    }
                    else{
                        dp[j][i] = dp[visI][i] + 2;
                    }
                    visitedTracker[i] = j;
//                    Arrays.fill(helper, 200);
                }
                else{
                    helper[input[j]-1] = j;
                    continue;
                }
                MSS = Math.max(MSS, dp[j][i]);
            }
        }
        return MSS;
    }
}