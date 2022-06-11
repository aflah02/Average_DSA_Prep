package Day_7_Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Job_sequencing_Problem {
    static class Job{
        int id;
        int profit;
        int deadline;
    }
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, Comparator.comparing(o->-1*o.profit));
        int currProfit = 0;
        int[] deadlineTracker = new int[n];
        for(Job job: arr){
            int id = job.id;
            int profit = job.profit;
            int deadline = job.deadline-1;
            int checkDeadlineFrom = deadline;
            if (deadline >= n){
                checkDeadlineFrom = n-1;
            }
            while (checkDeadlineFrom >= 0 && deadlineTracker[checkDeadlineFrom] != 0){
                checkDeadlineFrom--;
            }
            if (checkDeadlineFrom >= 0 && deadlineTracker[checkDeadlineFrom] == 0){
                deadlineTracker[checkDeadlineFrom] = id;
                currProfit += profit;
            }
        }
        int jobCount = 0;
        for (int i = 0; i < n; i++){
            // System.out.print(deadlineTracker[i] + " ");
            if (deadlineTracker[i] != 0){
                jobCount++;
            }
        }
        return new int[]{jobCount, currProfit};
    }
}
