package ca.tetervak.abcblocks.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlocksTest {

    private Blocks blocks;

    @BeforeEach
    void setUp() {
        IO.println("*****");
        blocks = new Blocks();
        IO.println("Start test: blocks = " + blocks);
    }

    @AfterEach
    void tearDown() {
        IO.println("End test: blocks = " + blocks);
        IO.println("=====");
    }

    @Test
    void getLetters() {
        IO.println("Test getLetters()");
        IO.println("letters = " + blocks.getLetters());
    }

    @Test
    void getCount() {
        IO.println("Test getCount()");
        IO.println("count = " + blocks.getCount());
        assertEquals(7, blocks.getCount());
    }

    @Test
    void sortBlocks() {
        IO.println("Test sortBlocks()");
        blocks.shuffleBlocks();
        IO.println("shuffled blocks = " + blocks);
        blocks.sortBlocks();
        IO.println("sorted blocks = " + blocks);
    }

    @Test
    void shuffleBlocks() {
        IO.println("Test shuffleBlocks()");
        blocks.shuffleBlocks();
        IO.println("shuffled blocks = " + blocks);
    }

    @Test
    void reverseBlocks() {
        IO.println("Test reverseBlocks()");
        blocks.shuffleBlocks();
        IO.println("shuffled blocks = " + blocks);
        blocks.reverseBlocks();
        IO.println("reversed blocks = " + blocks);
    }
}