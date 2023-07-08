package Day_7_Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class N_meetings_in_one_room {
    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, Comparator.comparing(o->o[1]));
        int meetingCount = 1;
        int currEndTime = meetings[0][1];
        for (int i = 1; i < n; i++){
            if (meetings[i][0] <= currEndTime){
                continue;
            }
            meetingCount++;
            currEndTime = meetings[i][1];
        }
        return meetingCount;
    }
}
