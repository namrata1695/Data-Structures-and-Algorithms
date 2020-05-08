import java.util.LinkedList;
import java.util.Queue;

public class BFS 
{
	public static void main(String[] args)
	{
		char[][] graph  = 
			{
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','1'},
				{'0','1','1','0','0'},
			};
		BFS bfs = new BFS();
		int numberOfConnectedComponents = bfs.ConnectedComponents(graph);
		for(int row = 0; row < 5; row++)
		{
			for(int col = 0; col < 5; col++)
			{
				System.out.print(graph[row][col]);
			}
			System.out.println();
		}
		
		System.out.println("Number of Connected Components : " + numberOfConnectedComponents);
		
	}
	
	public int ConnectedComponents(char[][] graph)
	{
		Queue<Integer> queue = new LinkedList<>();
		int numberOfRow = graph.length;
		int numberOfColumn = graph[0].length;
		int[] visited = new int[numberOfRow*numberOfColumn];
		int numberOfConnectedComponents = 0;
		for(int row = 0; row < numberOfColumn; row++)
		{
			for(int col = 0; col < numberOfColumn; col++)
			{
				if(graph[row][col] == '1' && visited[row*numberOfColumn + col] != 1)
				{
					numberOfConnectedComponents++;
					queue.add(row * numberOfColumn + col);
					visited[row*numberOfColumn + col] = 1;
					while(!queue.isEmpty())
					{
						int id = queue.remove();
						int r = id / numberOfColumn;
						int c = id % numberOfColumn;
						if(col+1<5 && graph[r][c+1] == '1' && visited[r*numberOfColumn + c + 1]!=1)
						{
							queue.add(r*numberOfColumn + (c + 1));
							visited[r*numberOfColumn + c + 1] = 1;
							//graph[r][c] = '0'; 
						}
						if(c-1>=0 && graph[r][c-1] == '1' && visited[r*numberOfColumn + c - 1]!=1)
						{
							queue.add(r*numberOfColumn + (c - 1));
							visited[r*numberOfColumn + c - 1] = 1;
							//graph[r][c-1] = '0'; 
						}
						if(r+1<5 && graph[r+1][c] == '1' && visited[(r+1)*numberOfColumn + c]!=1)
						{
							queue.add((r+1)*numberOfColumn + c);
							visited[(r+1)*numberOfColumn + c] = 1;
							//graph[r+1][c] = '0';
						}
						if(r-1>=0 && graph[r-1][c] == '1' && visited[(r-1)*numberOfColumn + c] != 1)
						{
							queue.add((r-1)*numberOfColumn + c);
							visited[(r-1)*numberOfColumn + c] = 1;
							//graph[r-1][c] = '0';
						}
					}
				}		
			}
		}
		System.out.println(" Visited : ");
		for(int i = 0; i < 24; i++)
		{
			System.out.print(visited[i] + " ");
		}
		System.out.println(); 
		
		return numberOfConnectedComponents;
	}
}
