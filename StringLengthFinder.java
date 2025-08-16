import java.util.Scanner;

public class StringLengthFinder {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a string: ");
        String input = sc.next();  
        int manualLength = findLength(input);
        int builtinLength = input.length();
        System.out.println("Length (manual method): " + manualLength);
        System.out.println("Length (built-in method): " + builtinLength);

        sc.close();
    }
}
