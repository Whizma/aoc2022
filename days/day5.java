package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class day5 {
  public static void main(String[] args) throws IOException, InterruptedException {
    long elapsedTimeSum = 0;
    for (int i = 0; i < 1000; i++) {
      long startTime = System.nanoTime();
      partOne();
      partTwo();
      long elapsedTime = System.nanoTime() - startTime;
      elapsedTimeSum += elapsedTime;
    }
    System.out.println("Average execution time (µs): " + elapsedTimeSum / 1000000);
  }

  public static void partTwo() throws IOException, InterruptedException {
    FileReader fr = new FileReader("input/day5.txt");
    BufferedReader br = new BufferedReader(fr);
    char[][] matrix = new char[8][9];
    Stack[] stacks = new Stack[9];
    for (int i = 0; i < stacks.length; i++) {
      stacks[i] = new Stack();
    }
    for (int row = 0; row < 8; row++) {
      String line = br.readLine();
      for (int col = 0; col <= line.length() / 4; col++) {
        int lineIndex = col * 4 + 1;
        if (line.charAt(lineIndex) != ' '
            && line.charAt(lineIndex) != '['
            && line.charAt(lineIndex) != ']') {
          matrix[row][col] = line.charAt(lineIndex);
        }
      }
    }
    // Put matrix data into stacks
    for (int row = 7; row >= 0; row--) {
      for (int col = 0; col <= 8; col++) {
        // Ignore unknown characters/nulls
        if (Character.isLetter(matrix[row][col])) {
          stacks[col].push(matrix[row][col]);
        }
      }
    }
    fr = new FileReader("input/day5.txt");
    br = new BufferedReader(fr);
    String currentLine;
    String[] moveArray;
    int amount;
    int from;
    int to;
    while ((currentLine = br.readLine()) != null) {
      List<Character> temp = new LinkedList<>();
      if (currentLine.charAt(0) == 'm') {
        moveArray = currentLine.split(" ");
        amount = Integer.parseInt(moveArray[1]);
        from = Integer.parseInt(moveArray[3]) - 1;
        to = Integer.parseInt(moveArray[5]) - 1;
        Stack<Character> stack = stacks[from];
        for (int i = 0; i < amount; i++) {
          if (!stack.empty()) {
            temp.add(stack.pop());
          } else {
            break;
          }
        }
        stack = stacks[to];
        for (int i = temp.size() - 1; i >= 0; i--) {
          stack.push(temp.get(i));
        }
      }
      temp.clear();
    }
    // System.out.print("Part Two: ");
    for (int i = 0; i < stacks.length; i++) {
      if (!stacks[i].empty()) {
        // System.out.print(stacks[i].peek());
      }
    }
    br.close();
  }

  public static void partOne() throws IOException, InterruptedException {
    FileReader fr = new FileReader("input/day5.txt");
    BufferedReader br = new BufferedReader(fr);
    char[][] matrix = new char[8][9];
    Stack[] stacks = new Stack[9];
    for (int i = 0; i < stacks.length; i++) {
      stacks[i] = new Stack();
    }
    for (int row = 0; row < 8; row++) {
      String line = br.readLine();
      for (int col = 0; col <= line.length() / 4; col++) {
        int lineIndex = col * 4 + 1;
        if (line.charAt(lineIndex) != ' '
            && line.charAt(lineIndex) != '['
            && line.charAt(lineIndex) != ']') {
          matrix[row][col] = line.charAt(lineIndex);
        }
      }
    }
    // Put matrix data into stacks
    for (int row = 7; row >= 0; row--) {
      char[] line = matrix[row];
      for (int col = 0; col <= 8; col++) {
        // Ignore unknown characters/nulls
        if (Character.isLetter(matrix[row][col])) {
          stacks[col].push(matrix[row][col]);
        }
      }
    }
    fr = new FileReader("input/day5.txt");
    br = new BufferedReader(fr);
    String currentLine;
    String[] moveArray;
    int amount;
    int from;
    int to;
    while ((currentLine = br.readLine()) != null) {
      if (currentLine.charAt(0) == 'm') {
        moveArray = currentLine.split(" ");
        amount = Integer.parseInt(moveArray[1]);
        from = Integer.parseInt(moveArray[3]) - 1;
        to = Integer.parseInt(moveArray[5]) - 1;
        for (int i = 0; i < amount; i++) {
          stacks[to].push(stacks[from].pop());
        }
      }
    }
    // System.out.print("Part one: ");
    for (int i = 0; i < stacks.length; i++) {
      //    System.out.print(stacks[i].peek());
    }
    // System.out.println(" ");
  }
}
