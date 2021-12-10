package day8;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem1 {


    public static void main(String[] args) {
        final ArrayList<String> lines = new ArrayList<>();
        try (final BufferedReader resourceAsStream = new BufferedReader(new InputStreamReader(Problem1.class.getClassLoader().getResourceAsStream("day8/input.txt")))) {
            String line = resourceAsStream.readLine();
            while (line !=null) {
                lines.add(line);
                line = resourceAsStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Problem1(lines);
    }


    public Problem1(final ArrayList<String> lines) {

    }
}
