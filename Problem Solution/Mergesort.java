
public class Mergesort {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int[] intArray = new int[]{2,4,3,1};
		int min, max, mid,i;
		min=0;
		max=3;
		System.out.println("first min: "+ min + " max: " + max);
		part(intArray, min, max);
		for (i = 0; i < intArray.length; i++)
		System.out.println(" " + intArray[i]);
	}

	public static void part(int arr[], int min, int max)
	{
		int mid;
		if(min >= max)
			return;
		mid=(min+max)/2;
		
		part(arr,min,mid);
		System.out.println("1 min: "+ min + " mid: " + mid + " max: " + max);
		part(arr,mid + 1,max);
		System.out.println("2 min: "+ min + " mid: " + mid + " max: " + max);
		mergesort(arr, min, mid, max);
		System.out.println(" min: "+ min + " mid: " + mid + " max: " + max);
	}
	public static void mergesort(int arr[], int min, int mid, int max)
	{
		int n1 = mid-min+1;
		int n2=max-mid;
		int i,j,k;
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(i=0; i<n1; i++)
		{
			L[i]=arr[min+i];
		}
		for(j=0; j<n2; j++)
		{
			R[j]=arr[mid+1+j];
		}
		
		i=0;
		j=0;
		k=min;
		while(i<n1 && j<n2)
		{
			if(L[i] <= R[j])
			{
				arr[k]=L[i];
				i++;
			}
			else
			{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			arr[k]=L[i];
			i++; k++;
		}
		while(j<n2)
		{
			arr[k]=R[j];
			j++; k++;
		}
	}
}
