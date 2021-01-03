import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class TopKfrequentElement 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] nums = {6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
		int k = 6;
		
		TopKfrequentElement obj = new TopKfrequentElement();
		int[] output = obj.topKFrequent(nums, k);
		int i;
		System.out.print("Output");
		for(i=0; i<k ;i++)
		{
			System.out.print(output[i] + " ");
		}

	}
	
	public int[] topKFrequent(int[] nums, int k) 
	{
		Hashtable<Integer,Integer> eachEleFreq = new Hashtable<Integer,Integer>(); 
		int i;
		int initialfreq = 1;
		//step 1 : create frequency map of each element. Time complexity : O(n)
		for(i=0 ; i<nums.length; i++)
		{
			if(eachEleFreq.containsKey(nums[i]))
			{
				int value = eachEleFreq.get(nums[i]);
				eachEleFreq.put(nums[i], value + 1);
			}
			else
			{
				eachEleFreq.put(nums[i], initialfreq);
			}
		}
		//step 2: build a heap
		Set<Integer> keys = eachEleFreq.keySet();
		Iterator<Integer> itr = keys.iterator();
		Integer key;
		int randomheap[] = new int[eachEleFreq.size() + 1];
		int index=1;
		while (itr.hasNext()) //Time complexity : O(n)
		{ 
		    // Getting Key
			key = itr.next();

			randomheap[index] = key;
			System.out.println(key + " " + " -> " +  eachEleFreq.get(key));
			index = index + 1;
		} 
		System.out.println();
		int l;
		for(l = 1 ;l<randomheap.length; l++)
		{
			System.out.print(" " + randomheap[l]);
		}
		System.out.println();

		//Step:3 make heap Time complexity : O(n)
		int[] heap = makeHeap(randomheap, eachEleFreq);
		
		for(l = 1 ;l<randomheap.length; l++)
		{
			System.out.print(" " + randomheap[l]);
		}
		System.out.println();
		
		//step 4 select k frequent elements. Time complexity : k + k(log n)
		int j = 0;
		int[] output = new int[k];
		
		int leftPointer = 1;
		int heapLength = heap.length;
		for(j = 0; j < k; j++ )
		{	
			System.out.println();
			int n;
			System.out.println();
			for(n = 1 ;n<heapLength; n++)
			{
				System.out.print(" " + heap[n]);
			}
			output[j] = heap[1];
			heapLength = DeleteLastAndGetRightPointer(heap, eachEleFreq, heapLength);
		}
		return output;
    }
	
	public int DeleteLastAndGetRightPointer(int[] heap, Hashtable<Integer,Integer> eachEleFreq, int heapLength)
	{
		heap[1] = heap[heapLength - 1];
		heap[heapLength - 1] = 0; // delete last element from heap;
		int updatedheapLength = heapLength -1;
		heapify(1, heap, eachEleFreq, updatedheapLength);
		
		return updatedheapLength;
	}
	public int[] makeHeap(int[] heap, Hashtable<Integer,Integer> eachEleFreq)
	{
		int length = heap.length;
		for(int i=length-1; i>=1; i--)
		{
			heapify(i, heap, eachEleFreq, length);
		}
		return heap;
	}
	
	public int[] heapify(int i, int[] heap, Hashtable<Integer,Integer> eachEleFreq, int heapLength)
	{
		if(2*i <= (heapLength - 1)) // for non-leaves
		{
			int leftChild = 2*i;
			int rightChild = 2*i + 1;
			if(2*i + 1 > (heapLength -1))// only left child and no right child
			{
				if(eachEleFreq.get(heap[i]) < eachEleFreq.get(heap[leftChild]))
				{
					swap(heap, leftChild, i);
					heapify(leftChild, heap, eachEleFreq,  heapLength);
				}
			}
			else // has both left and right child
			{
				int chosenChild=0;
				if(eachEleFreq.get(heap[leftChild]) >= eachEleFreq.get(heap[rightChild]))
				{
					chosenChild = leftChild;
				}
				else if(eachEleFreq.get(heap[rightChild]) > eachEleFreq.get(heap[leftChild]))
				{
					chosenChild = rightChild;
				}
				if(eachEleFreq.get(heap[i]) < eachEleFreq.get(heap[chosenChild]))
				{
					swap(heap, chosenChild, i);
					heapify(chosenChild, heap, eachEleFreq,  heapLength);
				}
			}		
		}
		return heap;
	}
	
	public void swap(int[] heap, int i, int index)
	{
		int temp;
		temp = heap[i];
		heap[i] = heap[index];
		heap[index] = temp;
	}
}
