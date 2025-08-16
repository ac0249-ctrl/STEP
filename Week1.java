public class Week1 {
    public static void main(String[] args) {
        String str1 = "Java Programming";

        String str2 = new String("Java Programming");

        char[] charArray = {'J','a','v','a',' ','P','r','o','g','r','a','m','m','i','n','g'};
        String str3 = new String(charArray);

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);

        System.out.println(str1.equals(str2)); 
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));

        System.out.println("\nExplanation:");
        System.out.println("'==' checks if two references point to the same object in memory.");
        System.out.println("'.equals()' checks if the actual string values are the same.");

        String quote = "Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects";
        System.out.println("\n" + quote);
    }
}
