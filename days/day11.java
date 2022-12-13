package days;

import java.util.ArrayList;

public class day11 {

  public static void main(String[] args) {
    System.out.println("Part one: " + partOne());
    System.out.println("Part two: " + partTwo());
  }

  private static int partTwo() {
    return 0;
  }

  private static int partOne() {
    return 0;
  }
  public static class MonkeyTemplate {
    
    ArrayList<Integer> items;
    int sum;
    int value;
    int integer;
    String op;
    int trueThrow;
    int falseThrow;
    int test;
    public void buildMonkey(ArrayList<Integer> items,int sum, int value,int integer, int trueThrow, int falseThrow, int test, String op) {
      // this
      this.items = items;
      this.value = value;
      this.sum = sum;
      this.integer = integer;
      this.op = op;
      this.trueThrow = trueThrow;
      this.falseThrow = falseThrow;
      this.test = test;
    }

    public int operation() {
      if (op.equals("+")) {
        return this.value = this.value + this.integer;
      }
      if (op.equals("*")) {
        return this.value * this.integer;
      }
      return 0;
    }

    public void test() {
      
    }

    public void monkeyThrow(ArrayList<Integer> otherItems, int itemNumber) {
      otherItems.add(itemNumber);
      items.remove(itemNumber);
    }

  }
  
}
