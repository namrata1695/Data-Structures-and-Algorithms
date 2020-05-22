import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/*
 Time complexity : O(no. of edges) i.e O(m)
 adjacency list representation of graph
 */
public class DFS 
{
	public static void main(String[] args) 
	{
		HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<Integer, LinkedList<Integer>>();
		
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
		linkedList1.add(2);
		linkedList1.add(3);
		linkedList1.add(4);
		linkedList1.add(6);
		hashMap.put(1, linkedList1);
		
		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.add(1);
		linkedList2.add(5);
		hashMap.put(2, linkedList2);
		
		LinkedList<Integer> linkedList3 = new LinkedList<Integer>();
		linkedList3.add(1);
		linkedList3.add(4);
		linkedList3.add(5);
		linkedList3.add(6);
		hashMap.put(3, linkedList3);
		
		LinkedList<Integer> linkedList4 = new LinkedList<Integer>();
		linkedList4.add(1);
		linkedList4.add(3);
		linkedList4.add(5);
		hashMap.put(4, linkedList4);
		
		LinkedList<Integer> linkedList5 = new LinkedList<Integer>();
		linkedList5.add(2);
		linkedList5.add(3);
		linkedList5.add(4);
		hashMap.put(5, linkedList5);
		
		LinkedList<Integer> linkedList6 = new LinkedList<Integer>();
		linkedList6.add(1);
		linkedList6.add(3);
		hashMap.put(6, linkedList6);
		
		DFS dfs = new DFS();
		int startVertex = 1;
		boolean[] visited = new boolean[7];
		dfs.depthFirstSearch(hashMap, startVertex, visited);
	}
	
	public void depthFirstSearch(HashMap<Integer, LinkedList<Integer>> hashMap, int vertex, boolean[] visited) 
	{
		visited[vertex] = true;
		System.out.print(vertex + " ");
		Iterator p = hashMap.get(vertex).iterator();
		while(p.hasNext())
		{
			int adjacentVertex = (int)p.next();
			if(visited[adjacentVertex] != true)
			{
				depthFirstSearch(hashMap, adjacentVertex, visited);
			}	
		}
	}
}
