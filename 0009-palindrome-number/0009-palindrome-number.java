class Solution {
    public boolean isPalindrome(int x) {
        int num=x, r,reverse=0,temp;
        temp = num;
        while(num>0){
            r = num%10;
            reverse = (reverse*10) + r;
            num = num/10;
        }
        if(temp == reverse)
{
       return true;
}else{
    return false;
}
        
    }
}