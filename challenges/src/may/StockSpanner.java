package may;

import java.util.LinkedList;
import java.util.Stack;

class StockSpanner {

    private Stack<int[]> prices;
    public StockSpanner() {
        prices = new Stack<>();
    }

    public int next(int price) {

        int count = 1;
        while(!prices.isEmpty() && prices.peek()[0] <= price) {
            count += prices.peek()[1];
            prices.pop();
        }

        prices.add(new int[]{price, count});

        return count;
    }
}
