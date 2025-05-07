/*
Problem: Sum of Beauty of All substrings
Link: https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

Description:
Given a string s, the "beauty sum" of a substring is defined as the difference between the maximum and minimum frequencies of characters in the substring.
Your task is to find the total beauty sum of all substrings of s.

Approach:
1. Use a sliding window approach to iterate through all possible substrings.
2. Keep track of character frequencies in a hash array.
3. For each substring, compute the maximum and minimum frequencies and calculate the beauty sum.
4. Accumulate the beauty sum for all substrings.

Time Complexity: O(n^2)
Space Complexity: O(26) = O(1) since the array is fixed size of 26 characters.
*/


public class BeautySum {

    public int beautySum(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[26];  // Frequency array for 'a' to 'z'
            for (int j = i; j < s.length(); j++) {
                hash[s.charAt(j) - 'a']++;  // Update frequency of current char

                int maxEl = 0;
                int minEl = Integer.MAX_VALUE;

                // Find max and min (non-zero) frequency in current substring
                for (int num : hash) {
                    if (num > 0) {
                        maxEl = Math.max(maxEl, num);
                        minEl = Math.min(minEl, num);
                    }
                }

                count += maxEl - minEl;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BeautySum solution = new BeautySum();

        String input1 = "aabcb";
        String input2 = "aabcbaa";
        String input3 = "aaaa";

        System.out.println("Input: \"" + input1 + "\" Output: " + solution.beautySum(input1)); 
        System.out.println("Input: \"" + input2 + "\" Output: " + solution.beautySum(input2)); 
        System.out.println("Input: \"" + input3 + "\" Output: " + solution.beautySum(input3)); 
    }
}