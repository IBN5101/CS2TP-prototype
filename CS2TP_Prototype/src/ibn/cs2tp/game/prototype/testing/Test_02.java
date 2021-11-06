package ibn.cs2tp.game.prototype.testing;

import ibn.cs2tp.game.prototype.sim.*;
import ibn.cs2tp.game.prototype.sim.mob.*;

public class Test_02 {

	public static void main(String[] args) {

		Field f = new Field(20, 20);
		Grid g = f.getGrid();
		
		f.add(new BasicMelee(1), 13, 14);
		f.add(new BasicRanged(2), 5, 1);
		
		Char a = f.getContents().get(0);
		Char b = f.getContents().get(1);
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println();
		
		a.doAttack(g.get(5, 1));
		a.doAttack(g.get(5, 1));
		a.doAttack(g.get(5, 1));
		a.doAttack(g.get(5, 1));
		
		System.out.println(a);
		System.out.println(b);
	}

}