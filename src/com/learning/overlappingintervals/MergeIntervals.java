package com.learning.overlappingintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Overlapping Intervals - Merge Intervals
 *
 * Sort intervals by start time, then merge any that overlap.
 *
 * Input:  [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 *
 * Explanation:
 *   [1,3] and [2,6] overlap (2 <= 3) → merge to [1,6]
 *   [8,10] does not overlap with [1,6] → keep separate
 *   [15,18] does not overlap with [8,10] → keep separate
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1]) {
                // Overlapping: extend the end if needed
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap: add as new interval
                merged.add(current);
            }
        }

        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);

        System.out.println("Input:  [[1,3],[2,6],[8,10],[15,18]]");
        System.out.print("Output: ");
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println(); // [[1,6],[8,10],[15,18]]
    }
}
