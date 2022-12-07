package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class day7 {

  private static Map<String, Integer> directorySizeMap = new HashMap<>();
  private static List<String> lines;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day7.txt"));
    lines = new ArrayList<>();
    String currentLine;
    while ((currentLine = br.readLine()) != null) {
      lines.add(currentLine);
    }
    br.close();
    directorySizeMap = new HashMap<>();
    boolean isFirstFolder = true;
    String currentDir = "/";
    directorySizeMap.put(currentDir, 0);
    for (String input : lines) {
        if (!isFirstFolder) {
            if (input.startsWith("$ cd")) {
                String dir = input.substring(5);
                if ("..".equals(dir)) {
                    currentDir = currentDir.substring(0, currentDir.lastIndexOf("/"));
                } else {
                    currentDir += "/" + dir;
                    if (!directorySizeMap.containsKey(currentDir)) {
                        directorySizeMap.put(currentDir, 0);
                    }
                }
            } else if (Character.isDigit(input.charAt(0))) {
                String[] commandResults = input.split(" ");
                int fileSize = Integer.parseInt(commandResults[0]);
                int currentDirSize = directorySizeMap.get(currentDir) + fileSize;
                directorySizeMap.put(currentDir, currentDirSize);
                updateParentFolderSizes(currentDir, fileSize);
            }
        } else {
            isFirstFolder = false;
        }
    }
    System.out.println("Part one: " + partOne());
    System.out.println("Part two: " + partTwo());
  }

  private static void updateParentFolderSizes(String currentDirectory, int fileSize) {
    while(!"/".equals(currentDirectory)) {
        currentDirectory = currentDirectory.substring(0, currentDirectory.lastIndexOf("/"));
        int currentDirSize = directorySizeMap.get(currentDirectory) + fileSize;
        directorySizeMap.put(currentDirectory, currentDirSize);
    }
  }

  private static int partOne() {
    int largestSize = 100000;
    int sum = 0;
    for (int dirSize: directorySizeMap.values()) {
        if (dirSize <= largestSize) {
            sum += dirSize;
        }
    }
    return sum;
  }

private static int partTwo() {
    int unusedSpace = 70000000 - directorySizeMap.get("/");
    int sizeToFree = 30000000 - unusedSpace;
    int smallestFolderSize = 70000000;
    for (int dirSize: directorySizeMap.values()) {
        if (dirSize >= sizeToFree && dirSize < smallestFolderSize) {
            smallestFolderSize = dirSize;
        }
    }
    return smallestFolderSize;
  }

}

