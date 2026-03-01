// https://leetcode.cn/problems/decode-string/

// 自己写犯的错误 :
// times 是靜態變數：遞迴時會被覆蓋，導致外層的 times 丟失
// sbA 是靜態變數：遞迴時會被共享和清空，導致內容丟失
// 邏輯順序問題：解析數字後沒有立即處理 [，而是繼續循環

public class Code02_DecodeString {
    // 自己的解法
    class Solution {
        public String decodeString(String s) {
            where = 0;
            times = 1;
            sb.setLength(0);
            f(s, 0);
            return sb.toString();
        }

        public static StringBuilder sb = new StringBuilder();
        public static StringBuilder sbA = new StringBuilder();

        public static int times;

        public static int where;

        public static void f(String s, int i) {
            while (i < s.length() && s.charAt(i) != ']') {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    int num = 0;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        num = num * 10 + (s.charAt(i++) - '0');
                    }
                    times = num;
                } else if (s.charAt(i) != '[') {
                    sbA.append(s.charAt(i++));
                } else {
                    i++;
                    f(s, i);
                    i = where + 1;
                }
            }
            where = i;
            for (int j = 0; j < times; j++) {
                sb.append(sbA.toString());
            }
            times = 1;
            sbA.setLength(0);
            return;
        }
    }
}
