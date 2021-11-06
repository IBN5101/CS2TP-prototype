package ibn.cs2tp.game.prototype.sim;

import java.util.ArrayList;

public class Simulator {

	private static Field field = new Field(20, 20);
	private static Grid grid = field.getGrid();

	public Field getField() {
		return field;
	}

	public Grid getGrid() {
		return grid;
	}

	public void show() {
		for (int yCoord = 0; yCoord < grid.getWidth(); yCoord++) {
			for (int xCoord = 0; xCoord < grid.getHeight(); xCoord++) {
				GridCell cell = grid.get(xCoord, yCoord);
				if (cell.isEmpty()) {
					System.out.print("..");
				} else {
					System.out.print("XX");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public void show(ArrayList<GridCell> selected) {
		for (int yCoord = 0; yCoord < grid.getWidth(); yCoord++) {
			for (int xCoord = 0; xCoord < grid.getHeight(); xCoord++) {
				GridCell cell = grid.get(xCoord, yCoord);
				if (selected.contains(cell)) {
					System.out.print("<>");
				}
				else if (cell.isEmpty()) {
					System.out.print("..");
				} else {
					System.out.print("XX");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
