
public class Heap {

	public static void main(String[] args) 
	{
		int[] heapArray = new int[14];
		//heap array starts with 1
		heapArray[1]=11;					//      11
		heapArray[2]=17;				//   17             13
		heapArray[3]=13;			//  18       21      19    17
		heapArray[4]=18;			//43  23   26  29   31
		heapArray[5]=21;		          
		heapArray[6]=19;
		heapArray[7]=17;
		heapArray[8]=43;
		heapArray[9]=23;
		heapArray[10]=26;
		heapArray[11]=29;
		heapArray[12]=31;
				
		Heap heap = new Heap();
		heap.insert(heapArray, 12);
		System.out.print("Insert 12 in heap : ");
		for(int i=1; i < heapArray.length; i++)
		{
			System.out.print(heapArray[i] + " ");
		}
		// -----------------------------------------------------------------
		
		int[] notAheapArray = new int[] {0,17,10,11,16,21,13,12,43,23,26,29,31,19};
		  //            17
		  //     10             11
		  //  16     21       13    12
		  //43  23 26  29   31  19
		int positionToHeapify = 1;
		heap.heapify(positionToHeapify, notAheapArray);
		System.out.println("");
		System.out.print("Heapify at position 1 : ");
		for(int i=1; i < notAheapArray.length; i++)
		{
			System.out.print(notAheapArray[i] + " ");
		}
		// -----------------------------------------------------------------

		int[] heapArrayForDeleteMin = new int[15];
		heapArrayForDeleteMin[1]=8;				//		   8
		heapArrayForDeleteMin[2]=10;		//	 10			       11  
		heapArrayForDeleteMin[3]=11;  //     16      21        13      12
		heapArrayForDeleteMin[4]=16;//     43  23  26  29    31  19  17
		heapArrayForDeleteMin[5]=21;
		heapArrayForDeleteMin[6]=13;
		heapArrayForDeleteMin[7]=12;
		heapArrayForDeleteMin[8]=43;
		heapArrayForDeleteMin[9]=23;
		heapArrayForDeleteMin[10]=26;
		heapArrayForDeleteMin[11]=29;
		heapArrayForDeleteMin[12]=31;
		heapArrayForDeleteMin[13]=19;
		heapArrayForDeleteMin[14]=17;
		
		heap.deleteMin(heapArrayForDeleteMin);
		System.out.println("");
		System.out.print("Delete min in heap : ");
		for(int i=1; i < heapArrayForDeleteMin.length-1; i++)
		{
			System.out.print(heapArrayForDeleteMin[i] + " ");
		}
	}
	public void deleteMin(int[] heapArrayForDeleteMin)
	{
		heapArrayForDeleteMin[1] = heapArrayForDeleteMin[heapArrayForDeleteMin.length - 1];
		heapArrayForDeleteMin[heapArrayForDeleteMin.length - 1] = 0;
		
		heapify(1, heapArrayForDeleteMin);
	}
	public void heapify(int i, int[] notAheapArray)
	{
		while(2*i <= notAheapArray.length)
		{
			if(2*i + 1 > notAheapArray.length)
			{
				// only left child and no right child
				if(notAheapArray[2*i] < notAheapArray[i])
				{
					swap(notAheapArray, 2*i, i);
				}
			}
			else // has both left and right child
			{
				if(notAheapArray[2*i] < notAheapArray[2*i+1])
				{
					if(notAheapArray[2*i] < notAheapArray[i])
					{
						swap(notAheapArray, 2*i, i);
					}
				}
				else if(notAheapArray[2*i+1] < notAheapArray[2*i] )
				{
					if(notAheapArray[2*i + 1] < notAheapArray[i])
					{
						swap(notAheapArray, 2*i + 1, i);
					}
				}
			}
						
			i = 2*i;
		}
	}
	
	public void insert(int[] heapArray, int n) //Time complexity O(logn)
	{
		// put newly arrived node at the end of the array
		int position = 13;
		heapArray[position] = n;
		
		//Procedure to satisfy the heap property
		while(position != 1) // this can go upto log(n)
		{
			if(heapArray[position] < heapArray[position/2])
			{
				swap(heapArray, position, position/2);
			}
			position = position/2;
		}		
	}
	
	public void swap(int[] array, int position1, int position2)
	{
		int temp;
		temp = array[position1];
		array[position1] = array[position2];
		array[position2] = temp;
	}
}
