1)
1) Number of Beautiful Pairs
  You are given a 0-indexed integer array nums. A pair of indices i, j where 0 <= i < j < nums.length is called beautiful if the first digit of nums[i] and the last digit of nums[j] are coprime.

Return the total number of beautiful pairs in nums.

Two integers x and y are coprime if there is no integer greater than 1 that divides both of them. In other words, x and y are coprime if gcd(x, y) == 1, where gcd(x, y) is the greatest common divisor of x and y.

 

Example 1:

Input: nums = [2,5,1,4]
Output: 5
Explanation: There are 5 beautiful pairs in nums:
When i = 0 and j = 1: the first digit of nums[0] is 2, and the last digit of nums[1] is 5. We can confirm that 2 and 5 are coprime, since gcd(2,5) == 1.
When i = 0 and j = 2: the first digit of nums[0] is 2, and the last digit of nums[2] is 1. Indeed, gcd(2,1) == 1.
When i = 1 and j = 2: the first digit of nums[1] is 5, and the last digit of nums[2] is 1. Indeed, gcd(5,1) == 1.
When i = 1 and j = 3: the first digit of nums[1] is 5, and the last digit of nums[3] is 4. Indeed, gcd(5,4) == 1.
When i = 2 and j = 3: the first digit of nums[2] is 1, and the last digit of nums[3] is 4. Indeed, gcd(1,4) == 1.
Thus, we return 5.
Example 2:

Input: nums = [11,21,12]
Output: 2
Explanation: There are 2 beautiful pairs:
When i = 0 and j = 1: the first digit of nums[0] is 1, and the last digit of nums[1] is 1. Indeed, gcd(1,1) == 1.
When i = 0 and j = 2: the first digit of nums[0] is 1, and the last digit of nums[2] is 2. Indeed, gcd(1,2) == 1.
Thus, we return 2.



  class Solution {
    public int countBeautifulPairs(int[] n) {
//         int c=0;
// //         //int j=0;
// //         int i=n[0];
// //         int j=n[1];
        
// //             while(j<n.length){
// //                 if(gcd(i,j)==1)
// //                     c++;
// //                 j++;
// //             }
// //         i++;
        
// //         return c;
//         int N=n.length;
//         Arrays.sort(n);
//         for (int i = 0; i < N-1; i++) {
//             for (int j = i+1 ; j < N; j++) {
//                if(gcd(n[i],n[j])==1)
//                    c++;   
//             }
//         }
        
        int c=0;
        int l=n.length;
        for(int i=0;i<l-1;i++){
            String f=n[i]+"";
            int left=f.charAt(0)-48;
            
            for(int j=i+1;j<l;j++){
                String last=n[j]+"";
                int lav=last.charAt(last.length()-1)-48;
                
                int gcd=gcd(left,lav);
                if(gcd==1)
                    c++;
            }
        }
        return c;
    }
    public int gcd(int a,int b){
        int i;
        if(a<b)
            i=a;
        else
            i=b;
        
        for(i=i;i>1;i--){
            if(a%i==0 && b%i==0)
                return i;
            
        }
        return 1;
    }
}













2)Ways to Split Array Into Good Subarrays


  You are given a binary array nums.

A subarray of an array is good if it contains exactly one element with the value 1.

Return an integer denoting the number of ways to split the array nums into good subarrays. As the number may be too large, return it modulo 109 + 7.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [0,1,0,0,1]
Output: 3
Explanation: There are 3 ways to split nums into good subarrays:
- [0,1] [0,0,1]
- [0,1,0] [0,1]
- [0,1,0,0] [1]
Example 2:

Input: nums = [0,1,0]
Output: 1
Explanation: There is 1 way to split nums into good subarrays:
- [0,1,0]




class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        List<Integer> lit=new ArrayList<>();
        
        long mod3=1000000007L;
        int len=nums.length;
        
        for(int i=0;i<len;i++){
            if (nums[i]==1)
                lit.add(i);
        }
        
        long ans=0;
        if(lit.size()>0)
            ans=1;
        
        long dp=ans;
        
        for(int i=lit.size()-2;i>=0;i--){
            int l=lit.get(i);
            int r=lit.get(i+1);
            
            int df=r-l;
        long mul=((long)df%mod3*(long)dp%mod3)%mod3;
            dp=mul;
            ans=mul;
        }
        return (int)ans;
    }
}
