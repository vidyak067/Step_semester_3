package session_four_arrays.class_problems;

public class BestTimeToBuySellStock {
    static int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int best = 0;

        for (int price : prices) {
            if (price < lowest) {
                lowest = price;
            }
            int profit = price - lowest;
            if (profit > best) {
                best = profit;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
