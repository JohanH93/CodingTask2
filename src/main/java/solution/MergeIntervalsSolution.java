package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervalsSolution {
	public int[][] merge(int[][] intervallArray) {
		// Sort intervals by their lower limit
		Arrays.sort(intervallArray, Comparator.comparingInt(interval -> interval[0]));
		// New ArrayList for the merged intervals
		LinkedList<int[]> mergedIntervals = new LinkedList<>();
		//iterate over intervals in original array
		for (int[] currentInterval : intervallArray) {
			//if no array is in the merged list or the current array does not overlap with the previous one it is added to the merged list
			if (mergedIntervals.size() == 0
					|| (currentInterval[0] > mergedIntervals.getLast()[1])) {
				mergedIntervals.add(currentInterval);
			} 
			//Case if the two intervals overlap
			else {
				//The upper limits of the two compared intervals
				int currentIntervalUpperLimit = currentInterval[1];
				int mergedIntervalUpperLimit = mergedIntervals.getLast()[1];
				//If the intervals overlap and the upper limit of the current interval is higher, the interval in the merged list is extended
				if (currentIntervalUpperLimit >= mergedIntervalUpperLimit) {
					mergedIntervals.getLast()[1] = currentIntervalUpperLimit;
				}

			}
		}
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

	}

	public static void main(String[] args) {
		int[] array1 = { 25, 30 };
		int[] array2 = { 2, 19 };
		int[] array3 = { 14, 23 };
		int[] array4 = { 4, 8 };
		int[][] intervalls = { array1, array2, array3, array4 };
		MergeIntervalsSolution mergeIntervalls = new MergeIntervalsSolution();
		// Test run printing result to console
		System.out.println("Before merge:");
		System.out.println(Arrays.deepToString(intervalls));
		System.out.println("After merge:");
		System.out.println(Arrays.deepToString(mergeIntervalls.merge(intervalls)));

	}

}
