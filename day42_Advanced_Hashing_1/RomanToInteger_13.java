package day42_Advanced_Hashing_1;

import java.util.HashMap;

class RomanToInteger_13 {
    // Function to convert a Roman numeral string to an integer
    public int romanToInt(String s) {
        // Create a HashMap to store the integer values corresponding to each Roman numeral character
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0; // Variable to keep track of the previous Roman numeral value

        // Iterate through the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanValues.get(s.charAt(i));

            // If the current value is less than the previous value, subtract it
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                // Otherwise, add the current value
                result += currentValue;
            }

            // Update the previous value for the next iteration
            prevValue = currentValue;
        }

        return result;
    }
}
