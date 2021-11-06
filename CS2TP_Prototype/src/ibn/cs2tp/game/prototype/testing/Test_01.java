package ibn.cs2tp.game.prototype.testing;

import java.util.ArrayList;
import java.util.HashMap;
import ibn.cs2tp.game.prototype.util.Random;

public class Test_01 {

	public static void main(String[] args) {

		// HashMap for < RNG value -> Frequency >
		HashMap<Integer, Integer> results = new HashMap<>();
		// ArrayList for unknown elements
		ArrayList<Integer> error = new ArrayList<>();
		
		// Testing values
		int min = 1;
		int max = 100;
		int sample = (int) Math.pow(10, 6);
		
		// Initialise
		System.out.println("[ ] Initialising ...");
		for (int i = min; i <= max; i++) {
			results.put(i, 0);
		}
		
		// Loop through sample size
		System.out.println("[ ] Looping ...");
		for (int i = 0; i < sample; i++) {
			
			// TESTING RANDOM INT
			int roll = 0;
//			roll = Random.nextInt(min, max);
			roll = Random.normalIntRange(min, max);
//			roll = Random.test1(min, max);
//			roll = Random.test2(min, max);
			
			if (results.containsKey(roll)) {
				int newFrequency = results.get(roll) + 1;
				results.put(roll, newFrequency);
			}
			else {
				error.add(roll);
			}
		}
		
		// Print out results
		System.out.println("[ ] Result:");
		// Key values
		for (int key : results.keySet()) {
			int value = results.get(key);
			double percent = (value * 100.0) / sample;
			System.out.print("- Key value [ " + String.format("%03d", key) + " ]: ");
			System.out.print(String.format("%05d", value));
			System.out.print(" | ");
			System.out.print(String.format("%.2f", percent));
			System.out.println();
		}
		// Error values
		if (error.size() > 0) {
			System.out.println("[!] Error detected:");
			int value = error.size();
			double percent = (value * 100.0) / sample;
			System.out.print("ERROR: [ ! ]: ");
			System.out.print(String.format("%05d", value));
			System.out.print(" | ");
			System.out.print(String.format("%.2f", percent));
			System.out.println();
			System.out.println("[!] Error dump:");
			for (int num : error) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("[ ] No error detected.");
		}
		// Value dump for external graphing
		System.out.println("[ ] Value dump:");
		for (int value : results.values()) {
			System.out.print(value + " ");
		}
		System.out.println();
		
		// Termination
		System.out.println("[.] TERMINATING.");
	}

}
