
// 1.Minimum String Length After Removing Substrings

// You are given a string s consisting only of uppercase English letters.

// You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.

// Return the minimum possible length of the resulting string that you can obtain.

// Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.

//  Example 1:

// Input: s = "ABFCACDB"
// Output: 2
// Explanation: We can do the following operations:
// - Remove the substring "ABFCACDB", so s = "FCACDB".
// - Remove the substring "FCACDB", so s = "FCAB".
// - Remove the substring "FCAB", so s = "FC".
// So the resulting length of the string is 2.
// It can be shown that it is the minimum length that we can obtain.
  
  
  
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



// 2.Lexicographically Smallest Palindrome

// You are given a string s consisting of lowercase English letters, and you are allowed to perform operations on it. In one operation,
// you can replace a character in s with another lowercase English letter.

// Your task is to make s a palindrome with the minimum number of operations possible. If there are multiple palindromes that can be made using
// the minimum number of operations, make the lexicographically smallest one.

// A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that 
// appears earlier in the alphabet than the corresponding letter in b.

// Return the resulting palindrome string.
 
//  Example 1:

// Input: s = "egcfe"
// Output: "efcfe"
// Explanation: The minimum number of operations to make "egcfe" a palindrome is 1, and the lexicographically smallest palindrome string we can get by modifying
// one character is "efcfe", by changing 'g'.

 
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




2.Given a 0-indexed 2D grid of size m x n, you should find the matrix answer of size m x n.

The value of each cell (r, c) of the matrix answer is calculated in the following way:

Let topLeft[r][c] be the number of distinct values in the top-left diagonal of the cell (r, c) in the matrix grid.
Let bottomRight[r][c] be the number of distinct values in the bottom-right diagonal of the cell (r, c) in the matrix grid.
Then answer[r][c] = |topLeft[r][c] - bottomRight[r][c]|.

Return the matrix answer.

A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end.

A cell (r1, c1) belongs to the top-left diagonal of the cell (r, c), if both belong to the same diagonal and r1 < r. Similarly is defined bottom-right diagonal.

 

Example 1:



Input: grid = [[1,2,3],[3,1,5],[3,2,1]]
Output: [[1,1,0],[1,0,1],[0,1,1]]
Explanation: The 1st diagram denotes the initial grid. 
The 2nd diagram denotes a grid for cell (0,0), where blue-colored cells are cells on its bottom-right diagonal.
The 3rd diagram denotes a grid for cell (1,2), where red-colored cells are cells on its top-left diagonal.
The 4th diagram denotes a grid for cell (1,1), where blue-colored cells are cells on its bottom-right diagonal and red-colored cells are cells on its top-left diagonal.
- The cell (0,0) contains [1,1] on its bottom-right diagonal and [] on its top-left diagonal. The answer is |1 - 0| = 1.
- The cell (1,2) contains [] on its bottom-right diagonal and [2] on its top-left diagonal. The answer is |0 - 1| = 1.
- The cell (1,1) contains [1] on its bottom-right diagonal and [1] on its top-left diagonal. The answer is |1 - 1| = 0.
The answers of other cells are similarly calculated.
 
 
 
 class Solution {
    
    public int getTL(int grid[][],int row,int col){
        int len=grid.length;
        int l=grid[0].length;
        
        HashSet<Integer> h=new HashSet<>();
        while(true){
            try{
                row--;
                col--;
                h.add(grid[row][col]);
            }catch(Exception e){
                break;
            }
        }
        return h.size();
    }
    
     public int getBR(int grid[][],int row,int col){
        int len=grid.length;
        int l=grid[0].length;
        
        HashSet<Integer> h=new HashSet<>();
        while(true){
            try{
                row++;
                col++;
                h.add(grid[row][col]);
            }catch(Exception e){
                break;
            }
        }
        return h.size();
    }
    
    
    public int[][] differenceOfDistinctValues(int[][] grid) {
        
        int len=grid.length;
        int l=grid[0].length;
        int ans[][]=new int [len][l];
        
        for(int i=0;i<len;i++){
            for(int j=0;j<l;j++){
            int tl=getTL(grid,i,j);
                int br=getBR(grid,i,j);
                    
                    System.out.println(tl+" "+br);
                int df=tl-br;
                
                if(df<0)
                    df=df*-1;
                
                ans[i][j]=df;
        }
    }
        return ans;
        
    }
}


