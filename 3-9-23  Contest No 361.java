1. Count Symmetric Integers

  You are given two positive integers low and high.

An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.

Return the number of symmetric integers in the range [low, high].

 

Example 1:

Input: low = 1, high = 100
Output: 9
Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
Example 2:

Input: low = 1200, high = 1230
Output: 4
Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
 

Constraints:

1 <= low <= high <= 104


  class Solution {
    
    public int getans(String s){
        
        int sum=0;
        for(int i=0;i<s.length();i++){
            
            sum+=s.charAt(i)-48;
        }
        return sum;
    }
    
    public int countSymmetricIntegers(int low, int high) {
        
        int ans=0;
        
        while(low<=high){
            
            String s=low+"";
            
            if(s.length()%2==0){
                int len=s.length();
                int half=len/2;
                String left=s.substring(0,half);
                String right=s.substring(half,len);
                
                int sum=getans(left);
                int sum2=getans(right);
                if(sum==sum2)
                    ans++;
            }
            low++;
        }
        
        return ans;
    }
}



2. Minimum Operations to Make a Special Number


  You are given a 0-indexed string num representing a non-negative integer.

In one operation, you can pick any digit of num and delete it. Note that if you delete all the digits of num, num becomes 0.

Return the minimum number of operations required to make num special.

An integer x is considered special if it is divisible by 25.

 

Example 1:

Input: num = "2245047"
Output: 2
Explanation: Delete digits num[5] and num[6]. The resulting number is "22450" which is special since it is divisible by 25.
It can be shown that 2 is the minimum number of operations required to get a special number.
Example 2:

Input: num = "2908305"
Output: 3
Explanation: Delete digits num[3], num[4], and num[6]. The resulting number is "2900" which is special since it is divisible by 25.
It can be shown that 3 is the minimum number of operations required to get a special number.
Example 3:

Input: num = "10"
Output: 1
Explanation: Delete digit num[0]. The resulting number is "0" which is special since it is divisible by 25.
It can be shown that 1 is the minimum number of operations required to get a special number.

 

Constraints:

1 <= num.length <= 100
num only consists of digits '0' through '9'.
num does not contain any leading zeros.









class Node{
    int left;
    int right;
    
    public String toString(){
        return left+" "+right;
    }
}


class Solution {
    
    public List<Node> get(String num, String find){
        int len=num.length();
        List<Node> li=new ArrayList<>();
        
        for(int i=0;i<len;i++){
            char left=num.charAt(i);
            for(int j=i+1;j<len;j++){
                if(find.charAt(0)==left && find.charAt(1)==num.charAt(j)){
                    Node n=new Node();
                    n.left=i;
                    n.right=j;
                    li.add(n);
                }
            }
        }
        return li;
    }
    
    public int getMin(List<Node> li, int sl){
        int len=li.size();
        
        int min=0;
        for(int i=0;i<len;i++){
            Node n=li.get(i);
            
            int l=n.left;
            int r=n.right;
            
            int dum=0;
            int df=sl-r;
            df--;
            int fm=r-l;
            fm--;
            
            dum=df+fm;
            
            if(min==0)
                min=dum;
            else{
                if(dum<min)
                    min=dum;
            }
        }
        return min;
    }
    public boolean zero(String sm){
        boolean ans=false;
        
        for(int i=0;i<sm.length();i++){
            if(sm.charAt(i)=='0')
                ans=true;
        }
        return ans;
    }
    public int minimumOperations(String num) {
        int len=num.length();
        
        String arr[]={"00","25","50","75"};
        
        int ans=-1;
        
        for(int i=0;i<4;i++){
            String s=arr[i];
            
            List<Node> li=get(num,s);
            
            if(li.size()>0){
                int min=getMin(li,len);
                System.out.println(min);
                if(ans==-1)
                    ans=min;
                else {
                    if(min<ans)
                        ans=min;
                }
            }
        }
        
        if(len==1){
            if(num.charAt(0)=='0')
                return 0;
            else 
                return 1;
        }
        
        if(ans!=-1) return ans;
        else{
            if(zero(num))
                return len-1;
        }
        return len;
    }
}
