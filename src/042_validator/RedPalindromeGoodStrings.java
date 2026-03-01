public class RedPalindromeGoodStrings {
  // 暴力方法
  // 为了观察规律
  public static int num1(int n) {
    char[] path = new char[n];
    return f(path, 0);
  }

  // n = 5
  // - r       X
  // 0 1 2 3 4 5 

  public static int f(char[] path, int i) {
    if (i == path.length) {
      int cnt = 0;
      for (int l = 0; l < path.length; l++) {
        for (int r = l + 1; r < path.length; r++) {
          if (is(path, l, r)) {
            cnt++;
          }
          if (cnt > 1) {
            return 0;
          }
        }
      }
      return cnt == 1 ? 1 : 0;
    } else {
      int ans = 0;
      path[i] = 'r';
      ans += f(path, i + 1);
      path[i] = 'e';
      ans += f(path, i + 1);
      path[i] = 'd';
      ans += f(path, i + 1);
      return ans;
    }
  }

  public static boolean is(char[] s, int l, int r) {
    while (l < r) {
      if (s[l] != s[r]) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

  public static int num2(int n) {
    if (n == 1) {
      return 0;
    }
    if (n == 2) {
      return 3;
    }
    if (n == 3) {
      return 18;
    }
    if (n > 3) {
      return (int) (((long) 6 * (n + 1)) % 1000000007);
    }
    return -1;
  }
  
  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++) {
      System.out.println("长度为" + i + ", 答案:" + num1(i));
    }
  }
}
