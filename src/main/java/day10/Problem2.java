package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem2 {

    int[] scores = {3,47,1197,25137}; // ) ] } >

    public Problem2() {
    }

    public Problem2(final ArrayList<String> lines) {
        final long[] longs = lines.stream().mapToLong(this::getScore).filter(value -> value != 0).sorted().toArray();
        System.out.println(longs[longs.length/2]);
        System.out.println(longs.length);
    }

    long getScore(final String line) {
        char[] stack = new char[line.length()];
        int i = 0;
        final char[] chars = line.toCharArray();
        for (final char c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                case '<':
                    stack[i++] = c;
                    break;
                case ')':
                    if(stack[i-1] == '(') i--;
                    else return 0;
                    break;
                case ']':
                    if(stack[i-1] == '[') i--;
                    else return 0;
                    break;
                case '}':
                    if(stack[i-1] == '{') i--;
                    else return 0;
                    break;
                case '>':
                    if(stack[i-1] == '<') i--;
                    else return 0;
                    break;
            }
        }
        long score = 0;
        while (i > 0) {
            score *= 5;
            switch (stack[--i]) {
                case '(':
                    score += 1;
                    break;
                case '[':
                    score += 2;
                    break;
                case '{':
                    score += 3;
                    break;
                case '<':
                    score +=4;
                    break;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        final ArrayList<String> lines = new ArrayList<>();
        try (final BufferedReader resourceAsStream = new BufferedReader(
                new InputStreamReader(Problem2.class.getClassLoader().getResourceAsStream("day10/input")))) {
            String line = resourceAsStream.readLine();
            while (line != null) {
                lines.add(line);
                line = resourceAsStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Problem2(lines);
    }
}
