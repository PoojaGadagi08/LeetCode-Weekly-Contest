
1.Minimum String Length After Removing Substrings

You are given a string s consisting only of uppercase English letters.

You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.

Return the minimum possible length of the resulting string that you can obtain.

Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.

 Example 1:

Input: s = "ABFCACDB"
Output: 2
Explanation: We can do the following operations:
- Remove the substring "ABFCACDB", so s = "FCACDB".
- Remove the substring "FCACDB", so s = "FCAB".
- Remove the substring "FCAB", so s = "FC".
So the resulting length of the string is 2.
It can be shown that it is the minimum length that we can obtain.
  
  
  
  class Solution {
    public int minLength(String s) {
      int l=s.length();
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<l;i++){
            char c=s.charAt(i);
            
            if(st.size()==0)
                st.push(c);
            else{
                char t=st.peek();
                if(c=='B' || c=='D'){
                    if(c=='B'){
                        if(t=='A')
                            st.pop();
                        else
                            st.push(c);
                    }else{
                        if(t=='C')
                            st.pop();
                        else
                            st.push(c);
                    }
                }
                else
                    st.push(c);
            }
            } 
        return st.size();
    }
}



2.Lexicographically Smallest Palindrome

You are given a string s consisting of lowercase English letters, and you are allowed to perform operations on it. In one operation, you can replace a character in s with another lowercase English letter.

Your task is to make s a palindrome with the minimum number of operations possible. If there are multiple palindromes that can be made using the minimum number of operations, make the lexicographically smallest one.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b.

Return the resulting palindrome string.
 
 Example 1:

Input: s = "egcfe"
Output: "efcfe"
Explanation: The minimum number of operations to make "egcfe" a palindrome is 1, and the lexicographically smallest palindrome string we can get by modifying
one character is "efcfe", by changing 'g'.

 
 class Solution {
    public String makeSmallestPalindrome(String s) {
        int l=s.length();
        
        char arr[]=new char[l];
        for(int i=0;i<l;i++)
            arr[i]=s.charAt(i);
        
            int ha=l/2;
            int la=l-1;
            for(int i=0;i<ha;i++){
                if(s.charAt(i)==s.charAt(la)){
                    arr[i]=s.charAt(i);
                        arr[la]=s.charAt(la);
                }else{
                    if(s.charAt(i)<s.charAt(la)){
                        arr[i]=s.charAt(i);
                        arr[la]=s.charAt(i);
                    }else{
                        arr[i]=s.charAt(la);
                        arr[la]=s.charAt(la);
                    }
                }
                la--;
            }
                
                String ans="";
                for(int i=0;i<l;i++){
                    ans+=arr[i]+"";
                }
            return ans;
        }
    }


