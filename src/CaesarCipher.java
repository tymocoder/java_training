public class CaesarCipher {
    private static final String englishUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String englishLowercase = "abcdefghijklmnopqrstuvwxyz";
    private static final String russianUppercase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String russianLowercase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static String encrypt(String inputText, int shift) {
        return process(inputText, shift);
    }

    public static String decrypt(String inputText, int shift) {
        return process(inputText, -shift);
    }

    // Core logic separated into the process helper method to avoid code duplicating for encrypt and decrypt methods
    private static String process(String inputText, int shift) {
        String processOutput = "";
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            if (englishUppercase.indexOf(c) != -1) {
                processOutput += shiftChar(c, shift, englishUppercase);
            } else if (englishLowercase.indexOf(c) != -1) {
                processOutput += shiftChar(c, shift, englishLowercase);
            } else if (russianUppercase.indexOf(c) != -1) {
                processOutput += shiftChar(c, shift, russianUppercase);
            } else if (russianLowercase.indexOf(c) != -1) {
                processOutput += shiftChar(c, shift, russianLowercase);
            } else {
                processOutput += c; // Non-alphabetic characters remain unchanged
            }
        }
        return processOutput;
    }

    // Shifting logic separated into the shiftChar helper method to avoid code duplications in the process method
    private static char shiftChar(char c, int shift, String alphabet) {
        // Modulus used to avoid more complex loop logic when shift exceeds the alphabet length
        int shiftIndex = (alphabet.indexOf(c) + shift) % alphabet.length();
        // String length is added to handle the negative shift (converting into the positive)
        if (shiftIndex < 0) {
            shiftIndex += alphabet.length();
        }
        return alphabet.charAt(shiftIndex);
    }
}
