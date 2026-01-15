package ca.tetervak.abcblocks.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Blocks implements Serializable {

    private final Random random = new Random();
    private final List<Character> letters;

    public Blocks() {
        this.letters = new ArrayList<>(7);
        for (char letter = 'A'; letter <= 'G'; letter++){
            this.letters.add(letter);
        }
    }

    public synchronized List<Character> getLetters() {
        return List.copyOf(letters);
    }

    public int getCount() {
        return this.letters.size();
    }

    public synchronized void sortBlocks() {
        this.letters.sort(null);
    }

    public synchronized void shuffleBlocks() {
        for (int i = 0; i < this.letters.size(); i++) {
            int randomIndex = random.nextInt(this.letters.size());
            char temp = this.letters.get(i);
            this.letters.set(i, this.letters.get(randomIndex));
            this.letters.set(randomIndex, temp);
        }
    }

    public synchronized void reverseBlocks() {
        for (int i = 0; i < this.letters.size() / 2; i++) {
            char temp = this.letters.get(i);
            this.letters.set(i, this.letters.get(this.letters.size() - 1 - i));
            this.letters.set(this.letters.size() - 1 - i, temp);
        }
    }

    @Override
    public String toString() {
        return "Blocks{" +
                "letters=" + letters +
                '}';
    }

}
