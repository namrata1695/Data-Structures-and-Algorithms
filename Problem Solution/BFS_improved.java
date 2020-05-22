/*
Time complexity : O(M+N) -> linear time complexity
Adjacency list used for graph representation
*/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_improved 
{
	public static void main(String[] args)
	{
		HashMap<Integer, LinkedList<Integer>> hashmap = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<Integer> list0 = new LinkedList<Integer>();
		list0.add(1);
		list0.add(2);
		hashmap.put(0,list0);
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(0);
		list1.add(3);
		hashmap.put(1,list1);
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(0);
		hashmap.put(2,list2);
		
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		list3.add(1);
		list3.add(4);
		list3.add(5);
		hashmap.put(3,list3);
		
		LinkedList<Integer> list4 = new LinkedList<Integer>();
		list4.add(3);
		list4.add(5);
		list4.add(6);
		hashmap.put(4,list4);
		
		LinkedList<Integer> list5 = new LinkedList<Integer>();
		list5.add(3);
		list5.add(4);
		list5.add(7);
		hashmap.put(5,list5);
		
		LinkedList<Integer> list6 = new LinkedList<Integer>();
		list6.add(4);
		list6.add(7);
		hashmap.put(6,list6);
		
		LinkedList<Integer> list7 = new LinkedList<Integer>();
		list7.add(6);
		list7.add(5);
		hashmap.put(7,list7);
		
		LinkedList<Integer> list8 = new LinkedList<Integer>();
		list8.add(9);
		hashmap.put(8,list8);
		
		LinkedList<Integer> list9 = new LinkedList<Integer>();
		list9.add(8);
		hashmap.put(9,list9);
		
		LinkedList<Integer> list10 = new LinkedList<Integer>();
		list10.add(11);
		hashmap.put(10,list10);
		
		LinkedList<Integer> list11 = new LinkedList<Integer>();
		list11.add(10);
		hashmap.put(11,list11);
		
		LinkedList<Integer> list12 = new LinkedList<Integer>();
		list12.add(13);
		hashmap.put(12,list12);
		
		LinkedList<Integer> list13 = new LinkedList<Integer>();
		list13.add(12);
		hashmap.put(13,list13);
		
		BFS_improved bfs = new BFS_improved();
		int startVertex = 0;
		int count = 1;
		int[] labelComponentNumber = new int[hashmap.size()];
		boolean[] visited = new boolean[hashmap.size()];
		int numberOfConnectedComponents = bfs.ConnectedComponents(hashmap, startVertex, labelComponentNumber, visited);
		
		System.out.println("Number of Connected Components : " + numberOfConnectedComponents);
		
		for(int i=0; i< labelComponentNumber.length ; i++)
		{
			System.out.print( " " + labelComponentNumber[i]);
		}
	}
	int numberOfConnectedComponents = 0;
	public int ConnectedComponents(HashMap<Integer, LinkedList<Integer>> hashmap, int startVertex,
			int[] labelComponentNumber, boolean[] visited)
	{
		if(hashmap.size() == 0)
		{
			return numberOfConnectedComponents;
		}
		if(startVertex > labelComponentNumber.length - 1)
		{
			return numberOfConnectedComponents;
		}
		numberOfConnectedComponents = numberOfConnectedComponents + 1;
		Queue<Integer> queue = new LinkedList<>();
				
		
		queue.add(startVertex);
		visited[startVertex] = true;
		
		while(!queue.isEmpty())
		{
			int id = queue.remove();
			labelComponentNumber[id] = numberOfConnectedComponents;
			
			LinkedList<Integer> adjacentNodes = hashmap.get(id);
			for (int i = 0; i < adjacentNodes.size(); i++) 
			{
				int adjacentNode = adjacentNodes.get(i);
				if(visited[adjacentNode] == false)
				{
					queue.add(adjacentNode);
					labelComponentNumber[adjacentNode] = numberOfConnectedComponents;
					visited[adjacentNode] = true;
				}			    
			}				
		}
		
		while(startVertex <= labelComponentNumber.length - 1 && labelComponentNumber[startVertex] != 0)
		{
			startVertex++;
		}
		 
		ConnectedComponents(hashmap, startVertex, labelComponentNumber, visited);
					
		return numberOfConnectedComponents;
	}
}
/*
Output :
Number of Connected Components : 4
 1 1 1 1 1 1 1 1 2 2 3 3 4 4

*/