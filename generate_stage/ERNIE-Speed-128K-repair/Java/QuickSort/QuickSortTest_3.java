import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.thealgorithms.sorts.QuickSort;
import java.util.Arrays;

public class QuickSortTest {
    @Test
    public void sortTest() {
        // Test Case 1: Sort an array in ascending order
        Integer[] arr1 = {5, 3, 8, 2, 9};
        QuickSort quickSort = new QuickSort();
        Integer[] sortedArr1 = quickSort.sort(arr1);
        assertTrue(Arrays.equals(sortedArr1, Arrays.sort(arr1))); // Expected sorted array: [2, 3, 5, 8, 9]
        assertArrayOrdered(sortedArr1); // Assert that the array is sorted in ascending order

        // Test Case 2: Sort an array with duplicates in ascending order
        Integer[] arr2 = {5, 3, 8, 8, 2, 9};
        Integer[] sortedArr2 = quickSort.sort(arr2);
        assertTrue(Arrays.equals(sortedArr2, Arrays.sort(arr2))); // Expected sorted array: [2, 3, 5, 8, 8, 9]
        assertArrayOrdered(sortedArr2); // Assert that the array is sorted in ascending order despite duplicates

        // Test Case 3: Sort an empty array (should return an empty array)
        Integer[] arr3 = {};
        Integer[] sortedArr3 = quickSort.sort(arr3);
        assertTrue(Arrays.equals(sortedArr3, arr3)); // Expected sorted array is still an empty array []
    }
}