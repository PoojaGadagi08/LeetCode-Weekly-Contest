// 1)Minimize String Length

// Given a 0-indexed string s, repeatedly perform the following operation any number of times:

// Choose an index i in the string, and let c be the character in position i. Delete the closest occurrence of c to the left of i (if any) and the closest occurrence of c to
// the right of i (if any).
// Your task is to minimize the length of s by performing the above operation any number of times.

// Return an integer denoting the length of the minimized string.
  
//   Example 1:

// Input: s = "aaabc"
// Output: 3
// Explanation: In this example, s is "aaabc". We can start by selecting the character 'a' at index 1. We then remove the closest 'a' to the left of index 1, which is at index 0, 
// and the closest 'a' to the right of index 1, which is at index 2.
//   After this operation, the string becomes "abc". Any further operation we perform on the string will leave it unchanged. Therefore, the length of the minimized string is 3.
  
  
  
  class Solution {
    public int minimizedStringLength(String s) {
       HashSet<Character> h=new HashSet<>();
        for(int i=0;i<s.length();i++){
            h.add(s.charAt(i));
        }
        return h.size();
    }
}


// 2)Semi-Ordered Permutation

// You are given a 0-indexed permutation of n integers nums.

// A permutation is called semi-ordered if the first number equals 1 and the last number equals n. You can perform the below operation as many times as you want until you make 
// nums a semi-ordered permutation:

// Pick two adjacent elements in nums, then swap them.
// Return the minimum number of operations to make nums a semi-ordered permutation.

// A permutation is a sequence of integers from 1 to n of length n containing each number exactly once.
  
//   Example 1:

// Input: nums = [2,1,4,3]
// Output: 2
// Explanation: We can make the permutation semi-ordered using these sequence of operations: 
// 1 - swap i = 0 and j = 1. The permutation becomes [1,2,4,3].
// 2 - swap i = 2 and j = 3. The permutation becomes [1,2,3,4].
// It can be proved that there is no sequence of less than two operations that make nums a semi-ordered permutation. 
  
  class Solution {
    public int semiOrderedPermutation(int[] n) {
     int oi=0;
        int ni=0;
        
        for(int i=0;i<n.length;i++){
            int v=n[i];
            if(v==1 || v==n.length){
                if(v==1)
                    oi=i;
                else
                    ni=i;
            }
        }
        
        int df=n.length-ni;
        df--;
        
        int tot=oi+df;
        
        if(oi>ni) tot--;
        return tot;
    }
}
