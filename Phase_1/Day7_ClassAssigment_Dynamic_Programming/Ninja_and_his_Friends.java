package Day7_ClassAssigment_Dynamic_Programming;

public class Ninja_and_his_Friends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [][]grid = {{2, 3, 1, 2},{3, 4, 2, 2},{5, 6, 3, 5}};
		int [][]grid = {{1, 2},{3, 4}};
		int n=grid.length;
		int m=grid[0].length;
		int AliceChoco=CollectChocolate(0,0,grid);
		int BobChoco=CollectChocolate(0,m-1,grid);
		
		System.out.println(AliceChoco+BobChoco);

	}

	private static int CollectChocolate(int cr, int cc, int[][] grid) {
		// TODO Auto-generated method stub
		if(cc<0 || cc>=grid[0].length) {
			return Integer.MIN_VALUE;
		}
		
		if(cr==grid.length-1) {
			return grid[cr][cc];
		}
		
		int down=grid[cr][cc]+CollectChocolate(cr+1,cc,grid);
		int leftDiagonal=grid[cr][cc]+CollectChocolate(cr+1,cc-1,grid);
		int RightDiagonal=grid[cr][cc]+CollectChocolate(cr+1,cc+1,grid);
		
		return Math.max(down, Math.max(leftDiagonal, RightDiagonal));
	}

}
