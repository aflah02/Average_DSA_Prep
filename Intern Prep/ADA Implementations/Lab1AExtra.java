import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Lab1AExtra {
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
        int charsRemaining = 0;
        for(int i = 0; i < 200; i++){
            for(int j = 0; j < n; j++){
                int ElementLoc = -1;
                int SecondElementToCompleteChunkWithGivenSum = i - input[j];
                if(SecondElementToCompleteChunkWithGivenSum <= 0){
                    continue;
                }
                if(helper[SecondElementToCompleteChunkWithGivenSum - 1]!=0){
                    ElementLoc =  helper[SecondElementToCompleteChunkWithGivenSum - 1];
                    if(ElementLoc >= j){
                        ElementLoc = -1;
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

                if(ElementLoc == -1){
                    helper[input[j]-1]= j;
                    continue;
                }
                else{
                    if(visitedTracker[i]==-1){
                        dp[j][i] = dp[ElementLoc][i] + 2;
                    }
                    else{
                        dp[j][i] = dp[visitedTracker[i]][i] + 2;
                    }
                    Arrays.fill(helper, 0);
                    charsRemaining = Math.max(charsRemaining, dp[j][i]);
                    visitedTracker[i] = j;
                }
            }
        }
        return charsRemaining;
    }
}
