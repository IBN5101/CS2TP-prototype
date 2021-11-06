package ibn.cs2tp.game.prototype.sim.mob;

import java.util.Set;

import ibn.cs2tp.game.prototype.sim.*;

public class BasicMelee extends Char {

	public BasicMelee(GridCell grid, Field field, int player) {
		super(grid, field, player);
		name = "BM";
		type = 1;

		HP = maxHP = 20;
		minATK = 3;
		maxATK = 5;
		minDEF = 1;
		maxDEF = 3;
	}
	
	public BasicMelee(int player) {
		super(player);
		name = "BM";
		type = 1;

		HP = maxHP = 20;
		minATK = 3;
		maxATK = 5;
		minDEF = 1;
		maxDEF = 3;
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
