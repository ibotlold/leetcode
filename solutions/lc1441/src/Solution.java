import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        int cursor = 0;
        ArrayList<String> operationList = new ArrayList<>(target.length);
        for (int i = 1; i <= n && cursor < target.length; i++) {
            operationList.add("Push");
            if (target[cursor] != i) {
                operationList.add("Pop");
            } else {
                cursor++;
            }
        }
        return operationList;
    }
}