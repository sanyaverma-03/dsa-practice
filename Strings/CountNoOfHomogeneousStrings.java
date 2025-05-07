/*
Problem: Count number of Homogeneous Strings
Link: https://leetcode.com/problems/count-number-of-homogenous-substrings/submissions/1627775572/

Description:
Given a string `s`, return the number of homogeneous substrings of `s`. A homogeneous substring is a substring consisting of the same character.
For example, the string `"aaab"` has the following homogeneous substrings:
- `"a"` (3 times)
- `"aa"` (2 times)
- `"aaa"` (1 time)
- `"b"` (1 time)

Approach:
Iterate through the string and count the length of consecutive characters.
For each segment of consecutive characters of length `n`, calculate the number of homogeneous substrings using the formula:
   n*(n+1)/2
Keep track of the result modulo `10^9 + 7` to avoid overflow.

Time Complexity: O(n)
Space Complexity: O(1)
*/


public class CountNoOfHomogeneousStrings {
        public int countHomogenous(String s) {
            int count = 0;
            int mod = 1_000_000_007;
            int i = 0;
            int j = 0;
    
            // Traverse the string to find homogenous substrings
            while (j < s.length()) {
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                } else {
                    // Calculate the number of homogenous substrings in the range [i, j)
                    int len = j - i;
                    count = (int)((count + (long)len * (len + 1) / 2) % mod);
                    i = j;
                }
            }
    
            // Don't forget the last homogenous substring
            int len = j - i;
            count = (int)((count + (long)len * (len + 1) / 2) % mod);
    
            return count;
        }
    
        public static void main(String[] args) {
            CountNoOfHomogeneousStrings solution = new CountNoOfHomogeneousStrings();
    
            // Sample test cases
            System.out.println(solution.countHomogenous("abbcccaa")); 
            System.out.println(solution.countHomogenous("xy"));       
            System.out.println(solution.countHomogenous("zzzzz"));     
        }
    
}
