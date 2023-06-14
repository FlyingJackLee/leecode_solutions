import java.util.Arrays;
import java.util.Map;

public class CountDaysTogether2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceDays = strToDays(arriveAlice);
        int leaveAliceDays = strToDays(leaveAlice);
        int arriveBobDays = strToDays(arriveBob);
        int leaveBobDays = strToDays(leaveBob);

        int[] diffs = new int[]{arriveAliceDays, leaveAliceDays, arriveBobDays, leaveBobDays};
        Arrays.sort(diffs);

        int lo = Math.max(arriveAliceDays, arriveBobDays);
        int hi = Math.min(leaveAliceDays, leaveBobDays);

        return Math.max(0, hi - lo + 1);
    }

    public int strToDays(String str) {
         int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
         int month = Integer.parseInt(str.substring(0,2)) - 1;
         int day = Integer.parseInt(str.substring(3));

         return Arrays.stream(daysOfMonth).limit(month).sum() + day;
    }
}

