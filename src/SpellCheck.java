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
        // Set up the map of words
        int[] clusters = new int[dictionary.length + 1];
        int current_idx;
        int previous_idx = 1;
        boolean no_break = true;
        // Traverse through every word in the dictionary
        for (int i = 2; i < dictionary.length; i++) {
            current_idx = i;
            int temp_idx = previous_idx;
            while (dictionary[temp_idx].length() <= dictionary[current_idx].length() && dictionary[temp_idx] !=
                    dictionary[current_idx].substring(0, dictionary[temp_idx].length())) {
                // If you hit a root and there's still nothing, create a new cluster
                if (clusters[temp_idx] == 0) {
                    previous_idx = current_idx;
                    no_break = false;
                }
                else {
                    temp_idx = clusters[temp_idx];
                }
            }
            // If the new word starts (prefixes) with the last checked word
            // Set previous word's index as the root of the new word
            if (no_break) {
                clusters[current_idx] = temp_idx;
                previous_idx = current_idx;
            }
        }

        ArrayList <String> misspelled = new ArrayList<String>();
        // For each word in the string
        for (int i = 0; i < text.length; i++) {
            // Traverse through the clusters
            for (int j = 0; j < clusters.length; j++) {
                // Find the roots of the clusters
                // If the root is a substring of the word in text, traverse down it to see if the word is in the tree
                if (clusters[j] == 0 && dictionary[j] == text[i].substring(0, dictionary[j].length())) {
                        int temp_idx = j;
                        int previous = j;
                        boolean[] visited = new boolean[dictionary.length + 1];
                        // While the current dictionary word is the prefix of the word in text but not equal to the
                        // word in text, keep looking down the "children"
                        while (dictionary[temp_idx].length() <= text[i].length() && dictionary[temp_idx] ==
                                text[i].substring(0, dictionary[temp_idx].length()) && dictionary[temp_idx] != text[i]) {
                            temp_idx = find(clusters, temp_idx, visited);
                            // If there is nowhere else to go lower, go back to the parent node and look at other kids
                            if (temp_idx == 0) {
                                // BREAK OUT OF WHILE LOOP*****
                                temp_idx = previous;
                                previous = clusters[previous];
                                break;
                            }
                        }

                    // If the word isn't present in the dictionary, check to see if the word has already been
                    // added to the return array & if it hasn't already been added, add it
                    if (text[i] != dictionary[temp_idx]) {
                        if (!misspelled.contains(text[i])) {
                            misspelled.add(text[i]);
                        }
                    }
                }

                // If the word is present, it will go to the next word in the string
            }
        }
        String[] toReturn = misspelled.toArray(new String[misspelled.size()]);
        return toReturn;
    }

    public static int find(int[] clusters, int current_node, boolean[] visited) {
        for (int i = current_node; i < clusters.length; i++) {
            // if there are multiple, you can keep checking because of the visited boolean
            if (clusters[i] == current_node && !visited[i]) {
                visited[i] = true;
                return i;
            }
        }
        // If there are no kids or they've all been looked at, return 0
        return 0;
    }

    // Maybe think about cleaning the string .. will it make it more efficient?
}
