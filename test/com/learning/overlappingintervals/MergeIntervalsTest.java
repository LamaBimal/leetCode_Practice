package com.learning.overlappingintervals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    private final MergeIntervals solution = new MergeIntervals();

    @Test
    void testBasicMerge() {
        int[][] result = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, result);
    }

    @Test
    void testOverlappingAtEdge() {
        // [1,4] and [4,5] share endpoint → merge to [1,5]
        int[][] result = solution.merge(new int[][]{{1, 4}, {4, 5}});
        assertArrayEquals(new int[][]{{1, 5}}, result);
    }

    @Test
    void testNoOverlap() {
        int[][] result = solution.merge(new int[][]{{1, 2}, {3, 4}, {5, 6}});
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}, {5, 6}}, result);
    }

    @Test
    void testAllMergeIntoOne() {
        int[][] result = solution.merge(new int[][]{{1, 10}, {2, 6}, {3, 8}});
        assertArrayEquals(new int[][]{{1, 10}}, result);
    }

    @Test
    void testSingleInterval() {
        int[][] result = solution.merge(new int[][]{{1, 5}});
        assertArrayEquals(new int[][]{{1, 5}}, result);
    }
}
