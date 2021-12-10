package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class Problem1 {

    int[] scores = {3,47,1197,25137}; // ) ] } >

    public Problem1() {
    }

    public Problem1(final ArrayList<String> lines) {
        final int sum = lines.stream().mapToInt(this::getScore).sum();
        System.out.println(sum);
    }

    int getScore(final String line) {
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
                    else return 3;
                    break;
                case ']':
                    if(stack[i-1] == '[') i--;
                    else return 57;
                    break;
                case '}':
                    if(stack[i-1] == '{') i--;
                    else return 1197;
                    break;
                case '>':
                    if(stack[i-1] == '<') i--;
                    else return 25137;
                    break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        final ArrayList<String> lines = new ArrayList<>();
        try (final BufferedReader resourceAsStream = new BufferedReader(
                new InputStreamReader(Problem1.class.getClassLoader().getResourceAsStream("day10/input")))) {
            String line = resourceAsStream.readLine();
            while (line != null) {
                lines.add(line);
                line = resourceAsStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Problem1(lines);
    }
}
