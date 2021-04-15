package solutiontest;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import solution.MergeIntervalsSolution;

//Unit Testing of the merge function
public class MergeIntervallsTest {

	MergeIntervalsSolution mergeIntervalsSolution;

	@Before
	public void setUp() {
		mergeIntervalsSolution = new MergeIntervalsSolution();
	}

	// Check if an empty array is returned if an empty array is provided to the
	// function
	@Test
	public void assertEmptyArrayIsReturnedIfEmptyArrayIsProvided() {
		int[][] intervals = new int[0][2];
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(intervals, result);
	}

	// Check if the correct result is returned for the example given in the task
	// description
	@Test
	public void assertCorrectResultForGivenExample() {
		int[] interval1 = { 25, 30 };
		int[] interval2 = { 2, 19 };
		int[] interval3 = { 14, 23 };
		int[] interval4 = { 4, 8 };
		int[][] intervals = { interval1, interval2, interval3, interval4 };
		int[] interval5 = { 2, 23 };
		int[] interval6 = { 25, 30 };
		int[][] mergedIntervals = { interval5, interval6 };
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(mergedIntervals, result);

	}

	// Further test cases with different intervals

	@Test
	public void assertCorrectResultForFurtherIntervalls() {
		int[] interval1 = { 1, 4 };
		int[] interval2 = { 2, 7 };
		int[] interval3 = { 8, 11 };
		int[] interval4 = { 13, 27 };
		int[][] intervals = { interval1, interval2, interval3, interval4 };
		int[] interval5 = { 1, 7 };
		int[][] mergedIntervals = { interval5, interval3, interval4 };
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(mergedIntervals, result);

	}

	@Test
	public void assertCorrectResultForFurtherIntervallsZeroValue() {
		int[] interval1 = { 0, 4 };
		int[] interval2 = { 2, 7 };
		int[] interval3 = { 7, 11 };
		int[] interval4 = { 13, 27 };
		int[][] intervals = { interval1, interval2, interval3, interval4 };
		int[] interval5 = { 0, 11 };
		int[][] mergedIntervals = { interval5, interval4 };
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(mergedIntervals, result);

	}

	@Test
	public void assertCorrectResultForFurtherIntervallsNoOverlap() {
		int[] interval1 = { 0, 4 };
		int[] interval2 = { 5, 7 };
		int[] interval3 = { 9, 11 };
		int[] interval4 = { 13, 27 };
		int[][] intervals = { interval1, interval2, interval3, interval4 };
		int[][] mergedIntervals = { interval1, interval2, interval3, interval4 };
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(mergedIntervals, result);

	}

	@Test
	public void assertCorrectResultForFurtherIntervallsNegativeValues() {
		int[] interval1 = { 0, 4 };
		int[] interval2 = { -5, 3 };
		int[] interval3 = { 8, 12 };
		int[] interval4 = { -10, -8 };
		int[][] intervals = { interval1, interval2, interval3, interval4 };
		int[] interval5 = { -5, 4 };
		int[][] mergedIntervals = { interval4, interval5, interval3 };
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(mergedIntervals, result);

	}

	@Test
	public void assertCorrectResultForFurtherIntervallsNullValues() {
		int[] interval1 = { 1, 4 };
		int[] interval2 = { 2, 7 };
		int[] interval3 = { 8, 11 };
		int[] interval4 = { 13, 27 };
		int[][] intervals = { interval1, null, interval2, interval3, interval4, null };
		int[] interval5 = { 1, 7 };
		int[][] mergedIntervals = { interval5, interval3, interval4 };
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(mergedIntervals, result);

	}

}
