public class Node {
    private final static int radix = 27;
    private boolean isWord;
    private Node[] next;

    // Constructor
    public Node() {
        isWord = false;
        next = new Node[radix];
    }

    // Other Functions
    public boolean isWord() {
        return isWord;
    }

    public void setWord() {
        isWord = true;
    }

    public Node[] getNext() {
        return next;
    }
}
