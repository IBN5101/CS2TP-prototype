package ibn.cs2tp.game.prototype.sim;

import java.util.*;

import ibn.cs2tp.game.prototype.sim.interfaces.Actor;
import ibn.cs2tp.game.prototype.util.Random;
import ibn.cs2tp.game.prototype.util.*;

public abstract class Char implements Actor {

	private GridCell cell;
	private Field field;

	@Override
	// Get the cell of this Char
	public GridCell getCell() {
		return cell;
	}

	@Override
	// Set the cell of this Char
	public void setCell(GridCell cell) {
		this.cell = cell;
	}

	@Override
	// Get the field of this Char
	public Field getField() {
		return field;
	}

	@Override
	// Set the field of this Char
	public void setField(Field field) {
		this.field = field;
	}

	// ID system
	// [?] Temporary solution
	// [.] Imported from SPD
	private int id = 0;
	private static int nextID = 1;

	public int id() {
		if (id > 0) {
			return id;
		} else {
			return (id = nextID++);
		}
	}

	// Alignment of this Char
	// Can be Neutral, or belonging to Player 1 or Player 2
	// [.] Imported from SPD
	public enum Alignment {
		NEUTRAL, P1, P2
	}

	private Alignment alignment = Alignment.NEUTRAL;

	public Alignment alignment() {
		return this.alignment;
	}

	// Generic constructor
	public Char(GridCell cell, Field field) {
		this.cell = cell;
		this.field = field;
		id();
	}

	public Char(GridCell cell, Field field, int player) {
		this.cell = cell;
		this.field = field;
		id();
		switch (player) {
		case 1:
			this.alignment = Alignment.P1;
			break;
		case 2:
			this.alignment = Alignment.P2;
			break;
		default:
			this.alignment = Alignment.NEUTRAL;
		}

	}
	
	public Char(int player) {
		id();
		switch (player) {
		case 1:
			this.alignment = Alignment.P1;
			break;
		case 2:
			this.alignment = Alignment.P2;
			break;
		default:
			this.alignment = Alignment.NEUTRAL;
		}
	}

	// Name and type of the Char
	// [?] Temporary solution: type may not be needed
	protected String name = "";
	protected int type = -1;

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	// Generic stats
	public int HP, maxHP;
	public int minATK, maxATK;
	public int minDEF, maxDEF;

	// Alive status
	public boolean isAlive() {
		return HP > 0;
	}

	// On-death
	// [!] Add in removal from other classes
	public void die() {
		HP = 0;

		this.setCell(null);
		this.setField(null);
	}

	// ------------------------------
	// Interactive methods
	// [?] Temporary solution
	// ------------------------------

	// Move the Char to the target GridCell
	public boolean doMove(GridCell targetCell) {
		GridCell target = this.getField().getGrid().get(targetCell.getX(), targetCell.getY());
		
		// If target is already occupied, return false
		if (target.getUnit() != null)
			return false;

		// Update old GridCell
		this.getCell().setUnit(null);
		// Move new GridCell
		this.setCell(target);
		target.setUnit(this);

		return true;
	}
	
	// Possible options for doMove()
	// Differ from Char to Char
	public abstract Set<GridCell> moveOptions();

	// Attack the enemy at the target GridCell
	public boolean doAttack(GridCell targetCell) {
		GridCell target = this.getField().getGrid().get(targetCell.getX(), targetCell.getY());
		
		// If target is empty, return false
		if (target.getUnit() == null)
			return false;
		// If target is the same alignment as this Char, return false;
		if (target.getUnit().alignment() == this.alignment())
			return false;

		if (attack(target.getUnit()))
			return true;
		return false;
	}
	
	// Possible options for doAttack()
	// Differ from Char to Char
	public abstract Set<GridCell> attackOptions();

	// Wait after moving and attacking. Extend for post-turn effects.
	public boolean doWait() {
		return true;
	}
	// ------------------------------

	// ------------------------------
	// Attack and defence logic
	// [?] Temporary solution
	// [.] Imported from SPD
	// ------------------------------
	// Roll for ATK
	public int ATKRoll() {
		return Random.normalIntRange(minATK, maxATK);
	}

	// Roll for DEF
	public int DEFRoll() {
		return Random.normalIntRange(minDEF, maxDEF);
	}

	// Attack enemy
	final private boolean attack(Char enemy) {
		return attack(enemy, 1f, 0f);
	}

	// Attack method with damage multiplier and damage bonus
	// [?] Temporary solution
	private boolean attack(Char enemy, float dmgMulti, float dmgBonus) {
		// If there's no enemy, return false
		if (enemy == null)
			return false;

		// Damage increase from this Char's ATK roll
		int damageAddition = this.ATKRoll();
		damageAddition = Math.round(damageAddition * dmgMulti);
		damageAddition = Math.round(damageAddition + dmgBonus);
		// Damage decrease from enemy's DEF roll
		int damageReduction = enemy.DEFRoll();

		// Gate damage to be min 0
		int dmg = Math.max(damageAddition - damageReduction, 0);

		// If enemy is dead, interrupt the attack
		if (!enemy.isAlive())
			return true;

		// Damage the enemy
		enemy.damage(dmg, this);

		return true;
	}

	// Damage method
	public void damage(int dmg, Object src) {
		// If this Char is not alive or the damage is not positive, return
		if (!isAlive() || dmg < 0)
			return;

		// Reduce HP by damage amount
		HP -= dmg;
		// Gate HP to be min 0
		if (this.HP < 0)
			HP = 0;
		// If not alive, then die.
		if (!this.isAlive())
			die();
	}
	// ------------------------------
	
	// String conversion (for testing)
	public String toString() {
		String result = "";
		
		if (this.isAlive()) {
			result += StringGen.separator(this.id());
			result += StringGen.separator(this.alignment());
			result += StringGen.separator(this.getName());
			result += StringGen.separator(HP + "/" +  maxHP);
			result += StringGen.separator(minATK + " - " + maxATK);
			result += StringGen.separator(minDEF + " - " + maxDEF);
			result += StringGen.separator(this.getCell().toString());
		}
		else {
			result = "ded";
		}
		
		return result;
	}
}
