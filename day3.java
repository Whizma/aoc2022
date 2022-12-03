import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;

import static java.lang.Character.isUpperCase;


public class day3 {

    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();
    }

    private static void partTwo() throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("input/day3.txt"));
        Set firstSet;
        Set secondSet;
        String rucksack;
        String twoCommonItems = "";
        String score = "";
        int lines = 0;
        int sum = 0;
        while (br1.readLine() != null) {
            lines++;
        }
        br1.close();
        BufferedReader br = new BufferedReader(new FileReader("input/day3.txt"));
        for (int i = 0; i < lines / 3; i++) {
            firstSet = new HashSet<>();
            secondSet = new HashSet<>();
            rucksack = br.readLine();
            for (char c : rucksack.toCharArray()) {
                firstSet.add(c);
            }
            rucksack = br.readLine();
            for (char c : rucksack.toCharArray()) {
                if (firstSet.contains(c)) {
                    secondSet.add(c);
                }
            }
            rucksack = br.readLine();
            for (int a = 0; a < rucksack.length(); a++) {
                if (firstSet.contains(rucksack.charAt(a)) && secondSet.contains(rucksack.charAt(a))) {
                    score += rucksack.charAt(a);
                    break;
                }
            }
            twoCommonItems = "";
        }
        for (int i = 0; i < score.length(); i++) {
            if (Character.isLowerCase(score.charAt(i))) {
                sum += score.charAt(i) - 96;
            }
            else {
                sum += score.charAt(i) - 64 + 26;
            }
        }
        br.close();
        System.out.println(sum);
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
            }
            else {
                sum += commonItems.charAt(i) - 64 + 26;
            }
        }
        br.close();
        System.out.println(sum);
    }
}
