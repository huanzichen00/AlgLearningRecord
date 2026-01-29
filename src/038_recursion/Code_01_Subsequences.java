package 038_recursion;

import java.util.HashSet;

public class Code_01_Subsequences {
   public static String[] generatePermutation1(String str) {
		char[] s = str.toCharArray();
		HashSet<String> set = new HashSet<>();
		f1(s, 0, new StringBuilder(), set);
		int m = set.size();
		String[] ans = new String[m];
		int i = 0;
		for (String cur : set) {
			ans[i++] = cur;
		}
		return ans;
	}

	public static void f1(char[] s, int i, StringBuilder path, HashSet<String> set) {
		if (i == s.length) {
			set.add(path.toString());
		} else {
			path.append(s[i]);
			f1(s, i + 1, path, set);
			path.deleteCharAt(path.length() - 1);
			f1(s, i + 1, path, set);
		}
	}

	public static String[] generatePermutation2(String str) {
		char[] s = str.toCharArray();
		HashSet<String> set = new HashSet<>();
		f2(s, 0, new char[s.length], 0, set);
		int m = set.size();
		String[] ans = new String[m];
		int i = 0;
		for (String cur : set) {
			ans[i++] = cur;
		}
		return ans;
	}

	public static void f2(char[] s, int i, char[] path, int size, HashSet<String> set) {
		if (i == s.length) {
			set.add(String.valueOf(path, 0, size));
		} else {
			path[size] = s[i];
			f2(s, i + 1, path, size + 1, set);
			f2(s, i + 1, path, size, set);
		}
  }

    // https://leetcode.cn/problems/subsets/   相似题目我的解法
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            HashSet<List<Integer>> set = new HashSet();
            List<Integer> list = new ArrayList<>();
            f(nums, 0, list, set);
            List<List<Integer>> ans = new ArrayList<>();
            for (List<Integer> cur : set) {
                ans.add(cur);
            }
            return ans;
        }

        public void f(int[] nums, int i, List<Integer> list, HashSet<List<Integer>> set) {
            if (i == nums.length) {
                set.add(new ArrayList<>(list));
            } else {
                list.add(nums[i]);
                f(nums, i + 1, list, set);
                list.remove(list.size() - 1);
                f(nums, i + 1, list, set);
            }
        }
    }
}
