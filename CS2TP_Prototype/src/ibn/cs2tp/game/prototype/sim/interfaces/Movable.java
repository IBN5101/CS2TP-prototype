package ibn.cs2tp.game.prototype.sim.interfaces;

import ibn.cs2tp.game.prototype.sim.Char;
import ibn.cs2tp.game.prototype.sim.GridCell;

public interface Movable extends Actor {
	// NOTE: FIX THIS LATER
	// Move the Char to the target GridCell
	default public boolean doMove(GridCell target) {
		// If target is already occupied, return false
		if (target.getUnit() != null)
			return false;

		// Update old GridCell
		this.getCell().setUnit(null);
		// Move new GridCell
		this.setCell(target);
		target.setUnit((Char) this);

		return true;
	}
}
