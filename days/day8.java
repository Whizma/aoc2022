package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day8 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day8.txt"));
    solve(br);
  }

  private static void solve(BufferedReader br) throws IOException {
    ArrayList<String> lines = new ArrayList<>();
    String currentLine;
    while ((currentLine = br.readLine()) != null) {
      lines.add(currentLine);
    }
    int[][] trees = new int[99][99];
    for (int row = 0; row < 99; row++) {
      currentLine = lines.get(row);
      char[] line = currentLine.toCharArray();
      for (int col = 0; col < 99; col++) {
        trees[row][col] = Character.getNumericValue(line[col]);
      }
    }
    System.out.println("Part one: " + countVisibleTrees(trees));
    System.out.println("Part two: " + getHighestScenicScore(trees));
  }

  public static boolean checkWest(int[][] trees, int row, int col) {
    int compareTree = trees[row][col];
    for (int i = row - 1; i >= 0; i--) {
      if (trees[i][col] >= compareTree) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkNorth(int[][] trees, int row, int col) {
    int compareTree = trees[row][col];
    for (int i = col - 1; i >= 0; i--) {
      if (trees[row][i] >= compareTree) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkEast(int[][] trees, int row, int col) {
    int compareTree = trees[row][col];
    for (int i = row + 1; i < 99; i++) {
      if (trees[i][col] >= compareTree) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkSouth(int[][] trees, int row, int col) {
    int compareTree = trees[row][col];
    for (int i = col + 1; i < 99; i++) {
      if (trees[row][i] >= compareTree) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkTreeIsVisible(int[][] trees, int row, int col) {
    return checkWest(trees, row, col)
        || checkEast(trees, row, col)
        || checkNorth(trees, row, col)
        || checkSouth(trees, row, col);
  }

  public static int countVisibleTrees(int[][] trees) {
    int visibleTrees = 0;
    for (int x = 0; x < 99; x++) {
      for (int y = 0; y < 99; y++) {
        if (checkTreeIsVisible(trees, x, y)) {
          visibleTrees++;
        }
      }
    }
    return visibleTrees;
  }

  private static int getHighestScenicScore(int[][] trees) {
    int highestScore = 0;
    for (int row = 0; row < 99; row++) {
      for (int col = 0; col < 99; col++) {
        int scenicScore = getScenicScore(trees, row, col);
        if (scenicScore > highestScore) {
          highestScore = scenicScore;
        }
      }
    }
    return highestScore;
  }

  private static int getScenicScore(int[][] trees, int row, int col) {
    return getScenicWest(trees, row, col)
        * getScenicEast(trees, row, col)
        * getScenicNorth(trees, row, col)
        * getScenicSouth(trees, row, col);
  }

  private static int getScenicWest(int[][] trees, int row, int col) {
    int points = 0;
    int compareTree = trees[row][col];
    for (int i = row - 1; i >= 0; i--) {
      points++;
      if (trees[i][col] >= compareTree) {
        break;
      }
    }
    return points;
  }

  private static int getScenicEast(int[][] trees, int row, int col) {
    int points = 0;
    int compareTree = trees[row][col];
    for (int i = row + 1; i < 99; i++) {
      points++;
      if (trees[i][col] >= compareTree) {
        break;
      }
    }
    return points;
  }

  private static int getScenicNorth(int[][] trees, int row, int col) {
    int points = 0;
    int compareTree = trees[row][col];
    for (int i = col - 1; i >= 0; i--) {
      points++;
      if (trees[row][i] >= compareTree) {
        break;
      }
    }
    return points;
  }

  private static int getScenicSouth(int[][] trees, int row, int col) {
    int points = 0;
    int compareTree = trees[row][col];
    for (int i = col + 1; i < 99; i++) {
      points++;
      if (trees[row][i] >= compareTree) {
        break;
      }
    }
    return points;
  }
}
