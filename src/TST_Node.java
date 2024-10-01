public class TST_Node {
    private String value;
    private boolean isWord;
    private TST_Node left;
    private TST_Node right;
    private TST_Node center;

    // Constructor
    public TST_Node() {
        isWord = false;
        left = new TST_Node();
        right = new TST_Node();
        center = new TST_Node();
        value = null;
    }

    // Other Functions
    public boolean isWord() {
        return isWord;
    }

    public void setWord() {
        isWord = true;
    }
    public void setValue(String val) {
        value = val;
    }

    public TST_Node getRight() {
        return right;
    }

    public TST_Node getLeft() {
        return left;
    }

    public TST_Node getCenter() {
        return center;
    }

}
