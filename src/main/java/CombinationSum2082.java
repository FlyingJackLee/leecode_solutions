import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2082 {
    // 值和频率的hash表, 实际上的操作对象
    List<int[]> freq = new ArrayList<int[]>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> sequence = new ArrayList<Integer>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int num: candidates) {
            int size = freq.size();
            // 初始化freq数组
            if (freq.isEmpty() ||
                    num != freq.get(size - 1)[0] // 当前数和最后一个统计数不一样，证明是第一次出现（因为原数组已经被排序）
            ) {
                // 表示某个数暂时出现了一次
                freq.add(new int[]{num, 1});
            } else {
                // 不是第一次出现，频率+1
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return  ans;
    }

    private void dfs(int pos, int rest) {
        // 目标值完成，完成递归，将序列加入答案
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }

        if (pos == freq.size() ||
                rest - freq.get(pos)[0] < 0 // 剩下的值超过rest了，停止
        ) {
            return;
        }
        dfs(pos + 1, rest); // 递归下一个位置

        // most最多还需要多少个当前值
        // rest / freq.get(pos)[0]是防止超过了rest的上限
        int most = Math.min(rest / freq.get(pos)[0] // 当前值需要多少个才能够rest
                , freq.get(pos)[1]);

        // 按照使用多少次当前值进行循环
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]); // 每次使用当前值都要加入序列
            dfs(pos + 1, rest - (i * freq.get(pos)[0]));
        }

        // 删除所有重复添加的值
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }
}
