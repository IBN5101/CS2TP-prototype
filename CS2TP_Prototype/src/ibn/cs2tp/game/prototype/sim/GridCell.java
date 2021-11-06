package ibn.cs2tp.game.prototype.sim;

import java.util.*;

public class GridCell {

	// Unit of residing in this cell
	private Char unit;
	// Grid of this cell
	private final Grid grid;
	// Coordinates of this cell
	private final int xCoord, yCoord;

	// Generic constructor
	public GridCell(Grid grid, int xCoord, int yCoord) {
		super();
		this.grid = grid;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public GridCell(Grid grid, int xCoord, int yCoord, Char unit) {
		super();
		this.grid = grid;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.unit = unit;
	}

	// Get unit of this cell
	public Char getUnit() {
		return unit;
	}

	// Set unit of this cell
	public void setUnit(Char unit) {
		this.unit = unit;
	}

	// Remove unit of this cell
	public void removeUnit() {
		this.unit = null;
	}

	// Get the Grid of this cell
	public Grid getGrid() {
		return grid;
	}

	// Get X-coordinate
	public int getX() {
		return xCoord;
	}

	// Get Y-coordinate
	public int getY() {
		return yCoord;
	}

	public boolean isEmpty() {
		return this.getUnit() == null;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof GridCell) {
			GridCell another = (GridCell) obj;
			if (this.getX() == another.getX() && this.getY() == another.getY()) {
				result = true;
			}
		}

		return result;
	}

	// Get a List of GridCells that are in the square-1 area
	// [?] Temporary solution
	// [.] Imported from previous project
	public ArrayList<GridCell> getAdjacent() {
		ArrayList<GridCell> results = new ArrayList<>();

		for (int i = (xCoord - 1); i <= (xCoord + 1); i++) {
			for (int j = (yCoord - 1); j <= (yCoord + 1); j++) {
				if (i == xCoord && j == yCoord) {
					continue;
				}
				if (i < 0 || j < 0 || 
						i >= grid.getHeight() || j >= grid.getWidth()) {
					continue;
				}
				results.add(grid.get(i, j));
			}
		}

		return results;
	}

	// Get a List of GridCells that are in the square-1 area and free
	// [?] Temporary solution
	// [.] Imported from previous project
	public ArrayList<GridCell> getFreeAdjacent() {
		ArrayList<GridCell> results = new ArrayList<>();
		ArrayList<GridCell> adjacents = this.getAdjacent();

		for (GridCell cell : adjacents) {
			if (cell.getUnit() == null) {
				results.add(cell);
			}
		}

		return results;
	}

	// Get a random free GridCell in the square-1 area
	// [?] Temporary solution
	// [.] Imported from previous project
	public GridCell getRandomFreeAdjacent(Random rng) {
		ArrayList<GridCell> freeAdjacents = this.getFreeAdjacent();

		if (freeAdjacents.isEmpty()) {
			return null;
		}

		return freeAdjacents.get(rng.nextInt(freeAdjacents.size()));
	}

	// String conversion (for testing)
	public String toString() {
		return "(" + String.format("%02d", this.getX()) + "," + String.format("%02d", this.getY()) + ")";
	}

}
