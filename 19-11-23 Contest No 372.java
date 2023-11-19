1.Make Three Strings Equal


  You are given three strings s1, s2, and s3. You have to perform the following operation on these three strings as many times as you want.

In one operation you can choose one of these three strings such that its length is at least 2 and delete the rightmost character of it.

Return the minimum number of operations you need to perform to make the three strings equal if there is a way to make them equal, otherwise, return -1.

 

Example 1:

Input: s1 = "abc", s2 = "abb", s3 = "ab"
Output: 2
Explanation: Performing operations on s1 and s2 once will lead to three equal strings.
It can be shown that there is no way to make them equal with less than two operations.
Example 2:

Input: s1 = "dac", s2 = "bac", s3 = "cac"
Output: -1
Explanation: Because the leftmost letters of s1 and s2 are not equal, they could not be equal after any number of operations. So the answer is -1.
 

Constraints:

1 <= s1.length, s2.length, s3.length <= 100
s1, s2 and s3 consist only of lowercase English letters.




  class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        
        int a=s1.length(),b=s2.length(),c=s3.length();
        
        int arr[]={a,b,c};
        
        Arrays.sort(arr);
        
        int small=arr[0];
        
        int ans2=0;
        
        if(small<1)
            return -1;
        else{
            
            for(int i=0;i<small;i++){
                
                char fir=s1.charAt(i);
                char sec=s2.charAt(i);
                char th=s3.charAt(i);
                
                if(fir==sec && sec==th){
                    if(i==small-1){
                        int df=arr[1]-arr[0];
                        int df2=arr[2]-arr[0];
                        ans2=df+df2;
                       
                    }
                }else{
                    if(i==0){
                        ans2= -1;
                    }else{
                        int df=arr[1]-i;
                        int df2=arr[2]-i;
                        ans2=df+df2;
                        int df3=arr[0]-i;
                        ans2+=df3;
                        // 012345678 = 9
                    }
                    break;
                }
            }
            return ans2;
            
        }
        
        
    }
}



2.Separate Black and White Balls


  There are n balls on a table, each ball has a color black or white.

You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.

In each step, you can choose two adjacent balls and swap them.

Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.

 

Example 1:

Input: s = "101"
Output: 1
Explanation: We can group all the black balls to the right in the following way:
- Swap s[0] and s[1], s = "011".
Initially, 1s are not grouped together, requiring at least 1 step to group them to the right.
Example 2:

Input: s = "100"
Output: 2
Explanation: We can group all the black balls to the right in the following way:
- Swap s[0] and s[1], s = "010".
- Swap s[1] and s[2], s = "001".
It can be proven that the minimum number of steps needed is 2.
Example 3:

Input: s = "0111"
Output: 0
Explanation: All the black balls are already grouped to the right.
 

Constraints:

1 <= n == s.length <= 105
s[i] is either '0' or '1'.



  // class Solution {
//     public long minimumSteps(String s) {
//          int n = s.length();
//         int blackCount = 0; // Count of black balls encountered so far
//         int steps = 0; // Minimum number of steps

//         for (int i = 0; i < n; i++) {
//             if (s.charAt(i) == '1') {
//                 blackCount++; // Increment black count
//             } else {
//                 // Calculate the number of steps needed to move the white ball to the left
//                 steps += blackCount;
//             }
//         }

//         return steps;
//     }
// }




class Solution {
    public long minimumSteps(String s) {
        
        
        //   0123456789
        
        long ans2=0;
        
        int len=s.length();
        
        int left=0;
        
        for(int i=0;i<len;i++){
            
            char c=s.charAt(i);
            if(c=='0'){
                int df=i-left;
                ans2+=df;
                left++;
            }else{
                // black
            }
        }
        
        return ans2;
        
    }
}

3.Maximum Xor Product

  Given three integers a, b, and n, return the maximum value of (a XOR x) * (b XOR x) where 0 <= x < 2n.

Since the answer may be too large, return it modulo 109 + 7.

Note that XOR is the bitwise XOR operation.

 

Example 1:

Input: a = 12, b = 5, n = 4
Output: 98
Explanation: For x = 2, (a XOR x) = 14 and (b XOR x) = 7. Hence, (a XOR x) * (b XOR x) = 98. 
It can be shown that 98 is the maximum value of (a XOR x) * (b XOR x) for all 0 <= x < 2n.
Example 2:

Input: a = 6, b = 7 , n = 5
Output: 930
Explanation: For x = 25, (a XOR x) = 31 and (b XOR x) = 30. Hence, (a XOR x) * (b XOR x) = 930.
It can be shown that 930 is the maximum value of (a XOR x) * (b XOR x) for all 0 <= x < 2n.
Example 3:

Input: a = 1, b = 6, n = 3
Output: 12
Explanation: For x = 5, (a XOR x) = 4 and (b XOR x) = 3. Hence, (a XOR x) * (b XOR x) = 12.
It can be shown that 12 is the maximum value of (a XOR x) * (b XOR x) for all 0 <= x < 2n.
 

Constraints:

0 <= a, b < 250
0 <= n <= 50


  class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long maxProduct = 0;
        long mod = 1000000007L;

        for (int x = 0; x < (1 << n); x++) {
            long currentProduct = ((long) (a ^ x) * (long) (b ^ x)) % mod;
            maxProduct = Math.max(maxProduct, currentProduct);
        }

        return (int) maxProduct;
    }
}
