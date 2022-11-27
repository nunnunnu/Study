package algorithm;

import java.util.*;

public class Maze {
	private static int n=8;
	private static int[][] maze = {
			{0,0,0,0,0,0,0,1},
			{0,1,1,0,1,1,0,1},
			{0,0,0,1,0,0,0,1},
			{0,1,0,0,1,1,0,0},
			{0,1,1,1,0,0,1,1},
			{0,1,0,0,0,1,0,1},
			{0,0,0,1,0,0,0,1},
			{0,1,1,1,0,1,0,0}
	};
	private static final int PATHWAY_COLOR=0; //지나갈 수 있는 길
	private static final int WALL_COLOR=1; //벽. 못지나감
	private static final int BLOCKED_COLOR=2; //가봤는데 경로없음
	private static final int PATH_COLOR=3; //가보긴했는데 경로있는지없는지 확실x
	
	public static boolean findMazePath(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=n) 
			return false;
		else if(maze[x][y]!=PATHWAY_COLOR) 
			return false; //maze[x][y]가 visited(green, red) or wall(blue)인 경우 flase반환
		else if(x==n-1 && y==n-1) {
			maze[x][y] = PATH_COLOR;
			return true;
		}else {
			maze[x][y] = PATH_COLOR;
			if(findMazePath(x-1,y) || findMazePath(x,y-1) 
			|| findMazePath(x+1,y) || findMazePath(x,y+1))
		 //인근셀에 경로가있을경우(true일경우) true반환
				return true;
			
			maze[x][y] = BLOCKED_COLOR; //인근셀에 경로가 없다면 red처리
			return false;
		}
	}
	public static void printMaze() {
	for(int i=0;i<maze.length;i++) {
		for(int j=0;j<maze[i].length;j++) {
			System.out.print(maze[i][j]+ " ");
		}
		System.out.println("");
	}
	System.out.println("");
}
	
	public static void main(String[] args) {
		printMaze();
		findMazePath(0,0);
		printMaze();
	}
}