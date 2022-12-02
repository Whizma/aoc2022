import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) throws IOException {
        Files.lines(filePath)
                .map(l -> l.split(" "))
                .forEach(a -> createGraphe(a[0], a[1], a[2]));
    }
}