import java.util.Scanner; // Class import to read an input from the console

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // The Scanner instance that reads text from the input stream
        boolean continueRunning = true; // The current state

        System.out.println("Welcome to Gehtsoft Technical Assessment");

        while (continueRunning) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Caesar Cipher Encryption");
            System.out.println("2. Caesar Cipher Decryption");
            System.out.println("3. Arithmetic Expression Evaluation");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");

            String inputText = scanner.nextLine(); // Read as string to validate input
            int choice;

            // The validation block below to check proper choice input integer
            if (inputText.matches("\\d")) {
                choice = Integer.parseInt(inputText);
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid Input. Please enter an integer from 1 to 4 incl.");
                    continue;
                }
            } else {
                System.out.println("Invalid Input. Please enter an integer from 1 to 4 incl. No fractional numbers!");
                continue;
            }

            if (choice == 1) {
                System.out.println("\nCaesar Cipher Encryption was chosen\n");
                System.out.print("Enter text to encrypt: ");
                String textToEncrypt = scanner.nextLine();

                int shiftValue;
                while (true) {
                    System.out.print("Enter shift value (integer): ");
                    String shiftInput = scanner.nextLine().trim();

                    if (shiftInput.matches("-?\\d+")) {
                        try {
                            shiftValue = Integer.parseInt(shiftInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Shift value is too large or invalid. Please enter a smaller integer.\n");
                        }
                    } else {
                        System.out.println("Invalid shift value. It must be an integer.\n");
                    }
                }

                String encrypted = CaesarCipher.encrypt(textToEncrypt, shiftValue);
                System.out.println("Output: \"" + encrypted + "\"");
            }
            else if (choice == 2) {
                System.out.println("Caesar Cipher Decryption was chosen");
                System.out.print("Enter text to decrypt: ");
                String textToDecrypt = scanner.nextLine();

                while (true) {
                    System.out.print("Enter shift value (integer) or leave empty to try all possible variants: ");
                    String shiftInput = scanner.nextLine().trim();

                    if (shiftInput.isEmpty()) {
                        System.out.println("\nTrying all possible shifts:\n");
                        for (int i = 1; i < 26; i++) {
                            String attempt = CaesarCipher.decrypt(textToDecrypt, i);
                            System.out.printf("Shift %2d: \"%s\"%n", i, attempt);
                        }
                        break;
                    } else if (shiftInput.matches("-?\\d+")) {
                        try {
                            int shiftValue = Integer.parseInt(shiftInput);
                            String decrypted = CaesarCipher.decrypt(textToDecrypt, shiftValue);
                            System.out.println("Output: \"" + decrypted + "\"");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Shift value is too large or invalid. Please enter a smaller integer.\n");
                        }
                    } else {
                        System.out.println("Invalid shift value. It must be an integer or an empty input.\n");
                    }
                }
            }
            else if (choice == 3) {
                System.out.println("Arithmetic Expression Evaluation was chosen");
                // TODO
            }
            else {
                System.out.println("Exit from the program was chosen");
                continueRunning = false;
            }

            if (continueRunning) {
                while (true) {
                    System.out.print("\nContinue? (y/n): ");
                    String cont = scanner.nextLine().trim();

                    if (cont.equalsIgnoreCase("y")) {
                        break;
                    } else if (cont.equalsIgnoreCase("n")) {
                        continueRunning = false;
                        System.out.println("You don't want to continue. Exiting program");
                        break;
                    } else {
                        System.out.println("Please enter \"y\" or \"n\"! A letter only! Don't use quotes!");
                    }
                }
            }
        }

        scanner.close();
    }
}
