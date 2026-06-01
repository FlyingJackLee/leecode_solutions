package hard;

import java.sql.Array;
import java.util.Arrays;

public class MaxJumps1340 {
    private int[] f;

    private void dfs(int[] arr, int id, int d, int n) {
        if (f[id] != -1){
            return;
        }

        f[id] = 1;

        // search left
        for (int i = id - 1; i >= 0 && id - i <= d && arr[id] > arr[i]; --i) {
            dfs(arr, i, d, n);
            f[id] = Math.max(f[id], f[i] + 1);
        }


        // search left
        for (int i = id + 1; i < n && i - id <= d && arr[id] > arr[i]; ++i) {
            dfs(arr, i, d, n);
            f[id] = Math.max(f[id], f[i] + 1);
        }
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        f = new int[n];

        Arrays.fill(f, -1);

        for (int i = 0; i < n; i++) {
            dfs(arr, i, d, n);
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
