import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class day6 {
  public static void main(String[] args) throws IOException {
    System.out.print("Part one: ");
    partOne();
    System.out.print("Part two: ");
    partTwo();
  }

  private static void partOne() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day6.txt"));
    char[] buffer = br.readLine().toCharArray();
    Set<Character> set = new HashSet<Character>();
    int counter = 0;
    int index = 1;
    // kolla om par av fyra är unika.
    for (Character c : buffer) {
      // lägger till i mängd
      set.add(c);
      // räknar upp antal bokstäver
      counter++;
      // kollar om vi har fyra bokstäver i settet
      if (set.size() == 4) {
        System.out.println(index);
        break;
      } else {
        if (counter >= 4) {
          set.clear();
          counter = 0;
        }
        index++;
      }
      // System.out.println(counter + " " + index + " " + set.toString());
    }
    br.close();
  }

  private static void partTwo() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day6.txt"));
    char[] buffer = br.readLine().toCharArray();
    Set<Character> set = new HashSet<Character>();
    int index = 1;
    int counter = 0;
    boolean foundPacket = false;
    // kolla om par av fyra är unika.
    for (Character c : buffer) {
      if (foundPacket) {
        // räknar upp antal bokstäver
        counter++;
        set.add(c);
        if (set.size() == 14) {
          System.out.println(index);
          break;
        } else {
            if (counter >= 14) {
              set.clear();
              counter = 0;
            }
        }
      }
      if (!foundPacket) {
        counter++;
        set.add(c);
        if (set.size() == 4) {
          foundPacket = true;
        } else {
            if (counter >= 4) {
              counter = 0;
            }
        }
      }
      index++;
    }
  }
}
