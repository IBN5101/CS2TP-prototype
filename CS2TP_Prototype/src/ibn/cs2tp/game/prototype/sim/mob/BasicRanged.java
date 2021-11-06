package ibn.cs2tp.game.prototype.sim.mob;

import java.util.Set;

import ibn.cs2tp.game.prototype.sim.*;

public class BasicRanged extends Char{
	
	public BasicRanged(GridCell grid, Field field, int player) {
		super(grid, field, player);
		name = "BR";
		type = 2;

		HP = maxHP = 15;
		minATK = 2;
		maxATK = 4;
		minDEF = 0;
		maxDEF = 1;
	}

	public BasicRanged(int player) {
		super(player);
		name = "BR";
		type = 2;

		HP = maxHP = 15;
		minATK = 2;
		maxATK = 4;
		minDEF = 0;
		maxDEF = 1;
	}
	
	@Override
	public Set<GridCell> moveOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<GridCell> attackOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
