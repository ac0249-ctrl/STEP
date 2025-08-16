import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String favLang = scanner.nextLine();

        System.out.print("Write a sentence about your programming experience: ");
        String experience = scanner.nextLine();

        String[] nameParts = fullName.trim().split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "(no last name)";

        int charCount = experience.replace(" ", "").length();

        String favLangUpper = favLang.toUpperCase();

        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Programming Language: " + favLangUpper);
        System.out.println("Characters in your experience (excluding spaces): " + charCount);
        System.out.println("Your Experience: " + experience);

        scanner.close();
    }
}
