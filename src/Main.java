import java.util.Scanner; // Class import to read an input from the console

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // The Scanner instance that reads text from the input stream
        boolean continueRunning = true; // The current state

        System.out.println("Welcome!");

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
                System.out.println("\nCaesar Cipher Encryption was chosen");
                String inputMode;
                while (true) {
                    System.out.print("Enter 'm' for the manual text input or 'f' for the file input: ");
                    inputMode = scanner.nextLine().trim().toLowerCase();

                    if (inputMode.equals("m") || inputMode.equals("f")) {
                        break;
                    } else {
                        System.out.println("\nInvalid input. Enter 'm' for manual or 'f' for file!");
                    }
                }

                String textToEncrypt;
                if (inputMode.equals("f")) {
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine().trim();

                    if (!filePath.toLowerCase().endsWith(".txt")) {
                        System.out.println("\nInvalid path or file format. Please provide a path to a '.txt' file. Or use manual input.");
                        continue;
                    }

                    try {
                        textToEncrypt = java.nio.file.Files.readString(java.nio.file.Paths.get(filePath));
                    } catch (java.io.IOException e) {
                        System.out.println("\nFailed to read file: " + e.getMessage());
                        System.out.println("The path entered might be invalid");
                        continue;
                    }
                } else {
                    System.out.print("Enter text to encrypt: ");
                    textToEncrypt = scanner.nextLine();
                }


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

                String inputMode;
                while (true) {
                    System.out.print("Enter 'm' for manual text input or 'f' for file input: ");
                    inputMode = scanner.nextLine().trim().toLowerCase();

                    if (inputMode.equals("m") || inputMode.equals("f")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Enter 'm' for manual or 'f' for file!\n");
                    }
                }

                String textToDecrypt;
                if (inputMode.equals("f")) {
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine().trim();

                    if (!filePath.toLowerCase().endsWith(".txt")) {
                        System.out.println("\nInvalid path format. Please provide a path to a '.txt' file. Or use manual input.");
                        continue;
                    }

                    try {
                        textToDecrypt = java.nio.file.Files.readString(java.nio.file.Paths.get(filePath));
                    } catch (java.io.IOException e) {
                        System.out.println("\nFailed to read file: " + e.getMessage());
                        System.out.println("The path entered might be invalid");
                        continue;
                    }
                } else {
                    System.out.print("Enter text to decrypt: ");
                    textToDecrypt = scanner.nextLine();
                }

                while (true) {
                    System.out.print("Enter shift value (integer) or leave empty to try all possible variants: ");
                    String shiftInput = scanner.nextLine().trim();

                    if (shiftInput.isEmpty()) {
                        System.out.println("\nTrying all possible shifts:\n");
                        for (int i = 1; i < 26; i++) {
                            String attempt = CaesarCipher.decrypt(textToDecrypt, i);
                            System.out.println("Shift " + i + ": " + attempt);
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
                System.out.print("Enter arithmetic expression: ");
                String inputExpression = scanner.nextLine().trim();

                try {
                    double result = ExpressionEvaluator.evaluate(inputExpression);
                    System.out.println("Result: " + result);
                } catch (Exception e) {
                    System.out.println("Error evaluating expression: " + e.getMessage());
                }
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
