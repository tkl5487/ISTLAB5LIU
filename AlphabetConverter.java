/** Project: Alphabet Converter to Morse Code
 * Purpose Details: Create a custom morse code and caesar cipher, brute force, and SHA256 it
 * Course: IST 260W
 * Author: Taylor Liu
 * Date Developed: March 25, 2024
 * Last Date Changed:March 31, 2024
 * Rev: Taylor Liu

 */
import java.util.HashMap;

public class AlphabetConverter {

    // HashMap to store the mapping from english to our custom symbols
    private static final HashMap<Character, String> alphabetMap = new HashMap<>();

    // HashMap to store the reverse from our custom symbol to english
    private static final HashMap<String, Character> reverseAlphabetMap = new HashMap<>();

    static {
        // Define the new alphabet mapping
        alphabetMap.put('a', "~");
        alphabetMap.put('b', "!");
        alphabetMap.put('c', "@");
        alphabetMap.put('d', "#");
        alphabetMap.put('e', "$");
        alphabetMap.put('f', "%");
        alphabetMap.put('g', "^");
        alphabetMap.put('h', "&");
        alphabetMap.put('i', "*");
        alphabetMap.put('j', "~!");
        alphabetMap.put('k', "!@");
        alphabetMap.put('l', "@#");
        alphabetMap.put('m', "#$");
        alphabetMap.put('n', "$%");
        alphabetMap.put('o', "%^");
        alphabetMap.put('p', "^&");
        alphabetMap.put('q', "&*");
        alphabetMap.put('r', "~*");
        alphabetMap.put('s', "~@");
        alphabetMap.put('t', "!#");
        alphabetMap.put('u', "@$");
        alphabetMap.put('v', "#%");
        alphabetMap.put('w', "$^");
        alphabetMap.put('x', "%&");
        alphabetMap.put('y', "^*");
        alphabetMap.put('z', "&~");
        alphabetMap.put('0', "@^*");
        alphabetMap.put('1', "&$!");
        alphabetMap.put('2', "~%&");
        alphabetMap.put('3', "#*~");
        alphabetMap.put('4', "*!%");
        alphabetMap.put('5', "!^@");
        alphabetMap.put('6', "%#!");
        alphabetMap.put('7', "^$#");
        alphabetMap.put('8', "%~&");
        alphabetMap.put('9', "@~*");

        // Initialize the reverse mapping
        alphabetMap.forEach((key, value) -> reverseAlphabetMap.put(value, key));
    }

    // Method to get the alphabet map
    public static HashMap<Character, String> getAlphabetMap(){
        return alphabetMap;
    }

    // Method to convert the input text to the new alphabet
    public static String toNewAlphabet(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toLowerCase().toCharArray()) {
            result.append(alphabetMap.getOrDefault(c, String.valueOf(c)));
        }
        return result.toString();
    }

    // Convert the inut text from the new alphabet string back to english
    public static String toEnglish(String input) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            String part = "";
            Character match = null;
            // Looks for longest symbol
            for (int j = i + 1; j <= input.length(); j++) {
                String temp = input.substring(i, j);
                if (reverseAlphabetMap.containsKey(temp)) {
                    part = temp;
                    match = reverseAlphabetMap.get(temp);
                }
            }
            if (match != null) {
                result.append(match);
                i += part.length();
            } else {

                result.append(input.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}

