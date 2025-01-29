// 

import java.util.Random;
import java.util.Scanner;

/**
 * Generates a random password based on user input.
 */
public class PasswordGenerator{

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includeUppercase, includeNumbers, includeSpecialChars);

        System.out.println("Generated Password: " + password);
    }

    /**
     * Generates a random password based on the given parameters.
     *
     * @param length            the length of the password
     * @param includeUppercase  whether to include uppercase letters
     * @param includeNumbers     whether to include numbers
     * @param includeSpecialChars whether to include special characters
     * @return the generated password
     */
    private static String generatePassword(int length, boolean includeUppercase, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        String chars = LOWERCASE;

        if (includeUppercase) {
            chars += UPPERCASE;
        }

        if (includeNumbers) {
            chars += NUMBERS;
        }

        if (includeSpecialChars) {
            chars += SPECIAL_CHARS;
        }

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }
}
