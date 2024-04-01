/** Project: Alphabet Converter to Morse Code
 * Purpose Details: Create a custom morse code and caesar cipher, brute force, and SHA256 it
 * Course: IST 260W
 * Author: Taylor Liu
 * Date Developed: March 25, 2024
 * Last Date Changed:March 31, 2024
 * Rev: Taylor Liu

 */
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

// Calculate the SHA256
public class SHA256Hasher {

    // Calculate the SHA-256 of the string inputted
    public static String calculateSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // Calculates hash of input
        byte[] hash = digest.digest(input.getBytes());
        // Convert the byte to hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        // Return hexadecimal of the hash
        return hexString.toString();
    }
}