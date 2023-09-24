1.Maximum Odd Binary Number
  You are given a binary string s that contains at least one '1'.

You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.

Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros.

 

Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".
Example 2:

Input: s = "0101"
Output: "1001"
Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100". So the answer is "1001".
 

Constraints:

1 <= s.length <= 100
s consists only of '0' and '1'.
s contains at least one '1'.





  class Solution {
    public String maximumOddBinaryNumber(String s) {
//          int lastIndex = s.lastIndexOf('1');
    
//     // If there's only one '1', return the original string
//     if (lastIndex == 0) {
//         return s;
//     }
    
//     // Otherwise, rearrange the bits
//     StringBuilder result = new StringBuilder(s);
//     char temp = result.charAt(lastIndex);
//     result.setCharAt(lastIndex, result.charAt(lastIndex - 1));
//     result.setCharAt(lastIndex - 1, temp);
    
//     return result.reverse().toString();
        
        
        
        
        
        
        
        
        
        
        
//            int lastIndex = s.lastIndexOf('1');
    
//     // Rearrange the bits to make it an odd number
//     StringBuilder result = new StringBuilder(s);
//     char temp = result.charAt(lastIndex);
//     result.setCharAt(lastIndex, '1');
//     result.setCharAt(0, temp);
    
//     return result.toString();
        
        
        
        
        
        
        
        
        
        
        
        
        char[] arr = s.toCharArray();
    int lastIndex = -1;

    // Find the rightmost '1' in the string
    for (int i = arr.length - 1; i >= 0; i--) {
        if (arr[i] == '1') {
            lastIndex = i;
            break;
        }
    }

    // If the rightmost '1' is already at the end, return the input string
    if (lastIndex == arr.length - 1) {
        return s;
    }

    // Find the leftmost '0' after the rightmost '1'
    int leftmostZero = -1;
    for (int i = lastIndex + 1; i < arr.length; i++) {
        if (arr[i] == '0') {
            leftmostZero = i;
            break;
        }
    }

    // Swap the rightmost '1' with the leftmost '0'
    if (leftmostZero != -1) {
        char temp = arr[lastIndex];
        arr[lastIndex] = arr[leftmostZero];
        arr[leftmostZero] = temp;
    }

    return new String(arr);
    }
}
