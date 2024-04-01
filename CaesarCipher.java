/** Project: Alphabet Converter to Morse Code
 * Purpose Details: Create a custom morse code and caesar cipher, brute force, and SHA256 it
 * Course: IST 260W
 * Author: Taylor Liu
 * Date Developed: March 25, 2024
 * Last Date Changed:March 31, 2024
 * Rev: Taylor Liu

 */
import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {

    // Encrypt the text using caesar cipher with the new alphabet
    public static String caesarCipherOnNewAlphabet(String input) {
        StringBuilder result = new StringBuilder();
        // Gets new alphabet mapping
        HashMap<Character, String> alphabetMap = AlphabetConverter.getAlphabetMap();
        // Iterate through the characters
        for (char c : input.toCharArray()) {
            // Check if the character exists in the new alphabet
            if (alphabetMap.containsValue(String.valueOf(c))) {
                for (Map.Entry<Character, String> entry : alphabetMap.entrySet()) {
                    if (entry.getValue().equals(String.valueOf(c))) {
                        // Performs caesar cipher encryption by shifting the character by 5 positions
                        char shifted = (char) ((entry.getKey() - 'a' + 5) % 36 + 'a'); // Shifting by 5 characters
                        result.append(alphabetMap.get(shifted));
                        break;
                    }
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Method to decrypt the encrypted with Caesar cipher using new alphabet
    public static String caesarDecryptOnNewAlphabet(String encryptedText, String newAlphabetString) {
        StringBuilder result = new StringBuilder();
        // Iterate through the characters
        for (char c : encryptedText.toCharArray()) {
            // Check if the character exists in the new alphabet
            if (newAlphabetString.contains(String.valueOf(c))) {
                // Finds the index of the character in new alphabet
                int index = newAlphabetString.indexOf(c);
                // Reverse the shift by 5 to decrypt
                char originalChar = newAlphabetString.charAt((index - 5 + newAlphabetString.length()) % newAlphabetString.length()); // Reverse the Caesar Cipher shift by 5 characters
                result.append(originalChar);
            } else {
                result.append(c); // Keep unchanged if not found in the new alphabet string
            }
        }
        return result.toString();
    }

    // Method for Brute force
    public static void bruteForceShift(String encryptedText) {
        // Gets the new alphabet mapping
        HashMap<Character, String> alphabetMap = AlphabetConverter.getAlphabetMap();
        // Iterate through the shift of 0-25
        for (int shift = 0; shift < 26; shift++) {
            StringBuilder result = new StringBuilder();
            for (char c : encryptedText.toCharArray()) {
                if (alphabetMap.containsValue(String.valueOf(c))) {
                    for (Map.Entry<Character, String> entry :alphabetMap.entrySet()) {
                        if (entry.getValue().charAt(0) == c) {
                            // Calculate the indext of the decrypted character after shifting
                            int index = entry.getKey() - 'a';
                            int shiftedIndex = (index + shift) % 36;
                            char shiftedChar = (char) (shiftedIndex + 'a');
                            String shiftedSymbol = alphabetMap.get(shiftedChar);
                            if (shiftedSymbol != null) {
                                result.append(shiftedSymbol);
                            } else {
                                result.append(c);
                            }
                            break;
                        }
                    }
                } else {
                    result.append(c);
                }
            }
            // Prints out the decrypted text for current shifts
            System.out.println("Shift " + shift + ": " + result.toString());
        }
    }
}