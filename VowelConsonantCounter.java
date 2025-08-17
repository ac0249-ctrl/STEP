import java.util.Scanner;

public class VowelConsonantCounter {
    public static String checkCharType(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32); 
        }
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        int vowelCount = 0, consonantCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String type = checkCharType(ch);

            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        System.out.println("Total Vowels: " + vowelCount);
        System.out.println("Total Consonants: " + consonantCount);

        sc.close();
    }
}
