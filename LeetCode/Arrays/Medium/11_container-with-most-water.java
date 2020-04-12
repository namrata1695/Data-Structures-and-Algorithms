class Solution {
    public int maxArea(int[] height) 
    {
        int mostWater = 0;
        int left=0,right;
        right = height.length - 1;
        while(left < right)
        {
            int submin = Math.min(height[left],height[right]);
            mostWater = Math.max(mostWater, submin * (right-left));
            if(height[left] < height[right])
            {
                left++;
            }
            else 
            {
                right--;    
            }
        }
        return mostWater;
    }
}