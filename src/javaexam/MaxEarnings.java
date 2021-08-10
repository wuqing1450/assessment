import java.util.ArrayList;
import java.util.List;

public class MaxEarnings {

    public static void main(String[] args) {
        MaxEarnings m = new MaxEarnings();
        Integer[] pickup = {0, 2, 9, 10, 11, 12};
        Integer[] drop = {5, 9, 11, 11, 14, 17};
        Integer[] tip = {1, 2, 3, 2, 2, 1};
        System.out.println(m.taxiDriver(pickup, drop, tip));

        pickup = new Integer[]{1, 4};
        drop = new Integer[]{5, 6};
        tip = new Integer[]{2, 5};
        System.out.println(m.taxiDriver(pickup, drop, tip));

        pickup = new Integer[]{0, 4, 5};
        drop = new Integer[]{3, 5, 7};
        tip = new Integer[]{1, 2, 2};
        System.out.println(m.taxiDriver(pickup, drop, tip));

    }

    public int taxiDriver(Integer[] pickup, Integer[] drop, Integer[] tip) {
        List<Trip> v = new ArrayList<>();
        int total = 0;
        List<Integer> maxEarns = new ArrayList<>();
        for (int i = 0; i < pickup.length; i++) {
            int from = pickup[i];
            int to = drop[i];
            int earn = drop[i] - pickup[i] + tip[i];
            v.add(new Trip(from, to, earn));
        }

        for (int i = 0; i < pickup.length; i++) {
            maxEarns.add(0);
            for (int j = 0; j < i; j++) {
                if (v.get(j).getTo() <= v.get(i).getFrom() && maxEarns.get(i) < maxEarns.get(j)) {
                    maxEarns.set(i, maxEarns.get(j));
                }
            }
            maxEarns.set(i, maxEarns.get(i) + v.get(i).getEarn());
        }

        for (int i : maxEarns) {
            if (i > total) {
                total = i;
            }
        }

        return total;
    }

    class Trip {
        private int from;
        private int to;
        private int earn;

        public Trip(int from, int to, int earn) {
            this.from = from;
            this.to = to;
            this.earn = earn;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getEarn() {
            return earn;
        }

        public void setEarn(int earn) {
            this.earn = earn;
        }
    }
}

