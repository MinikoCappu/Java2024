package edu.phystech.hw1;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RemoveNumberTest {

    private static int[] removeElement(int[] input, int element) {

        int size = 0;
        for(int i = 0; i < input.length;i++) {
            if (input[i] != element) {
                size++;
            }
        }
        int ans[] = new int[size];
        int i = 0;
        int idx = 0;
        while (i != input.length){
            if (input[i] != element) {
                ans[idx] = input[i];
                idx++;
                i++;
            } else {
                i++;
            }
        }
        return ans;
    }

    @Test
    public void removeElement() {
        Assertions.assertArrayEquals(new int[]{1}, removeElement(new int[]{1, 2}, 2));
        Assertions.assertArrayEquals(new int[]{}, removeElement(new int[]{1}, 1));
    }

    @Test
    public void removeReturnsNewArray() {
        int[] input = {9, 1, 3, 11, 3, 45, 499};
        int[] copy = Arrays.copyOf(input, input.length);

        int[] removed = removeElement(input, 3);

        Assertions.assertArrayEquals(new int[]{9, 1, 11, 45, 499}, removed);
        Assertions.assertArrayEquals(copy, input);
    }
}
