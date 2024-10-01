public class Trie {
    private Node root = new Node();

    public void insert(String s) {
        // For each letter in string s
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            // If it's not an apostrophe, fix ascii value to fit into the size 27 array
            // If it's an apostrophe, index of array is 26 (set as a prefix)
            int idx = 26;
            if (s.charAt(i) != 39) {
                idx = s.charAt(i) - 'a';
            }
            // As long as we're not at the end of the array, insert the letter(s) to the word
            // Call the recursive algorithm for the next letter (like in the reading)
            if (current.getNext()[idx] == null) {
                current.getNext()[idx] = new Node();
            }
            current = current.getNext()[idx];
        }
        // Once we've reached the end of the word, set the last node as true for isWord
        current.setWord();
    }
    public boolean lookup(String s) {
        Node current = root;
        // For every letter in s
        for (int i = 0; i < s.length(); i++) {
            int idx = 26;
            if (s.charAt(i) != 39) {
                idx = s.charAt(i) - 'a';
            }
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

    public void printTrie() {
        //
    }

}
