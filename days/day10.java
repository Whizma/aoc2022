package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day10 {

  public static void main(String[] args) throws IOException {
    System.out.println("Part one: " + partOne());
    System.out.println(" ");
    System.out.println(partTwo());
  }

  private static int partOne() throws IOException {
    int cycle = 1;
    int registry = 1;
    int result = 0;
    BufferedReader br = new BufferedReader(new FileReader("input/day10.txt"));
    String currentLine;
    while ((currentLine = br.readLine()) != null) {
      String[] pog = currentLine.split(" ");
      String instruction = pog[0];
      if (instruction.equals("addx")) {
        cycle++;
        result += getSignalStrength(cycle, registry);
        cycle++;
        registry+=Integer.parseInt(pog[1]);
        result += getSignalStrength(cycle, registry);
      }
      else {
        cycle++;
        result += getSignalStrength(cycle, registry);
      }
      if (cycle >= 220) {
        return result;
      }    
    }
    br.close();
    return result;
  }

  private static int getSignalStrength(int cycle, int registry) {
    int calculatedCycle = cycle - 20;
    if (calculatedCycle == 0 || (calculatedCycle > 0 && calculatedCycle % 40 == 0)) {
      return cycle * registry;
    }
    return 0;
  }

  private static String partTwo() throws IOException {
    int cycle = 1;
    int registry = 1;
    String[] crt = new String[6];
    int rowIndex = 0;
    StringBuilder currentRow = new StringBuilder();
    BufferedReader br = new BufferedReader(new FileReader("input/day10.txt"));
    String currentLine;
    while ((currentLine = br.readLine()) != null) {
      String[] pog = currentLine.split(" ");
      String instruction = pog[0];
      if (instruction.equals("addx")) {
        cycle++;
        currentRow.append(getDrawingString(registry - 1, cycle));
        if (cycle % 40 == 0) {
          crt[rowIndex] = currentRow.toString();
          currentRow = new StringBuilder();
          rowIndex++;
        }
        cycle++;
        registry+=Integer.parseInt(pog[1]);
        currentRow.append(getDrawingString(registry - 1, cycle));
        if (cycle % 40 == 0) {
          crt[rowIndex] = currentRow.toString();
          currentRow = new StringBuilder();
          rowIndex++;
        }
      } 
      else {
        cycle++;
        currentRow.append(getDrawingString(registry - 1, cycle));
        if (cycle % 40 == 0) {
          crt[rowIndex] = currentRow.toString();
          currentRow = new StringBuilder();
          rowIndex++;
        }
      }
    }
    br.close();
    return getAndPrintResult(crt);
    }

  private static String getAndPrintResult(String[] crt) {
    StringBuilder builder = new StringBuilder();
    for (String rowIndex: crt) {
      System.out.println(rowIndex);
      builder.append(rowIndex).append("\n");
    }
    return builder.toString();
  }

  private static String getDrawingString(int spriteStart, int cycle) {
    int currentCol = ((cycle) % 40) - 1;
    if (currentCol >= spriteStart && currentCol <= (spriteStart + 2)) {
        return "#";
    }
    return ".";
}
}
