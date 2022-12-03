import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.isUpperCase;


public class day3 {

    public static void main(String[] args) throws IOException {
        partOne();
    }
    private static void partOne() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input/day3.txt"));
        String currentLine;
        String commonItems = "";
        while((currentLine = br.readLine()) != null){
            char[] firstCompartment = currentLine.substring(0, currentLine.length() / 2).toCharArray();
            char[] secondCompartment = currentLine.substring(currentLine.length() / 2).toCharArray();
            Set set = new HashSet();
            for (int i = 0; i < firstCompartment.length; i++) {
                set.add(new Character(firstCompartment[i]));
            }
            for (int i = 0; i < secondCompartment.length; i++) {
                if (set.contains(secondCompartment[i])) {
                    commonItems += secondCompartment[i];
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < commonItems.length(); i++) {
            if (Character.isLowerCase(commonItems.charAt(i))) {
                sum += commonItems.charAt(i) - 96;
                System.out.println(sum + "" + commonItems.charAt(i));
            }
            else {
                sum += commonItems.charAt(i) - 64 + 26;
                System.out.println(sum + "" + commonItems.charAt(i));
            }
        }
        br.close();
        System.out.println(sum);
    }

}
