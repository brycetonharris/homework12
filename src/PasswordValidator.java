import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
        
        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }
        
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        String specialCharacters = "~!@#$%^&*()-=+_";
        
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (specialCharacters.contains(Character.toString(ch))) hasSpecial = true;
        }
        
        int categoryCount = 0;
        if (hasLower) categoryCount++;
        if (hasUpper) categoryCount++;
        if (hasDigit) categoryCount++;
        if (hasSpecial) categoryCount++;
        
        return categoryCount >= 3;
    }
}
