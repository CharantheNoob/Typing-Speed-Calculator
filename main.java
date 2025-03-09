import java.util.Scanner;

public class TypingSpeedTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String promptText = "The quick brown fox jumps over the lazy dog";
        System.out.println("\n==============================");
        System.out.println("       Typing Speed Test       ");
        System.out.println("==============================\n");
        System.out.println("Welcome to the Typing Speed Test!");
        System.out.println("Type the following text as fast and accurately as you can:");
        System.out.println("\"" + promptText + "\"\n");

        System.out.println("Press Enter when you are ready...");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();
        System.out.println("\nStart Typing Now: ");
        String userInput = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        int totalWords = promptText.split(" ").length;
        double timeTaken = (endTime - startTime) / 1000.0;

        int errors = countErrors(promptText, userInput);
        int userWords = userInput.split(" ").length;

        double wpm = ((double) userWords / timeTaken) * 60;
        double accuracy = ((double) (promptText.length() - errors) / promptText.length()) * 100;

        System.out.println("\n==============================");
        System.out.println("       Typing Results         ");
        System.out.println("==============================");
        System.out.printf("\nWords Per Minute (WPM): %.2f\n", wpm);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);
        System.out.println("Errors: " + errors);
        System.out.println("==============================\n");

        scanner.close();
    }

    private static int countErrors(String original, String userTyped) {
        int errors = 0;
        int minLength = Math.min(original.length(), userTyped.length());

        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) != userTyped.charAt(i)) {
                errors++;
            }
        }

        errors += Math.abs(original.length() - userTyped.length());
        return errors;
    }
}
