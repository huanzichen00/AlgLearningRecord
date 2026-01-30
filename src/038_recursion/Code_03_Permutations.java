package 038_recursion;

import java.util.ArrayList;
import java.util.List;

// 清理现场
// https://leetcode.cn/problems/permutations/
public class Code03_Permutations {
    public static List<List<Integer>>permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }

    public static void f(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            ans.add(cur);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                f(nums, i + 1, ans);
                swap(nums, i, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
