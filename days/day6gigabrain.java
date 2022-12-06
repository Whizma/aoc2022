package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class day6gigabrain {
  public static void main(String[] args) throws IOException {
    long elapsedTimeList = 0;
    for (int i = 0; i < 1000; i++) {
        long startTime = System.nanoTime();
        System.out.println("Part one: " + calculateAnswerList(4));
        System.out.println("Part two: " + calculateAnswerList(14));
        long elapsedTime = System.nanoTime() - startTime;
        elapsedTimeList += elapsedTime;
    }  
    long elapsedTimeSet = 0;
    for (int i = 0; i < 1000; i++){
      long startTime = System.nanoTime();
      System.out.println("Part one: " + calculateAnswerSet(4));
      System.out.println("Part two: " + calculateAnswerSet(14));
      long elapsedTime = System.nanoTime() - startTime;
      elapsedTimeSet += elapsedTime;
    } 
    System.out.println("List average: " + elapsedTimeList/1000000 + " Set average: " + elapsedTimeSet/1000000 +  " Ratio: " + (double) elapsedTimeList/elapsedTimeSet);
  }

  private static int calculateAnswerSet(int size) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day6.txt"));
    String s = br.readLine();
    br.close();
    for(int i = 0; i<s.length(); i++){
      Set<Integer> chars = Set.copyOf(s.substring(i, i+size) // returns a set containing a string of the elements from i to i + size
                                       .chars()  // returns an IntStream
                                       .boxed()  // returns a elements boxed to an integer         
                                       .toList()); // parses to list
      if(chars.size() == size) {
        return i+size;
      }
    }
    return 0;
  }

  private static int calculateAnswerList(int size) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day6.txt"));
    String s = br.readLine();
    br.close();
    for(int i = 0; i<s.length(); i++){
      int[] chars = s.substring(i, i + size)
                     .chars() // returns an IntStream
                     .distinct() // returns stream of distinct elements
                     .toArray(); // parses to array
      if(chars.length == size) {
        return i+size;
      } 
    }
    return 0;
  }
}
