1) Furthest Point From Origin




  You are given a string moves of length n consisting only of characters 'L', 'R', and '_'. The string represents your movement on a number line starting from the origin 0.

In the ith move, you can choose one of the following directions:

move to the left if moves[i] = 'L' or moves[i] = '_'
move to the right if moves[i] = 'R' or moves[i] = '_'
Return the distance from the origin of the furthest point you can get to after n moves.

 

Example 1:

Input: moves = "L_RL__R"
Output: 3
Explanation: The furthest point we can reach from the origin 0 is point -3 through the following sequence of moves "LLRLLLR".
Example 2:

Input: moves = "_R__LL_"
Output: 5
Explanation: The furthest point we can reach from the origin 0 is point -5 through the following sequence of moves "LRLLLLL".
Example 3:

Input: moves = "_______"
Output: 7
Explanation: The furthest point we can reach from the origin 0 is point 7 through the following sequence of moves "RRRRRRR".
 

Constraints:

1 <= moves.length == n <= 50
moves consists only of characters 'L', 'R' and '_'.





  class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int len=moves.length();
        
        int lcountt=0;
        int rcountt=0;
        int space=0;
        
        for(int i=0;i<len;i++){
            
            char c=moves.charAt(i);
            if(c=='L'){
                lcountt++;
            }else if(c=='R'){
                rcountt++;
            }else{
                space++;
            }
        }
        
        if(space==len){
            return len;
        }else{
            
            String str="";
            char put=0;
            if(lcountt==rcountt){
                put='R';
            }else if(lcountt>rcountt){
                put='L';
            }else{
                put='R';
            }
            
            for(int i=0;i<len;i++){
                
                char c=moves.charAt(i);
                if(c=='_'){
                    str=str+""+put+"";
                }else
                    str=str+c+"";
            }
          //  System.out.println(str);
            int start=0;
            
            for(int i=0;i<len;i++){
                
                char c=str.charAt(i);
                if(c=='L'){
                    start--;
                }else{
                    start++;
                }
            }
            
            if(start<0)
                return start*-1;
            else
                return start;
        }
    }
}
        
        



      2) Find the Minimum Possible Sum of a Beautiful Array


        You are given positive integers n and target.

An array nums is beautiful if it meets the following conditions:

nums.length == n.
nums consists of pairwise distinct positive integers.
There doesn't exist two distinct indices, i and j, in the range [0, n - 1], such that nums[i] + nums[j] == target.
Return the minimum possible sum that a beautiful array could have.

 

Example 1:

Input: n = 2, target = 3
Output: 4
Explanation: We can see that nums = [1,3] is beautiful.
- The array nums has length n = 2.
- The array nums consists of pairwise distinct positive integers.
- There doesn't exist two distinct indices, i and j, with nums[i] + nums[j] == 3.
It can be proven that 4 is the minimum possible sum that a beautiful array could have.
Example 2:

Input: n = 3, target = 3
Output: 8
Explanation: We can see that nums = [1,3,4] is beautiful.
- The array nums has length n = 3.
- The array nums consists of pairwise distinct positive integers.
- There doesn't exist two distinct indices, i and j, with nums[i] + nums[j] == 3.
It can be proven that 8 is the minimum possible sum that a beautiful array could have.
Example 3:

Input: n = 1, target = 1
Output: 1
Explanation: We can see, that nums = [1] is beautiful.
 

Constraints:

1 <= n <= 105
1 <= target <= 105



  class Solution {
    public long minimumPossibleSum(int n, int target) {
        
        
        int k=target;
        HashSet<Long> h=new HashSet<>();
        
        long sumt=0;
        
        long firstr=1;
        
        while(n>0){
            
            long sec=(long)k-firstr;
            
            if(h.contains(firstr)==false){
                sumt+=firstr;
                n--;
            }
            h.add(sec);
            firstr++;
        }
        
        return sumt;
        
    }
}


        
    
