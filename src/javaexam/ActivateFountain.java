import java.util.Arrays;

/**
 * ACTIVATE FOUNTAIN
 *
 * Fountains are installed at every position along a one-dimensional garden of length n. Array locations[] represents
 * the coverage limit of these fountains. The ith fountain (where 1 <= i <= n) has a coverage limit of locations[i]
 * that can range from the position max((i-locations[i]), 1) to min((i+locations[i]), n).
 * In other words, the fountains do not reach outside the boundaries of the garden. In the beginning, all the fountains
 * are switched off. Determine the minimum number of fountains that need to be activated to cover the n length garden by water
 *
 * EXAMPLE
 *
 * n = 3; locations[] = {0, 2, 1}, then
 *
 * For position 1: location[1] = 0, max((1-0),1) to min((1+0),3) gives range = 1 to 1
 * For position 2: location[2] = 2, max((2-2),1) to min((2+2),3) gives range = 1 to 3
 * For position 3: location[3] = 1, max((3-1),1) to min((3+1),3) gives range = 2 to 3
 *
 * For the entire length of this garden to be covered, only the fountain at position 2 needs to be activated.
 */
public class ActivateFountain {

    public int activatedFountains(int[] locations, int size) {
        int[] selected = new int[size];
        for (int i = 1; i < locations.length; i++) {
            int left = Math.max((i-locations[i-1]), 1);
            int right = Math.min((i+locations[i-1]), size);
            // greedy algorithm
            selected[left-1] = Math.max(right, selected[left-1]);
        }
        System.out.println(Arrays.toString(selected));

        int activatedFountain = 1;
        int right = selected[0], next_right = 0;
        for (int i = 0; i < size; i++) {
            next_right = Math.max(next_right, selected[i]);
            if (i == right) {
                activatedFountain++;
                right = next_right;
            }
        }

        return activatedFountain;
    }

    public static void main(String[] args) {
        int[] locations = {0, 2, 1};
        int size = locations.length;
        ActivateFountain m = new ActivateFountain();
        System.out.println(m.activatedFountains(locations, size));
    }
}
