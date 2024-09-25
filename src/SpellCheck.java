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
        // Set up the map of words
        int[] clusters = new int[dictionary.length + 1];
        int current_idx = 0;
        int previous_idx = 0;
        // Traverse through every word in the dictionary
        for (int i = 1; i < dictionary.length; i++) {
            // If we have hit a root, we need to start a new cluster
            current_idx = i;
            if (clusters[previous_idx] == 0) {
                clusters[current_idx] = 0;
                previous_idx = current_idx;
            }
            // Traverse up the tree until you find the prefix matching the last checked word
            else {
                while (dictionary[previous_idx] != dictionary[current_idx].substring(0, dictionary[previous_idx].length())) {
                    // If you hit a root and there's still nothing, create a new cluster
                    if (clusters[previous_idx] == 0) {
                        clusters[current_idx] = 0;
                        previous_idx = current_idx;
                        break;
                    }
                    else {
                        previous_idx = clusters[previous_idx];
                    }
                }
                // If the new word starts (prefixes) with the last checked word
                // Set previous word's index as the root of the new word
                clusters[current_idx] = previous_idx;
                previous_idx = current_idx;
            }
        }

        // For each word in the string
            // For each root
                // Check to see if the root string is a part of the word
                    // When it is, it will go down that tree to find the word
                    // If the word is present, it will go to the next word in the string
                    // If not present, it will check to see if the word has already been added to the return array
                    // Add if not already added
        return null;
    }

    // Maybe think about cleaning the string .. will it make it more efficient?
}
