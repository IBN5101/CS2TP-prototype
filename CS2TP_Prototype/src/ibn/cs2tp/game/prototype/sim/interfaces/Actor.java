package ibn.cs2tp.game.prototype.sim.interfaces;

import ibn.cs2tp.game.prototype.sim.Field;
import ibn.cs2tp.game.prototype.sim.GridCell;

public interface Actor {
	
	void setCell(GridCell cell);
	GridCell getCell();
	
	Field getField();
	void setField(Field f);

}
