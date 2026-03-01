public class apple {
  public static int bags1(int apple) {
    int ans = f(apple);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
  // 当前还有rest个苹果，使用的每个袋子必须装满，返回至少几个袋子
  public static int f(int rest) {
    if (rest < 0) {
      return Integer.MAX_VALUE;
    }
    if (rest == 0) {
      return 0;
    }
    // 使用8规格的袋子，剩余的苹果几个袋子，有可能返回无效解
    //     6
    int p1 = f(rest - 8);
    int p2 = f(rest - 6);
    p1 += p1 != Integer.MAX_VALUE ? 1 : 0;
    p2 += p2 != Integer.MAX_VALUE ? 1 : 0;
    return Math.min(p1, p2);
  }

  public static int bags2(int apple) {
    if ((apple & 1) != 0) {
      return 0;
    }
    if (apple < 18) {     
      if (apple == 0) {
        return 0;
      }
      if (apple == 6 || apple == 14 || apple == 16) {
        return 2;
      }
      return -1;
    }
    return (apple - 18) / 8 + 3;
  }

  public static void main(String[] args) {
    for (int apple = 0; apple < 100; apple++) {
      System.out.println(apple + " : " + bags1(apple));
    }
  }
}
