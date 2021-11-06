package ibn.cs2tp.game.prototype.sim;

import java.util.*;

public class Field {

	private Grid grid;
	
	private List<Char> contents = new LinkedList<>();
	
	public Field (int width, int height) {
		this.grid = new Grid(width, height);
	}

	// Get the current Grid
	public Grid getGrid() {
		return grid;
	}

	// Get all existing Chars
	public List<Char> getContents() {
		return contents;
	}
	
	// Add a Char into the Field
	// [?] Temporary solution
	public boolean add(Char a, int xCoord, int yCoord) {
		GridCell cell = grid.get(xCoord, yCoord);
		
		// If cell is NOT empty, return false
		if (!cell.isEmpty())
			return false;
		// If cell is empty, add unit to field & cell
		contents.add(a);
		cell.setUnit(a);
		a.setCell(cell);
		a.setField(this);
		return true;
	}
	
	public boolean add(Char a) {
		// If Char does not have a cell, return false
		if (a.getCell() == null) 
			return false;
		// If cell is NOT empty, return false
		if (!a.getCell().isEmpty())
			return false;
		// If cell is empty, add unit to field
		contents.add(a);
		a.getCell().setUnit(a);
		return true;
		
	}
	
	// Remove a Char from the Field
	public boolean remove(Char a) {
		GridCell cell = a.getCell();
		// If GridCell is already empty, return false
		if (cell.isEmpty()) 
			return false;
		// If the unit is at the GridCell, remove the Char
		contents.remove(a);
		cell.removeUnit();
		a.setCell(null);
		a.setField(null);
		return true;
	}
	
	// Get count of a Char (?)
	// [.] Imported from previous project
	public int getCount(Class<?> klass) {
		int count = 0;

		for (Char a : contents) {
			if (a.getClass().equals(klass)) {
				count++;
			}
		}

		return count;
	}
	
}
