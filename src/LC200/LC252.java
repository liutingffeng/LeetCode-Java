package LC200;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 *
 */
public class LC252 {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i+1][0] <  intervals[i][1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
