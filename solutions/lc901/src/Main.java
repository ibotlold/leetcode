import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        StockSpanner solution = new StockSpanner();
        System.out.println(solution.next(100));
        System.out.println(solution.next(80));
        System.out.println(solution.next(60));
        System.out.println(solution.next(70));
        System.out.println(solution.next(60));
        System.out.println(solution.next(75));
        System.out.println(solution.next(85));
    }
}

class StockSpanner {
    ArrayList<Integer> history = new ArrayList<>();
    public StockSpanner() {

    }

    public int next(int price) {
        int lastIndex = history.size();
        history.add(price);
        int counter = 0;
        for (int i = lastIndex; i >= 0; i--) {
            if (price >= history.get(i)) counter++;
            else return counter;
        }
        return counter;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */