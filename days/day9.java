package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class day9 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day9test.txt"));
    dayOne(br);
    dayTwo(br);
  }

  private static void dayTwo(BufferedReader br) throws NumberFormatException, IOException {
    String currentLine;
    int xHead = 0;
    int yHead = 0;
    int xTail = 0;
    int yTail = 0;
    HashSet<List<Integer>> visited = new HashSet<>();
    while((currentLine = br.readLine()) != null) {
      String[] input = currentLine.split(" ");
      int distance = Integer.parseInt(input[1]);
      String direction = input[0];
      // If the head is ever two steps directly
      // up, down, left, or right from the tail, 
      // the tail must also move one step in that direction 
      // so it remains close enough:
      // Otherwise, if the head and tail aren't touching and 
      // aren't in the same row or column, 
      // the tail always moves one step diagonally to keep up
      for (int i = 0; i < distance; i++) {
        if (direction.equals("L")) {
          xHead--;
          // om samma rad, flytta tail vänster i x-led
          if (yHead == yTail) {
            if (separateTen(xHead, yHead, xTail, yTail)) {
              xTail--;
            }
          }
          // annars flytta vänster i x-led och ++ eller -- i y-led
          else {
            if (separateTen(xHead, yHead, xTail, yTail)) {
              xTail--;
              yTail = yHead;
            }
          }
        }
        if (direction.equals("U")) {
          yHead++;
          // om samma kolumn, flytta tail uppåt i y-led
          if (xHead == xTail) {
            if (separateTen(xHead, yHead, xTail, yTail)) {
              yTail++;
            }
          }
          // annars flytta uppåt i y-led och ++ eller -- i x-led
          else {
            if (separateTen(xHead, yHead, xTail, yTail)) {
              yTail++;
              xTail = xHead;
            }
          }
        }
        if (direction.equals("R")) {
          xHead++;
          // om samma rad, flytta tail höger i x-led
          if (xHead == xTail) {
            if (separateTen(xHead, yHead, xTail, yTail)) {
              xTail++;
            }
          }
          // annars flytta höger i x-led och ++ eller -- i y-led
          else {
            if (separateTen(xHead, yHead, xTail, yTail)) {
              xTail++;
              yTail = yHead;
            }
          }
        }
        if (direction.equals("D")) {
            yHead--;
            // om samma kolumn, flytta tail nedåt i y-led
            if (xHead == xTail) {
              if (separateTen(xHead, yHead, xTail, yTail)) {
                yTail--;
              }
            }
            // annars flytta nedåt i y-led och ++ eller -- i x-led
            else {
              if (separateTen(xHead, yHead, xTail, yTail)) {
                yTail--;
                xTail = xHead;
              }
            }
        }
        visited.add(List.of(xTail,yTail));
      }
    }
    System.out.println(visited.size());
  }

  private static void dayOne(BufferedReader br) throws IOException {
    String currentLine;
    int xHead = 0;
    int yHead = 0;
    int xTail = 0;
    int yTail = 0;
    HashSet<List<Integer>> visited = new HashSet<>();
    while((currentLine = br.readLine()) != null) {
      String[] input = currentLine.split(" ");
      int distance = Integer.parseInt(input[1]);
      String direction = input[0];
      // If the head is ever two steps directly
      // up, down, left, or right from the tail, 
      // the tail must also move one step in that direction 
      // so it remains close enough:
      // Otherwise, if the head and tail aren't touching and 
      // aren't in the same row or column, 
      // the tail always moves one step diagonally to keep up
      for (int i = 0; i < distance; i++) {
        if (direction.equals("L")) {
          xHead--;
          // om samma rad, flytta tail vänster i x-led
          if (yHead == yTail) {
            if (separate(xHead, yHead, xTail, yTail)) {
              xTail--;
            }
          }
          // annars flytta vänster i x-led och ++ eller -- i y-led
          else {
            if (separate(xHead, yHead, xTail, yTail)) {
              xTail--;
              yTail = yHead;
            }
          }
        }
        if (direction.equals("U")) {
          yHead++;
          // om samma kolumn, flytta tail uppåt i y-led
          if (xHead == xTail) {
            if (separate(xHead, yHead, xTail, yTail)) {
              yTail++;
            }
          }
          // annars flytta uppåt i y-led och ++ eller -- i x-led
          else {
            if (separate(xHead, yHead, xTail, yTail)) {
              yTail++;
              xTail = xHead;
            }
          }
        }
        if (direction.equals("R")) {
          xHead++;
          // om samma rad, flytta tail höger i x-led
          if (xHead == xTail) {
            if (separate(xHead, yHead, xTail, yTail)) {
              xTail++;
            }
          }
          // annars flytta höger i x-led och ++ eller -- i y-led
          else {
            if (separate(xHead, yHead, xTail, yTail)) {
              xTail++;
              yTail = yHead;
            }
          }
        }
        if (direction.equals("D")) {
            yHead--;
            // om samma kolumn, flytta tail nedåt i y-led
            if (xHead == xTail) {
              if (separate(xHead, yHead, xTail, yTail)) {
                yTail--;
              }
            }
            // annars flytta nedåt i y-led och ++ eller -- i x-led
            else {
              if (separate(xHead, yHead, xTail, yTail)) {
                yTail--;
                xTail = xHead;
              }
            }
        }
        visited.add(List.of(xTail,yTail));
      }
    }
    System.out.println(visited.size());
  }
  private static boolean separate(int xHead, int yHead, int xTail, int yTail) {
    return Math.abs(xHead - xTail) > 1 || Math.abs(yHead - yTail) > 1;
  } 
  private static boolean separateTen(int xHead, int yHead, int xTail, int yTail) {
    return Math.abs(xHead - xTail) > 10 || Math.abs(yHead - yTail) > 10;
  } 
}
