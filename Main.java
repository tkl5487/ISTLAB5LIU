/** Project: Alphabet Converter to Morse Code
 * Purpose Details: Create a custom morse code and caesar cipher, brute force, and SHA256 it
 * Course: IST 260W
 * Author: Taylor Liu
 * Date Developed: March 25, 2024
 * Last Date Changed:March 31, 2024
 * Rev: Taylor Liu

 */
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.print("Enter English string: ");
        String englishString = scanner.nextLine();

        // Convert to new alphabet string
        String newAlphabetString = AlphabetConverter.toNewAlphabet(englishString);
        System.out.println("New Alphabet String: " + newAlphabetString);

        // Prints out SHA256 Hasher
        try {
            String SHA256Hash = SHA256Hasher.calculateSHA256(newAlphabetString);
            System.out.println("SHA-256 Hash: " + SHA256Hash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 algorithm not found.");
            e.printStackTrace();
        }



        // Perform Caesar Cipher with 5-character shift on new alphabet string
        String encryptedText = CaesarCipher.caesarCipherOnNewAlphabet(newAlphabetString);
        System.out.println("Encrypted Text: " + encryptedText);

        // Decrypt the encrypted text
        String decryptedText = CaesarCipher.caesarDecryptOnNewAlphabet(encryptedText, newAlphabetString);
        System.out.println("Decrypted Text: " + decryptedText);

        // Brute Force on encrypted text
        CaesarCipher.bruteForceShift(encryptedText);

        // Converts New Alphabet string to english string
        String originalEnglishString = AlphabetConverter.toEnglish(newAlphabetString);
        System.out.println("Original English String: " + originalEnglishString);

        scanner.close();
    }
}