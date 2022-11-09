import java.util.ArrayDeque;

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
    final ArrayDeque<Node> stack = new ArrayDeque<>();

    record Node(int price, int count) { }

    public StockSpanner() {

    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            count += stack.pop().count;
        }
        stack.push(new Node(price, count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */