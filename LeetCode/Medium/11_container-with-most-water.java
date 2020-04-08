
public class Solution {

	public static void main(String[] args) 
	{
		int i,j;
		int arr[] = {1,8,6,2,5,4,8,3,7};
		int mostWater=0;
		for(i=0 ; i<=9; i++)
		{
			for(j=i+1; j<=8; j++)
			{
				int submin = Math.min(arr[i], arr[j]);
				mostWater = Math.max(mostWater, 
						submin * (j-i));
			}
		}
		System.out.println("Most water " + mostWater);

	}

}
