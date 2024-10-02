import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: SIERRA SHAW
 * */

public class SpellCheck {

    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all misspelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        // Create a TST for the dictionary
        TST dict_trie = new TST();

        // For each word in the dictionary, insert it into the TST
        for (String word : dictionary) {
            dict_trie.insert(word);
        }

        // Create a TST for the misspelled words
        TST misspelled_trie = new TST();
        ArrayList<String> misspelled = new ArrayList<String>();

        // for each word in text:
        for (String word: text) {
            // if not in dictionary TST and not in misspelled TST, add the word to misspelled TST
            if (!dict_trie.lookup(word) && !misspelled_trie.lookup(word)) {
                misspelled_trie.insert(word);
                misspelled.add(word);
            }
        }
        // Convert it back to an array
        // return the array
        String[] missp = misspelled.toArray(new String[misspelled.size()]);
        for (String word: missp) {
            System.out.println(word);
        }
        return missp;
    }

//    public String[] checkWords(String[] text, String[] dictionary) {
//
//        // Create a Trie for the dictionary
//        Trie dict_trie = new Trie();
//
//        // For each word in the dictionary, insert it into the Trie
//        for (String word : dictionary) {
//            dict_trie.insert(word);
//        }
//
//        // Create a Trie for the misspelled words
//        Trie misspelled_trie = new Trie();
//        ArrayList<String> misspelled = new ArrayList<String>();
//
//        // for each word in text:
//        for (String word: text) {
//            // if not in dictionary Trie and not in misspelled Trie, add the word to misspelled Trie
//            if (!dict_trie.lookup(word) && !misspelled_trie.lookup(word)) {
//                misspelled_trie.insert(word);
//                misspelled.add(word);
//            }
//        }
//        // Convert it back to an array
//        // return the array
//        String[] missp = misspelled.toArray(new String[misspelled.size()]);
//        return missp;
//    }
}