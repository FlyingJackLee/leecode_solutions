package easy;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter933 {
}

class RecentCounter {
    private int pl;

    private List<Integer> requests;

    public RecentCounter() {
        requests = new ArrayList<>(1);
    }

    public int ping(int t) {
        if (requests.size() == 0){
            requests.add(t);
            pl = 0;
            return 1;
        }

        requests.add(t);
        for (int i = pl; i < requests.size() && requests.get(i) < t - 3000; i++, pl++) {

        }

        return requests.size() - pl;
    }
}