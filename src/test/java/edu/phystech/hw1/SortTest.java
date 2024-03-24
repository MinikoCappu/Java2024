package edu.phystech.hw1;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SortTest {

    private static int[] sort(int[] nums) {
        int[] numsСopy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < numsСopy.length - 1; i++) {
            for (int j = i; j < numsСopy.length; j++) {
                if (numsСopy[i] > numsСopy[j]) {
                    int tmp = numsСopy[i];
                    numsСopy[i] = numsСopy[j];
                    numsСopy[j] = tmp;
                }
            }
        }
        return numsСopy;
    }

    @Test
    public void sortWorks() {
        Assertions.assertArrayEquals(new int[]{1}, sort(new int[]{1}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sort(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void sortReturnsNewArray() {
        int[] input = {9, 1, 3, 11, 45, 499};
        int[] copy = Arrays.copyOf(input, input.length);

        int[] sorted = sort(input);

        Assertions.assertArrayEquals(new int[]{1, 3, 9, 11, 45, 499}, sorted);
        Assertions.assertArrayEquals(copy, input);
    }
}
