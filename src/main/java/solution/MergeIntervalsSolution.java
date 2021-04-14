package solution;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervalsSolution {
	public int[][] merge(int[][] intervallArray) {
		Arrays.sort(intervallArray, Comparator.comparingInt(el -> el[0]));
		// Count the number of elements deleted from the interval array for the new
		// array definition
		int deleteCounter = 0;
		// Iterate over the list with the iItervalls
		for (int i = 0; i < intervallArray.length; i++) {
			// If the checked interval was marked as deleted it is skipped
			if (intervallArray[i] == null) {
				continue;
			}
			// Iterate over all subsequent intervals to check if they overlap
			for (int j = i + 1; j < intervallArray.length; j++) {
				// If the checked Interval was marked as deleted it is skipped
				if (intervallArray[j] == null) {
					continue;
				}
				// Definition of the upper and lower limits of the current interval and the one
				// for comparison
				int currentIntervallLower = intervallArray[i][0];
				int currentIntervallUpper = intervallArray[i][1];
				int comparIntervallLower = intervallArray[j][0];
				int comparIntervallUpper = intervallArray[j][1];
				// If the current interval is completely within the compared one it is marked to
				// be skipped
				if (currentIntervallLower > comparIntervallLower && currentIntervallUpper < comparIntervallUpper) {
					intervallArray[i] = null;
					deleteCounter++;
				}
				// If the compared interval is completely within the current one it is marked to
				// be skipped
				else if (comparIntervallLower >= currentIntervallLower
						&& comparIntervallUpper <= currentIntervallUpper) {
					intervallArray[j] = null;
					deleteCounter++;
				}
				// Extends current interval to the lower if intervals overlap
				else if (comparIntervallLower < currentIntervallLower && comparIntervallUpper >= currentIntervallLower
						&& comparIntervallUpper <= currentIntervallUpper) {
					intervallArray[i][0] = comparIntervallLower;
					intervallArray[j] = null;
					deleteCounter++;

				}
				// Extends current interval to the upper if intervals overlap
				else if (comparIntervallUpper > currentIntervallUpper && comparIntervallLower >= currentIntervallLower
						&& comparIntervallLower <= currentIntervallUpper) {
					intervallArray[i][1] = comparIntervallUpper;
					intervallArray[j] = null;
					deleteCounter++;

				}

			}

		}
		return this.cleanArray(intervallArray, intervallArray.length - deleteCounter);

	}

	public int[][] cleanArray(int[][] initialArray, int size) {
		int[][] cleanedArray = new int[size][2];
		int position = 0;
		for (int k = 0; k < initialArray.length; k++) {
			if (initialArray[k] != null) {
				cleanedArray[position] = initialArray[k];
				position ++;
			}

		}
		return cleanedArray;

	}

	public static void main(String[] args) {
		int[] array1 = { 25, 30 };
		int[] array2 = { 2, 19 };
		int[] array3 = { 14, 23 };
		int[] array4 = { 4, 8 };
		int[][] intervalls = { array1, array2, array3, array4 };
		MergeIntervalsSolution mergeIntervalls = new MergeIntervalsSolution();
		// Test run printing result to console
		System.out.println(Arrays.deepToString(mergeIntervalls.merge(intervalls)));

	}

}
