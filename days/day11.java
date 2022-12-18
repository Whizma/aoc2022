package days;

import java.util.ArrayList;
import java.util.Collections;

public class day11 {

  static ArrayList<Monkey> monkeys;

  public static void main(String[] args) {
    System.out.println("Part one: " + partOne());
    System.out.println("Part two: " + partTwo());
  }

  private static int partTwo() {
    return 0;
  }

  private static int partOne() {
    monkeys = monkeyBuilder();
    execute();
    return 0;
  }

  private static void execute() {
    for (int i = 0; i < 20; i++) {
      for (Monkey m : monkeys) {
        if (m.items.size() == 0) {
          return;
        }
        for (int j = 0; j < m.items.size(); j++) {
          m.items.get(j) = (m.items.get(j) / 3);
          if (m.test(j)) {
            monkeys.get(m.trueThrow).items.add(m.items.get(j));
            m.items.remove(j);
          } else {
            monkeys.get(m.falseThrow).items.add(m.items.get(j));
            m.items.remove(j);
          }
        }
      }
    }
  }

  private static ArrayList<Monkey> monkeyBuilder() {
    Monkey m0 = new Monkey();
    Monkey m1 = new Monkey();
    Monkey m2 = new Monkey();
    Monkey m3 = new Monkey();
    Monkey m4 = new Monkey();
    Monkey m5 = new Monkey();
    Monkey m6 = new Monkey();
    Monkey m7 = new Monkey();
    ArrayList<Integer> items = new ArrayList<Integer>();
    Collections.addAll(items, 71, 86);
    m0.buildMonkey(items, 6, 7, 19, "* 13");

    items = new ArrayList<Integer>();
    Collections.addAll(items, 66, 50, 90, 53, 88, 85);
    m1.buildMonkey(items, 5, 4, 2, "+ 3");

    items = new ArrayList<Integer>();
    Collections.addAll(items, 97, 54, 89, 62, 84, 80, 63);
    m2.buildMonkey(items, 4, 1, 13, "+ 6");

    items = new ArrayList<Integer>();
    Collections.addAll(items, 82, 97, 56, 92);
    m3.buildMonkey(items, 6, 0, 5, "* old");

    items = new ArrayList<Integer>();
    Collections.addAll(items, 66, 50, 90, 53, 88, 85);
    m4.buildMonkey(items, 5, 3, 7, "* old");

    items = new ArrayList<Integer>();
    Collections.addAll(items, 61, 66, 72, 55, 64, 53, 72, 63);
    m5.buildMonkey(items, 3, 0, 11, "+ 4");

    items = new ArrayList<Integer>();
    Collections.addAll(items, 59, 79, 63);
    m6.buildMonkey(items, 2, 7, 17, "* 7");

    items = new ArrayList<Integer>();
    Collections.addAll(items, 55);
    m7.buildMonkey(items, 55, 2, 3, "+ 7");

    ArrayList<Monkey> monkeys = new ArrayList<Monkey>();
    Collections.addAll(monkeys, m0, m1, m2, m3, m4, m5, m6, m7);
    return monkeys;
  }

  public static class Monkey {

    ArrayList<Integer> items;
    String op;
    int trueThrow;
    int falseThrow;
    int testDivisor;

    public void buildMonkey(
        ArrayList<Integer> items, int trueThrow, int falseThrow, int testDivisor, String op) {
      // this
      this.items = items;
      this.op = op;
      this.trueThrow = trueThrow;
      this.falseThrow = falseThrow;
      this.testDivisor = testDivisor;
    }

    public int operation(int old) {
      String[] ops = this.op.split(" ");
      try {
        int itemNumber = Integer.parseInt(ops[1]);
        if (ops[0].equals("+")) {
          return old + itemNumber;
        } else {
          return old * itemNumber;
        }
      } catch (Exception e) {
        if (ops[0].equals("+")) {
          return old + old;
        } else {
          return old * old;
        }
      }
    }

    public boolean test(int itemNumber) {
      return itemNumber % this.testDivisor == 0;
    }
  }
}
