/**
 * A clique in a graph is set of nodes such that there is an edge between any two distinct nodes in the set.
 * Finding the largest clique in a graph is a computationally difficult problem.
 *
 * Currently, no polynomial time algorithm is known for solving this.
 * However, you wonder what is the minimum size of the largest clique in any graph with  nodes and  edges.
 *
 * For example, consider a graph with  nodes and  edges.
 * The graph below shows  nodes with  edges and no cliques.
 * It is evident that the addition of any  edge must create two cliques with  members each.
 *
 * 3 2 -> 2
 * 4 6 -> 4
 * 5 7 -> 3
 */
public class Clique {

    public static void main(String[] args) {
//        System.out.println(solve(3, 2));
        System.out.println(solve(4, 6));
//        System.out.println(solve(5, 7));
    }

    static int solve(int numNodes, int numEdges) {
        int k, low = 1, high = numNodes + 1;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
//            System.out.println("mid: " + mid);
            k = solve1(numNodes, mid);
//            System.out.println("k: " + k);
            if (k < numEdges)
                low = mid;
            else
                high = mid;
        }
        return high;
    }

    static int solve1(int n, int k) {
        int g1 = n % k;
        int g2 = k - g1;
        int sz1 = n / k + 1;
        int sz2 = n / k;
        return g1 * sz1 * g2 * sz2 + g1 * (g1 - 1) * sz1 * sz1 / 2 + g2 * (g2 - 1) * sz2 * sz2 / 2;
    }
}
