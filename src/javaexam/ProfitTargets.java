import java.util.*;

/**
 * PROFIT TARGETS
 *
 * A financial analyst is responsible for a portfolio of profitable stocks represented in an array. Each item in the
 * array. Each item in the array represents the yearly profit of a corresponding stock. The analyst gathers all distinct
 * pairs of stocks that reached the target profit. Distinct pairs are pairs that differ in at least one element. Given
 * the array of profits, find the number of distinct pairs of stocks where the sum of each pair's profits is exactly
 * equal to the target profit.
 *
 * EXAMPLE
 *
 * stockProfit = [5, 7, 9, 13, 11, 6, 6, 3, 3]
 * target = 12 profit's target
 *
 * - There are 4 pairs of stocks that have the sum of their profits equals to the target 12. Note that because there
 * are two instances of 3 in stocksProfit there are two pairs matching (9, 3): stockProfits indices 2 and 7, and indices
 * 2 and 8, but only one can be included.
 * - There are 3 distinct pairs of stocks: (5, 7), (3, 9), and (6, 6) and the return value is 3.
 *
 */
public class ProfitTargets {

    /**
     * Solve 1
     *
     * @param stockProfit
     * @param target
     * @return
     */
    public static int stockPairs(List<Integer> stockProfit, long target) {
        Set<Long> set = new HashSet<>();
        Set<Long> seen = new HashSet<>();
        int count = 0;
        for (long n : stockProfit) {
            if (set.contains(target - n) && !seen.contains(n)) {
                count++;
                seen.add(n);
                seen.add(target - n);
            } else {
                set.add(n);
            }
        }
        return count;
    }

    public static int stockPairs2(List<Integer> stockProfit, long target) {
        int count = 0;
        Set<Integer> selected = new HashSet<>();
        for (int i = 0; i < stockProfit.size(); i++) {
            for (int j = stockProfit.size() - 1; j > i; j--) {
                if (stockProfit.get(i) + stockProfit.get(j) == target && !selected.contains(i) && !selected.contains(j)) {
                    count++;
                    selected.add(i);
                    selected.add(j);
                    break; // start search from the next element
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> stockProfit = Arrays.asList(5, 7, 9, 13, 11, 6, 6, 3, 3);
        long target = 12;
        System.out.println(stockPairs(stockProfit, target));
        System.out.println(stockPairs2(stockProfit, target));
    }
}
