package day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void getScore() {
        final Problem1 problem1 = new Problem1();
        assertEquals(1197,problem1.getScore("{([(<{}[<>[]}>{[]{[(<()>"));
    }
}