package 038_recursion;

import java.util.*;

// 说实话我还没太搞懂 2026-01-29 19:43
public class Code_02_Combinations {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[num.length], 0, ans);
        return ans;
    }

    public static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            ans.add(cur);
        } else {
            // j -> 找到并记录下一组的第一个数
            int j = i + 1;
            while (j < nums.length && nums[i] ==  nums[j]) {
                j++;
            }
            f(nums, j, path, size, ans);
            for (; i < j; i++) {
                path[size++] = nums[i];
                f(nums, j, path, size, ans);
            }
        }
    }
}
