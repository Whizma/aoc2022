package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class day9 {

    public static void main(String[] args) throws IOException {
        System.out.println("Part one: " + partOne());
        System.out.println("Part two: " + partTwo());
    }

    public static int partOne() throws IOException {
        List<Coordinate> rope = List.of(new Coordinate(0, 0), new Coordinate(0, 0));
        return moveRope(rope);
    }

    public static int partTwo() throws IOException {
        List<Coordinate> rope = List.of(new Coordinate(0, 0),
                new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0),
                new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0),
                new Coordinate(0, 0), new Coordinate(0, 0), new Coordinate(0, 0));
        return moveRope(rope);
    }

    public static int moveRope(List<Coordinate> rope) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input/day9.txt"));
        Set<Coordinate> visitedLocations = new HashSet<>();
        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            String[] move = currentLine.split(" ");
            String direction = move[0];
            int times = Integer.parseInt(move[1]);

            for (int i = 0; i < times; i++) {
                if (direction.equals("R")) {
                    moveRight(rope);
                }

                if (direction.equals("L")) {
                    moveLeft(rope);
                }

                if (direction.equals("U")) {
                    moveUp(rope);
                }

                if (direction.equals("D")) {
                    moveDown(rope);
                }
                Coordinate tail = rope.get(rope.size() - 1);
                visitedLocations.add(new Coordinate(tail.x, tail.y));
            }


        }
        return visitedLocations.size();
    }

    public static void moveRight(List<Coordinate> rope) {
        rope.get(0).x++;
        for (int i = 1; i < rope.size(); i++) {
            Coordinate head = rope.get(i - 1);
            Coordinate tail = rope.get(i);
            adjustTail(head, tail);
        }
    }

    public static void moveLeft(List<Coordinate> rope) {
        rope.get(0).x--;
        for (int i = 1; i < rope.size(); i++) {
            Coordinate head = rope.get(i - 1);
            Coordinate tail = rope.get(i);
            adjustTail(head, tail);
        }
    }

    public static void moveUp(List<Coordinate> rope) {
        rope.get(0).y++;
        for (int i = 1; i < rope.size(); i++) {
            Coordinate head = rope.get(i - 1);
            Coordinate tail = rope.get(i);
            adjustTail(head, tail);
        }
    }

    public static void moveDown(List<Coordinate> rope) {
        rope.get(0).y--;
        for (int i = 1; i < rope.size(); i++) {
            Coordinate head = rope.get(i - 1);
            Coordinate tail = rope.get(i);
            adjustTail(head, tail);
        }
    }
    public static void adjustTail(Coordinate head, Coordinate tail) {
        if (tail.x + 2 == head.x) {
            if (tail.y < head.y) {
                tail.y++;
            } else if (tail.y > head.y) {
                tail.y--;
            }
            tail.x = head.x - 1;
        }

        if (tail.x - 2 == head.x) {
            if (tail.y < head.y) {
                tail.y++;
            } else if (tail.y > head.y) {
                tail.y--;
            }
            tail.x = head.x + 1;
        }

        if (tail.y + 2 == head.y) {
            if (tail.x < head.x) {
                tail.x++;
            } else if (tail.x > head.x) {
                tail.x--;
            }
            tail.y = head.y - 1;
        }

        if (tail.y - 2 == head.y) {
            if (tail.x < head.x) {
                tail.x++;
            } else if (tail.x > head.x) {
                tail.x--;
            }
            tail.y = head.y + 1;
        }
    }

    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

