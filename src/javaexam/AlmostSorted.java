import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ALMOST SORTED
 *
 * An array of integers is almost sorted if at most one element can be deleted from it to make it perfectly sorted,
 * ascending. For example,arrays[2, 1, 7], [13], [9, 2] and [1, 5, 6] are almost sorted because they have 0 or 1
 * elements out of place. The arrays [4, 2, 1], [1, 2, 6, 4, 3] are not because they have more than one element out of
 * place. Given an array of n unique integers, determine the minimum number of elements to remove so it becomes almost
 * sorted.
 *
 * EXAMPLE
 *
 * arr = [3, 4, 2, 5, 1]
 *
 * Remove, for example, 2 to get arr = [3, 4, 5, 1] or 1 to get arr = [3, 4, 2, 5], both of which are almost sorted.
 * The minimum number of elements that have to be removed in this case is 1
 *
 * FUNCTION DESCRIPTION
 *
 * minDeletions has the following parameter(s):
 *   int arr[n]: an unsorted array of integers
 * Returns:
 *   int: the minimum numbers of items that must be deleted to create an almost sorted array
 *
 * CONSTRAINTS
 *
 * 1 <= n <= 10^5
 * 1 <= arr[i] <= 10^9
 * All elements of arr are distinct
 *
 */
public class AlmostSorted {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 4, 2, 5, 1);
        System.out.println(arr);
        System.out.println(minDeletions(arr));
    }

    public static int minDeletions(List<Integer> arr) {
        int max = -1;
        int move = 0;

        for (int i = 0; i < arr.size(); i++) {
           if (arr.get(i) > max) {
               max = arr.get(i);
           } else {
               move++;
           }
        }

        return move > 0 ? move - 1 : 0;
    }
}
