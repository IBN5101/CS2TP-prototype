package ibn.cs2tp.game.prototype.util;

public class Random {

	// Create a java Random object with SEED = 1
	private static java.util.Random rng = new java.util.Random(1L);

	// Uniform distribution between min and max value
	// [?] Temporary solution
	public static int nextInt(int min, int max) {
		return min + rng.nextInt(Math.abs(max - min) + 1);
	}

	// Triangular distribution between min and max value
	// [.] Imported from SPD
	public static int normalIntRange(int min, int max) {
		return min + (int) ((Float() + Float()) * (Math.abs(max - min) + 1) / 2f);
	}

	// Return random Float from 0 to 1
	public static double Float() {
		return rng.nextFloat();
	}

	// Testing [1]
	// What happen if we double Triangular Distribution (?)
	// Answer: Pseudo-bell curve (?)
	public static int test1(int min, int max) {
		return min + (int) ((Float() + Float() + Float() + Float()) * (Math.abs(max - min) + 1) / 4f);
	}

	// Testing [2]
	// What happen if we quadruple Triangular Distribution (?)
	// Answer: Squished bell curve (?)
	public static int test2(int min, int max) {
		float float8 = 0;
		for (int i = 0; i < 8; i++) 
			float8 += Float();
		float8 /= 8;
		return min + (int) (float8 * (Math.abs(max - min) + 1));
	}
	
}
