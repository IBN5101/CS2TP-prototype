package ibn.cs2tp.game.prototype.sim;

public class Grid {
	
	// The grid will be a 2D array of GridCell
	// [?] Temporary solution
	private final GridCell[][] grid;
	private final int width;
	private final int height;
	
	// Generic constructor
	public Grid(int width, int height) {
		this.grid = new GridCell[width][height];
		this.width = width;
		this.height = height;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = new GridCell(this, i, j);
			}
		}
	}

	// Get the width of this Grid
	public int getWidth() {
		return width;
	}

	// Get the height of this Grid
	public int getHeight() {
		return height;
	}
	
	// Get the GridCell with the specified coordinates
	public GridCell get(int xCoord, int yCoord) {
		return grid[xCoord][yCoord];
	}
	
}
