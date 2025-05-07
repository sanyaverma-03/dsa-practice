/*
Problem: Longest Palindromic Substring
Link: https://leetcode.com/problems/longest-palindromic-substring/description/
  
Description:
Given a string `s`, return the longest palindromic substring in `s`.
Example:
Input: "babad"
Output: "bab" or "aba"

Approach:
- Expand around center: Every palindrome can be expanded from its middle.
- There are 2n - 1 centers (each character and between each pair).
- For each index, expand for both odd and even length palindromes.
- Update the result if a longer palindrome is found.

Time Complexity: O(n^2)  
Space Complexity: O(1)   
*/

public class LongestPalindromeSubstring {

    // Expand around the center indices i and j
    String expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        return s.substring(i + 1, j); // Return valid palindromic substring
    }

    // Main function to return the longest palindromic substring
    public String longestPalindrome(String s) {
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            String oddInd = expand(s, i, i);       // Odd length palindromes
            String evenInd = expand(s, i, i + 1);   // Even length palindromes

            if (oddInd.length() > maxStr.length()) maxStr = oddInd;
            if (evenInd.length() > maxStr.length()) maxStr = evenInd;
        }
        return maxStr;
    }

    // Example usage
    public static void main(String[] args) {
        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();
        String input = "babad";
        String result = solution.longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}