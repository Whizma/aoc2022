import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day4 {
    public static void main(String[] args) throws IOException{
        dayOne();
        dayTwo();
    }

    private static void dayTwo() throws IOException {
        int overlaps = 0;
        BufferedReader br = new BufferedReader(new FileReader("input/day4.txt"));
        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            if (doesOverlap(currentLine)) {
                overlaps++;
            }
        }
        System.out.println("Part Two:  " + overlaps);
    }
    private static void dayOne() throws IOException {
        int overlaps = 0;
        BufferedReader br = new BufferedReader(new FileReader("input/day4.txt"));
        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            if (doesFullyOverlap(currentLine)) {
                overlaps++;
            }
        }
        System.out.println("Part one:  " + overlaps);
    }

    private static boolean doesFullyOverlap(String s) {
        String[] sections = s.split("-");
        int a = Integer.parseInt(sections[0]);
        int b = Integer.parseInt(sections[1].substring(0,sections[1].indexOf(",")));
        int c = Integer.parseInt(sections[1].substring(sections[1].indexOf(",") + 1));
        int d = Integer.parseInt(sections[2]);
        if (a >= c && b <= d) {
            return true;
        }
        else return c >= a && d <= b;
    }

    private static boolean doesOverlap(String s) {
        String[] sections = s.split("-");
        int a = Integer.parseInt(sections[0]);
        int b = Integer.parseInt(sections[1].substring(0,sections[1].indexOf(",")));
        int c = Integer.parseInt(sections[1].substring(sections[1].indexOf(",") + 1));
        int d = Integer.parseInt(sections[2]);
        return (a <= d && c <= b);
    }
}

