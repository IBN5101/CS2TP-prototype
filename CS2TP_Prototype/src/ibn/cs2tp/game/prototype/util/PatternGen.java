package ibn.cs2tp.game.prototype.util;

import java.util.ArrayList;

import ibn.cs2tp.game.prototype.sim.Grid;
import ibn.cs2tp.game.prototype.sim.GridCell;

public class PatternGen {

	// Generate a square with radius < range >
	public static ArrayList<GridCell> square(GridCell cell, int range) {
		ArrayList<GridCell> results = new ArrayList<>();

		int xCoord = cell.getX();
		int yCoord = cell.getY();
		Grid grid = cell.getGrid();

		for (int i = (xCoord - range); i <= (xCoord + range); i++) {
			for (int j = (yCoord - range); j <= (yCoord + range); j++) {
				if (i == xCoord && j == yCoord)
					continue;
				if (i < 0 || j < 0 || i >= grid.getWidth() || j >= grid.getHeight())
					continue;
				results.add(grid.get(i, j));
			}
		}

		return results;
	}
	
	// Generate a diamond with radius < range >
	public static ArrayList<GridCell> diamond(GridCell cell, int range) {
		ArrayList<GridCell> results = new ArrayList<>();

		int xCoord = cell.getX();
		int yCoord = cell.getY();
		Grid grid = cell.getGrid();

		for (int i = (xCoord - range); i <= (xCoord + range); i++) {
			int k = Math.abs(Math.abs(i - xCoord) - range);
			for (int j = (yCoord - k); j <= (yCoord + k); j++) {
				if (i == xCoord && j == yCoord)
					continue;
				if (i < 0 || j < 0 || i >= grid.getWidth() || j >= grid.getHeight())
					continue;
				results.add(grid.get(i, j));
			}
		}

		return results;
	}


}
