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

	@Test
	public void assertEmptyArrayIsReturnedIfEmptyArrayIsProvided() {
		int[][] intervals = new int[0][2];
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(intervals, result);
	}

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

	@Test
	public void assertCorrectResultForFurtherIntervalls1() {
		int[] interval1 = { 1, 4 };
		int[] interval2 = { 2, 7 };
		int[] interval3 = { 8, 11 };
		int[] interval4 = { 13, 27 };
		int[][] intervals = { interval1, interval2, interval3, interval4 };
		int[] interval5 = { 1, 7 };
		int[] interval6 = { 8, 11 };
		int[] interval7 = { 13, 27 };
		int[][] mergedIntervals = { interval5, interval6, interval7 };
		int[][] result = mergeIntervalsSolution.merge(intervals);
		assertArrayEquals(mergedIntervals, result);

	}
	

}
