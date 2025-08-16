import java.util.*;

public class TextProcessor {
    public static String cleanInput(String input) {
        String cleaned = input.trim().replaceAll("\\s+", " ");
        if (cleaned.length() > 0) {
            cleaned = cleaned.substring(0, 1).toUpperCase() + cleaned.substring(1).toLowerCase();
        }

        return cleaned;
    }
    public static void analyzeText(String text) {
        int charCount = text.replace(" ", "").length();

        String[] words = text.split("\\s+");
        int wordCount = words.length;

        String[] sentences = text.split("[.!?]+");
        int sentenceCount = (text.trim().isEmpty()) ? 0 : sentences.length;
        String longestWord = "";
        for (String w : words) {
            String cleaned = w.replaceAll("[^a-zA-Z]", ""); // remove punctuation
            if (cleaned.length() > longestWord.length()) {
                longestWord = cleaned;
            }
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.replaceAll("\\s+", "").toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommonChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }
        System.out.println("\n=== TEXT ANALYSIS ===");
        System.out.println("Word count: " + wordCount);
        System.out.println("Sentence count: " + sentenceCount);
        System.out.println("Character count (excluding spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommonChar + "' (" + maxFreq + " times)");
    }
    public static String[] getWordsSorted(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z ]", ""); 
        String[] words = cleanedText.split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();
        String cleaned = cleanInput(input);
        analyzeText(cleaned);
        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\n=== SORTED WORDS ===");
        for (String word : sortedWords) {
            System.out.println(word);
        }
        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.nextLine().trim();

        boolean found = false;
        for (String word : sortedWords) {
            if (word.equalsIgnoreCase(searchWord)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The word '" + searchWord + "' is found in the text.");
        } else {
            System.out.println("The word '" + searchWord + "' is NOT found in the text.");
        }

        scanner.close();
    }
}
