Given a positive integer num represented as a string, return the integer num without trailing zeros as a string.

 

Example 1:

Input: num = "51230100"
Output: "512301"
Explanation: Integer "51230100" has 2 trailing zeros, we remove them and return integer "512301".


class Solution {
    public String removeTrailingZeros(String s) {
     StringBuilder sb = new StringBuilder(s);
        
         while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
        sb.setLength(sb.length() - 1);
    }
    return sb.toString();
    }
}
