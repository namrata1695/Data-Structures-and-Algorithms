import java.util.*;
class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        
        for(int i=0; i< nums.length ; i++)
        {
            hashtable.put(nums[i], i);
        }
        int[] arr = new int[2];
        
        for(int i=0; i<nums.length ; i++)
        {
            if(hashtable.get(target-nums[i]) > 0)
            {
            	int index = hashtable.get(target-nums[i]);
            	if(index != i)
            	{
            			arr[0]=i;
            			arr[1]=index;
            	}
            }
        }
        return arr;
    }
}