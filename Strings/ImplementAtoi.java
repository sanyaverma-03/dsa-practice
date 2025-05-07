/*
Problem: String to Integer(atoi)
Link: https://leetcode.com/problems/string-to-integer-atoi/description/

Description:
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
- Discards all leading whitespaces.
- Optional '+' or '-' sign.
- Converts digits until a non-digit character or overflow.
- Returns clamped value if out of range.

Approach:
- Skip whitespace
- Handle sign
- Parse digits and apply overflow check

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class ImplementAtoi {

    public static boolean isDigit(char ch){
        return (ch >= '0' && ch <= '9');
    }

    public int myAtoi(String s) {
        int ans = 0;
        int i = 0;
        int n = s.length();
        int sign = 1;

        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;

        // Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        // Convert digits
        while (i < n && isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }

    public static void main(String[] args) {
        ImplementAtoi solution = new ImplementAtoi();

        // Sample test cases
        String input1 = "   -42";
        String input2 = "4193 with words";
        String input3 = "+1";
        String input4 = "91283472332";

        System.out.println("Input: \"" + input1 + "\" Output: " + solution.myAtoi(input1));
        System.out.println("Input: \"" + input2 + "\" Output: " + solution.myAtoi(input2));
        System.out.println("Input: \"" + input3 + "\" Output: " + solution.myAtoi(input3));
        System.out.println("Input: \"" + input4 + "\" Output: " + solution.myAtoi(input4));
    }
}

