public class TST {
    private TST_Node root = new TST_Node();

    public void insert(String s) {
        // For each letter in string s
        TST_Node current = root;
        for (int i = 0; i < s.length(); i++) {
            if (current.getCharacter() == '-') {
                current.setCharacter(s.charAt(i));
            }
            // If it's equivalent to the letter in the root, continue down
            // While we haven't found the letter it's equivalent to, traverse left and right based on if it's
            // less than or more than that character
            while (s.charAt(i) != current.getCharacter()) {
                // If the character is smaller than the current value, go to the right
                if (s.charAt(i) < current.getCharacter()) {
                    // If the node to the right is null, create a node with this letter value and set current to this
                    // node
                    if (current.getRight() == null) {
                        current.setRight(new TST_Node());
                        current.getRight().setCharacter(s.charAt(i));
                        current = current.getRight();
                    }
                    // Otherwise, continue to traverse down the Trie
                    else {
                        current = current.getRight();
                    }
                }
                // Repeat for if greater than the character value
                else {
                    if (current.getLeft() == null) {
                        current.setLeft(new TST_Node());
                        current.getLeft().setCharacter(s.charAt(i));
                        current = current.getLeft();
                    }
                    else {
                        current = current.getLeft();
                    }
                }
            }
            // By now, we know that the current node is at the string's character to then go down at the center for
            // If the next node is null, create a new node and set current to equal that node
            if (current.getCenter() == null) {
                current.setCenter(new TST_Node());
            }

            current = current.getCenter();
        }
        // Once we've reached the end of the word, set the last node as true for isWord
        current.setWord();
    }
    public boolean lookup(String s) {
        TST_Node current = root;
        // For every letter in s
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i);
            // If the branch doesn't exist, the word isn't in the Trie (return false)
            if (current.getNext()[idx] == null) {
                return false;
            }
            // Follow to the next node in the tree based on the next letter of the word
            current = current.getNext()[idx];
        }
        // If we reach the end of the word and isWord is false, return false
        if (!current.isWord()) {
            return false;
        }
        // Otherwise, we found the word (return true)
        return true;
    }

}
