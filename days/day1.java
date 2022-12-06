package days;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day1 {
  public static void main(String[] args) throws IOException {
    Scanner scan;
    int max = Integer.MIN_VALUE;
    List<Integer> list = null;
    try {
      scan = new Scanner(new File("input/day1_1.txt"));
      int current = 0;
      list = new ArrayList<>();
      while (scan.hasNextLine()) {
        String temp = scan.nextLine();
        if (temp.equals("")) {
          list.add(current);
          if (max < current) {
            max = current;
            current = 0;
          } else {
            current = 0;
          }
        } else {
          current += Integer.parseInt(temp);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Collections.sort(list);
    for (int i : list) {
      System.out.println(i);
    }
  }
}
