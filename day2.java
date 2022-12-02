import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        File file = new File("input/day2.txt");

        Scanner scan;
        int points = 0;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String opponent = scan.next();
                String move = scan.next();
                //rock
                if (opponent.equals("A")) {
                    // förlora mot sten - välj scissor : ger 0 + 3 poäng
                    if (move.equals("X")) {
                        points += 3;
                    }
                    // lika mot sten - välj sten : ger 3 + 1 = 4 poäng
                    else if (move.equals("Y")) {
                        points += 4;
                    }
                    // vinn mot sten - välj påse : ger 6 + 2 poäng
                    else {
                        points += 8;
                    }
                }
                //paper
                else if (opponent.equals("B")) {
                    // förlora mot paper - välj rock : ger 0 + 1 poäng
                    if (move.equals("X")) {
                        points += 1;
                    }
                    // lika mot paper - välj paper : ger 3 + 2 poäng
                    else if (move.equals("Y")) {
                        points += 5;
                    }
                    // vinn mot paper - välj sax : ger 6 + 3 poäng
                    else {
                        points += 9;
                    }
                }
                //scissor
                else {
                    // förlora mot scissor - välj paper : ger 0 + 2 poäng
                    if (move.equals("X")) {
                        points += 2;
                    }
                    // lika mot scissor - välj scissor : ger 3 + 3 poäng
                    else if (move.equals("Y")) {
                        points += 6;
                    }
                    // vinn mot scissor - välj rock : ger 6 + 1 poäng
                    else {
                        points += 7;
                    }
                }
                System.out.println(opponent + " " + move);
                System.out.println(points);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(points);
    }
}
