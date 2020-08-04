class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int ans = 0;
		
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    int i=0,j=0;
	    for(j=0, i=0; j < s.length(); j++)
	    {
	    	if(map.containsKey(s.charAt(j)))
	    	{
	    		i = Math.max(map.get(s.charAt(j)), i);
	    	}
	    	map.put(s.charAt(j), j+1);
	    	ans = Math.max(ans, j-i+1);
	    }
	    
	    return ans;
    }
}