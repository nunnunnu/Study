package algorithm;

import java.util.*;

public class blob {
	private static int n=8;
	private static int[][] grid = {
			{1,0,0,0,0,0,0,1},
			{0,1,1,0,0,1,0,0},
			{1,1,0,0,1,0,1,0},
			{0,0,0,0,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{1,0,0,0,1,0,0,1},
			{0,1,1,0,0,1,1,1}
	};
	private static final int BACKGROUND_COLOR=0; //backgound pixel
	private static final int IMAGE_COLOR=1; //image pixel
	private static final int ALREADY_COLOR=2; //이미 셀렸음
	
	public static int countcells (int x, int y) {
		int result;
		if(x<0 || y<0 || x>=n || y>=n) return 0;
		else if(grid[x][y]!=IMAGE_COLOR) return 0;
		else {
			grid[x][y] = ALREADY_COLOR;
			return 1 + countcells(x-1,y+1) + countcells(x,y+1)+countcells(x+1,y+1)
			+countcells(x-1,y)+countcells(x+1,y)
			+countcells(x-1,y-1)+countcells(x,y-1)+countcells(x+1,y-1);
			}
		}
	private static void printgrid() {
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				System.out.print(grid[x][y]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		printgrid();
		System.out.println();
		System.out.println("blob : "+countcells(5,3));
		System.out.println();
		printgrid();
	}
}