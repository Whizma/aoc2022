package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class day6 {
  public static void main(String[] args) throws IOException {
    long elapsedTimeSum = 0;
    for (int i = 0; i < 1000; i++) {
        long startTime = System.nanoTime();
        System.out.println("Part one: " + partOne(4));
        System.out.println("Part two: " + partTwo(4, 14)); 
        long elapsedTime = System.nanoTime() - startTime;
        elapsedTimeSum += elapsedTime;
    }
    System.out.println("Average: " + elapsedTimeSum/1000000);
  }

  private static int partOne(int size) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day6.txt"));
    char[] buffer = br.readLine().toCharArray();
    br.close();
    Set<Character> set = new HashSet<Character>();
    int counter = 0;
    int index = 1;
    for (Character c : buffer) {
      set.add(c);
      counter++;
      if (set.size() == size) {
        return index;
      } else {
        if (counter >= size) {
          set.clear();
          counter = 0;
        }
        index++;
      }
    }
    return 0;
  }

  private static int partTwo(int packetSize, int messageSize) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day6.txt"));
    char[] buffer = br.readLine().toCharArray();
    br.close();
    Set<Character> set = new HashSet<Character>();
    int index = 1;
    int counter = 0;
    boolean foundPacket = false;
    for (Character c : buffer) {
      if (foundPacket) {
        counter++;
        set.add(c);
        if (set.size() == messageSize) {
          return index;
        } else {
          if (counter >= messageSize) {
            set.clear();
            counter = 0;
          }
        }
      }

      if (!foundPacket) {
        counter++;
        set.add(c);
        if (set.size() == packetSize) {
          foundPacket = true;
        } else {
          if (counter >= packetSize) {
            counter = 0;
          }
        }
      }
      index++;
    }
    return 0;
  }
}
