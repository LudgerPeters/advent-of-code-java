package day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void getScore() {
        final Problem2 problem2 = new Problem2();
        assertEquals(294,problem2.getScore("<{([{{}}[<[[[<>{}]]]>[]]"));
    }
}