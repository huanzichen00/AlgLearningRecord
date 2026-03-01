public class EatGrass {
  // 谁最先面对无草可吃，谁输
  public static String win1(int n) {
    return f(n, "A");
  }

  // rest : 还剩多少草
  // cur  : 当前选手的名字
  // 返回 : 还剩rest份草，当前选手是cur，按照题目说的，返回最终谁赢
  public static String f(int rest, String cur) {
    String enemy = cur.equals("A") ? "B" : "A";
    if (rest < 5) {
      return (rest == 0 || rest == 2) ? enemy : cur;
    }
    int pick = 1;
    // rest >= 5
    // rest == 100
    // cur :
    // 1) 1 -> 99, enemy ....
    // 2) 4 -> 96, enemy ....
    // 3) 16 -> 84, enemy ....
    // 4) 64 -> 36, enemy ....
    // 没有cur赢的分支，enemy赢
    while (pick <= rest) {
      if (f(rest - pick, enemy).equals(cur)) {
        return cur;
      }
      pick *= 4;
    }
    return enemy;
  }

  public static String win2(int n) {
    return (n % 5 == 0 || n % 5 == 2) ? "B" : "A";
  } 

  public static void main(String[] args) {
    for (int i = 0; i <= 50; i++) {
      System.out.println(i + " : " + win1(i));
    }
  }
}
