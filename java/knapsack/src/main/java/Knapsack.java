import static java.lang.Math.max;

import java.util.List;

class Knapsack {

    public int maximumValue(int capacity, List<Item> items) {
        return maximumValue(capacity, items, items.size());
    }

    private int maximumValue(int capacity, List<Item> items, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        var currentItem = items.get(n - 1);
        if (currentItem.weight() > capacity) {
            return maximumValue(capacity, items, n - 1);
        } else {
            var includeItem = currentItem.value() + maximumValue(capacity - currentItem.weight(), items, n - 1);
            var excludeItem = maximumValue(capacity, items, n - 1);
            return max(includeItem, excludeItem);
        }
    }
}
