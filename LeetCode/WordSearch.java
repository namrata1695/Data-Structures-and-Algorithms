import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class WordSearch2 
{
	class Node
	{
		char letter;
		int row;
		int column;
	}
	public static void main(String[] args) 
	{
		
		char[][] board = {{'A', 'B', 'C', 'E'},
						  {'S', 'F', 'C', 'S'},
						  {'A', 'D', 'E', 'E'}};
	/*char[][] board = {{'A', 'B'},
				  		  {'C', 'D'}};*/
	/*	char[][] board = {{'A', 'B', 'C', 'E'},
				  		  {'S', 'F', 'E', 'S'},
				  		  {'A', 'D', 'E', 'E'}};*/
		
System.out.println("row : " + board.length);
System.out.println("col : " + board[0].length);
		//char[] word = {'A','B','C','C','E','D'};
		//char[] word = {'S','E','E'};
		//char[] word = {'A','B','C','B'};
		//char[] word = {'A','D','E'};
		//String word = "ABCESEEEFS";
		//String word = "SFE";
		//String word = "SFBA";
		String word = "ADE";
		WordSearch2 wordSearch = new WordSearch2(); 
		wordSearch.wordSearch(board, word);
	}
	
	public void wordSearch(char[][] board, String word)
	{
		if(board == null || board.length == 0 || word == null || word.length()==0)
		{
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		Node node = null;
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j < board[0].length; j++)
			{
				if(board[i][j] == word.charAt(0))
				{
					node = new Node();
					node.letter = board[i][j];
					node.row = i;
					node.column = j;
					queue.add(node);
				}
			}
		}
		boolean found = false;
		while(!queue.isEmpty())
		{
			Node n = queue.poll();
			boolean[][] visited = new boolean[board.length][board[0].length];
			found = depthFirstSearch(board, n, visited, word, 0);
			if(found)
			{
				break;
			}
		}
		System.out.println("Word found?" + found);
	}
	public boolean depthFirstSearch(char[][] board, Node node, boolean[][] visited, String word, int wordIndex) 
	{
		if(board.length==1 && word.length()==1 && board[node.row][node.column] == word.charAt(wordIndex))
        {
            return true;
        }
		if((board[node.row][node.column] == word.charAt(wordIndex)) && (wordIndex == word.length()-1))
		{
			return true;
		}
		if(board[node.row][node.column] != word.charAt(wordIndex))
		{
			return false;
		}
		boolean ret = false;
		visited[node.row][node.column] = true;
		int[] rowOffsets = {0, 1, 0, -1};
	    int[] colOffsets = {1, 0, -1, 0};
	    for (int d = 0; d < 4; d++) 
	    {
			if((node.row + rowOffsets[d] >= 0) && (node.row + rowOffsets[d] < board.length) && 
					(node.column + colOffsets[d] >= 0) && (node.column + colOffsets[d] < board[0].length)
					&& visited[node.row + rowOffsets[d]][node.column + colOffsets[d]] != true)
			{
				Node adjacentNode = new Node();
				adjacentNode.letter = board[node.row + rowOffsets[d]][node.column];
				adjacentNode.row = node.row + rowOffsets[d];
				adjacentNode.column = node.column + colOffsets[d];
				ret = depthFirstSearch(board, adjacentNode, visited, word, wordIndex+1);
				if(ret)
				{
					break;
				}
			}	
	    }		visited[node.row][node.column] = false;
		return ret;
	}
}
