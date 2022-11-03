public class Main {
    public static void main(String[] args) {
//        new Solution().countBits(5);
        new Slide().countBits(23);
    }
}

interface Solution {
    int[] countBits(int n);
}

class Shift implements Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            if ((i % 2) == 0) {
                result[i] = result[i >> 1];
            } else {
                result[i] = result[i - 1] + 1;
            }
        }
        return result;
    }
}

class Slide implements Solution {
    public int[] countBits(int n) {
        final int size = n + 1;
        int[] result = new int[size];
        result[0] = 0;
        if (n > 0) result[1] = 1;
        int first = 0;
        for (int i = 2; i < size; i++) {
            double pow = Math.log(i)/Math.log(2);
            if (pow % 1 == 0) {
                first++;
                result[i] = 1;
                continue;
            }
            int bitCount = (int) pow;
            result[i] = 1 + result[i - (int) Math.pow(2, bitCount)];
        }
        return result;
    }
}