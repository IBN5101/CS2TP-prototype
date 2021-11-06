package ibn.cs2tp.game.prototype.testing;

import java.util.ArrayList;

import ibn.cs2tp.game.prototype.sim.*;
import ibn.cs2tp.game.prototype.sim.mob.BasicMelee;
import ibn.cs2tp.game.prototype.util.PatternGen;

public class Test_03 {

	public static void main(String[] args) {
		Simulator s = new Simulator();
		Field field = s.getField();
		Grid grid = field.getGrid();

		// Sub-test 1
//		field.add(new BasicMelee(1), 0, 4);
//		Char a = field.getContents().get(0);
//		s.show();
//		
//		System.out.println();
//		a.doMove(new GridCell(field.getGrid(), 4, 4));
//		s.show();

		// Sub-test 2
		Char char1 = new BasicMelee(grid.get(5, 5), field, 1);
		field.add(char1);
//		ArrayList<GridCell> squareTest = PatternGen.square(char1.getCell(), 8);
//		s.show(squareTest);
		
//		ArrayList<GridCell> diamondTest = PatternGen.diamond(char1.getCell(), 9);
//		s.show(diamondTest);
		
		ArrayList<GridCell> compound = new ArrayList<>();
		compound.addAll(PatternGen.diamond(char1.getCell(), 9));
		compound.removeAll(PatternGen.diamond(char1.getCell(), 2));
		s.show(compound);
	}

}
