
// Name: Kristiyan Stoilov
import java.util.Scanner;

public class EmailValidation {
    public static void main(String[] args) {
        String email = input();
        if (isValidEmail(email))
            System.out.println("Your email address is VALID");
        else
            System.out.println("Your email address is NOT VALID");
    }

    // Verifying if it is a valid email, returning a boolean.
    public static boolean isValidEmail(String email) {
        if (exactlyOneAt(email) && isValidPrefix(email) && isValidDomain(email))
            return true;
        return false;
    }

    // Using Scanner for user input, returning the String of the email.
    public static String input() {
        System.out.println("Enter your email address:");
        Scanner inputString = new Scanner(System.in);
        String email = inputString.nextLine();
        return email;
    }

    // Taking a character,verifying if it is alphanumeric, and returning a boolean.
    public static boolean isAlphanumeric(char character) {
        if (isLetter(character) || isNumber(character))
            return true;
        return false;
    }

    // Taking a character,verifying if it is a letter from the alphabet, and
    // returning a boolean.
    public static boolean isLetter(char character) {
        if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z'))
            return true;
        return false;
    }

    // Taking a character,verifying if it is a number, and returning a boolean.
    public static boolean isNumber(char character) {
        if (character >= '0' && character <= '9')
            return true;
        return false;
    }

    // Taking a character, verifying if it is valid for a prefix, and returning a
    // boolean.
    public static boolean isValidPrefixChar(char character) {
        if (isAlphanumeric(character) || character == '_' || character == '-' || character == '.')
            return true;
        return false;
    }

    // Taking a character, verifying if it is valid for a domain, and returning a
    // boolean.
    public static boolean isValidDomainChar(char character) {
        if (isAlphanumeric(character) || character == '-' || character == '.')
            return true;
        return false;
    }

    // Taking a string, verifying if it has only one @, and returning a boolean.
    public static boolean exactlyOneAt(String email) {
        if (email.indexOf('@') == email.lastIndexOf('@'))
            return true;
        return false;
    }

    // Taking a string, isolating the prefix before the @, and returning it as a
    // String.
    public static String getPrefix(String email) {
        String prefix = email.substring(0, email.indexOf('@'));
        return prefix;
    }

    // Taking a string, isolating the domain after the @, and returning it as a
    // String.
    public static String getDomain(String email) {
        String domain = email.substring((email.indexOf('@') + 1), email.length());
        return domain;
    }

    // Taking a string (the prefix), and verifying if every character in it is
    // valid, then returning a boolean.
    public static boolean isValidPrefix(String email) {
        String prefix = getPrefix(email);
        // Making sure it's not empty.
        if (prefix.length() == 0) {
            return false;
        }
        // Checking for valid prefix character and for double special character
        for (int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            if (isValidPrefixChar(character) == false) {
                return false;
            }
            if ((isValidPrefixChar(character)) && (!isAlphanumeric(character))) {
                char nextCharacter = prefix.charAt(++i);
                if (!isAlphanumeric(nextCharacter)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Taking a string (the domain), and verifying if every character in it is
    // valid, then returning a boolean.
    public static boolean isValidDomain(String email) {
        String domain = getDomain(email);
        // Checking for valid domain character and for double special character.
        for (int i = 0; i < domain.length(); i++) {
            char character = domain.charAt(i);
            if ((isValidDomainChar(character)) && (!isAlphanumeric(character))) {
                char nextCharacter = domain.charAt(++i);
                if (!isAlphanumeric(nextCharacter)) {
                    return false;
                }
                if (isValidDomainChar(character) == false) {
                    return false;
                }
            }
        }
        // Making sure it's not empty.
        if (domain.length() == 0) {
            return false;
        }
        // Making sure there is a dot in domain and not at index 0.
        if (domain.indexOf('.') <= 0) {
            return false;
        }
        // Calculating length of remaining characters after dot.
        if ((domain.length() - domain.lastIndexOf('.')) < 3) {
            return false;
        }
        // Verifying if the last characters are letters only.
        for (int i = (domain.lastIndexOf('.') + 1); i < domain.length(); i++) {
            char character = domain.charAt(i);
            if (isLetter(character) == false) {
                return false;
            }
        }
        return true;
    }
}