1)Max Pair Sum in an Array


  You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the maximum digit in both numbers are equal.

Return the maximum sum or -1 if no such pair exists.

 

Example 1:

Input: nums = [51,71,17,24,42]
Output: 88
Explanation: 
For i = 1 and j = 2, nums[i] and nums[j] have equal maximum digits with a pair sum of 71 + 17 = 88. 
For i = 3 and j = 4, nums[i] and nums[j] have equal maximum digits with a pair sum of 24 + 42 = 66.
It can be shown that there are no other pairs with equal maximum digits, so the answer is 88.
Example 2:

Input: nums = [1,2,3,4]
Output: -1
Explanation: No pair exists in nums with equal maximum digits.
 

Constraints:

2 <= nums.length <= 100
1 <= nums[i] <= 104




  class Solution {
    
    public int getMax(String s){
        
        int max=s.charAt(0)-48;
        
        for(int i=1;i<s.length();i++){
            
            int val=s.charAt(i)-48;
            if(val>max)
                max=val;
        }
        return max;
    }
    
    public int maxSum(int[] nums) {
        
        int lent=nums.length;
        
        int maxt=-1;
        
        for(int i=0;i<lent-1;i++){
            
            for(int j=i+1;j<lent;j++){
                
                String a=nums[i]+"";
                String b=nums[j]+"";
                
                int val1=getMax(a);
                int val2=getMax(b);
                
                if(val1==val2){
                    
                    int sum=nums[i]+nums[j];
                    if(sum>maxt)
                        maxt=sum;
                }
                
            }
        }
        
        return maxt;
    }
}



2)Double a Number Represented as a Linked List

  You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

 

Example 1:


Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
Example 2:


Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.




  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        
        List<Integer> li=new ArrayList<>();
        
        ListNode temp=head;
        
        while(temp!=null){
            
            li.add(temp.val);
            temp=temp.next;
        }
        
        List<Integer> li2=new ArrayList<>();
        
        int rem=0;
        
        for(int i=li.size()-1;i>=0;i--){
            
            int val=li.get(i);
            val=val*2;
            
            val+=rem;
            
            String p=val+"";
            
            if(p.length()==2){
                li2.add(p.charAt(1)-48);
                rem=p.charAt(0)-48;
            }else{
            li2.add(p.charAt(0)-48);
                rem=0;
            }
        }
        
        if(rem>0)
            li2.add(rem);
        
        System.out.println(li2);
        
        Collections.reverse(li2);
        
       
        ListNode prevt=new ListNode();
       
        
        ListNode tm=prevt;
        
        for(int i=0;i<li2.size();i++){
            
            int valt=li2.get(i);
             ListNode nw=new ListNode();
            nw.val=valt;
            prevt.next=nw;
            prevt=nw;
        }
        
        return tm.next;

}}







  3) Minimum Absolute Difference Between Elements With Constraint


    You are given a 0-indexed integer array nums and an integer x.

Find the minimum absolute difference between two elements in the array that are at least x indices apart.

In other words, find two indices i and j such that abs(i - j) >= x and abs(nums[i] - nums[j]) is minimized.

Return an integer denoting the minimum absolute difference between two elements that are at least x indices apart.

 

Example 1:

Input: nums = [4,3,2,4], x = 2
Output: 0
Explanation: We can select nums[0] = 4 and nums[3] = 4. 
They are at least 2 indices apart, and their absolute difference is the minimum, 0. 
It can be shown that 0 is the optimal answer.
Example 2:

Input: nums = [5,3,2,10,15], x = 1
Output: 1
Explanation: We can select nums[1] = 3 and nums[2] = 2.
They are at least 1 index apart, and their absolute difference is the minimum, 1.
It can be shown that 1 is the optimal answer.
Example 3:

Input: nums = [1,2,3,4], x = 3
Output: 3
Explanation: We can select nums[0] = 1 and nums[3] = 4.
They are at least 3 indices apart, and their absolute difference is the minimum, 3.
It can be shown that 3 is the optimal answer.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
0 <= x < nums.length


  
    class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        
         Integer[] arr = new Integer[nums.size()];
 int n=arr.length;
        // ArrayList to Array Conversion
        for (int i = 0; i < nums.size(); i++)
            arr[i] = nums.get(i);
        
        Arrays.sort(arr);
        
        
        int diff = Integer.MAX_VALUE;
 
        // Find the min diff by comparing difference
        // of all possible pairs in given array
        for (int i = 0; i < n - 1; i++){
             if (arr[i+1] - arr[i] < diff  && nums.indexOf(arr[i+1])- nums.indexOf(arr[i]) >= x)
                    diff = Math.abs((arr[i+1] - arr[i]));
 
        }
        // Return min diff
        return diff;
        
    }
}
