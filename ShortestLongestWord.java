import java.util.Scanner;

public class ShortestLongestWord {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            
        }
        return count;
    }
    public static String[] customSplit(String text) {
        int len = findLength(text);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        int[] spaceIndexes = new int[wordCount + 1];
        int index = 0;
        spaceIndexes[index++] = -1; 
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = len; 
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            int start = spaceIndexes[i] + 1;
            int end = spaceIndexes[i + 1];
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }
    public static int[] findShortestAndLongest(String[][] table) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            int shortestLen = Integer.parseInt(table[shortestIndex][1]);
            int longestLen = Integer.parseInt(table[longestIndex][1]);

            if (length < shortestLen) {
                shortestIndex = i;
            }
            if (length > longestLen) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = customSplit(input);
        String[][] table = getWordsWithLengths(words);
        System.out.println("\nWord\tLength");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }
        int[] result = findShortestAndLongest(table);
        System.out.println("Shortest word: " + table[result[0]][0] + " (Length: " + table[result[0]][1] + ")");
        System.out.println("Longest word: " + table[result[1]][0] + " (Length: " + table[result[1]][1] + ")");

        sc.close();
    }
}
