public class Word {
    Word previous;
    Word next;
    String word;

    public Word(Word previous, Word next, String word) {
        this.previous = previous;
        this.next = next;
        this.word = word;
    }
}
